package cn.com.ctsi.busiobj.dao.impl;


import cn.com.ctsi.busiobj.bean.base.BusinessDataEntity;
import cn.com.ctsi.busiobj.dao.BusiTableDao;
import cn.com.ctsi.busiobj.dao.SpringJdbcDao;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BusiTableDaoImpl extends SpringJdbcDao implements BusiTableDao {

    public static final String TABLE="bussiness_data";

    @Resource(name = "jdbcTemplate")
    public void setMySessionFactory(JdbcTemplate jdbcTemplate) {
        super.setJdbcTemplate(jdbcTemplate);
    }



    /**
     * 到业务数据表，做(enterpriseId + name)的唯一性校验
     * @param entId
     * @param name
     * @return
     */
    @Override
    public Boolean isExist(Integer entId, String name) throws Exception{
        try{
            String sql="SELECT COUNT(*) FROM "+TABLE+" WHERE ent_id= :entId and name= :name";
            MapSqlParameterSource args=new MapSqlParameterSource();
            args.addValue("entId",entId);
            args.addValue("name",name);
            int count=getNamedParameterJdbcTemplate().queryForObject(sql, args, new RowMapper<Integer>() {
                @Nullable
                @Override
                public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return rs.getInt("count");
                }
            });
            if(count>0){
                return true;
            }
        }catch (DataAccessException e) {
            logger.error(e.getMessage());
            throw new Exception("The column data is not existed,"+e.getMessage(), e);
        }
        return false;
    }

    public BusinessDataEntity findByTableId(Integer tableId)throws Exception{
        try{
            String sql="SELECT * FROM "+TABLE+" WHERE table_id= :tableId";
            MapSqlParameterSource args=new MapSqlParameterSource();
            args.addValue("tableId",tableId);
            BusinessDataEntity bdData=getNamedParameterJdbcTemplate().queryForObject(sql, args, new BusinessDataEntityMapper() );
            Assert.notNull(bdData,"tableId 对应的业务数据不存在");
            return bdData;
        }catch (DataAccessException e) {
            logger.error(e.getMessage());
            throw new Exception("tableId对应的业务数据不存在,"+e.getMessage(), e);
        }
    }

    public Integer insert(Integer entId, String name,String descr,Integer tableId) throws Exception{
       try{
           SimpleJdbcInsert insert = new SimpleJdbcInsert(getJdbcTemplate());
           insert.withTableName("bussiness_data");
           insert.usingColumns("ent_id", "name", "descr", "create_time", "last_edit_time", "table_id")
                   .usingGeneratedKeyColumns("id");
           Map<String, Object> args = new HashMap<>();
           args.put("ent_id", entId);
           args.put("name", name);
           args.put("descr", descr);
           Date date=new Date();
           args.put("create_time", date);
           args.put("last_edit_time", date);
           args.put("table_id", tableId);
           insert.compile();
           return insert.executeAndReturnKey(args).intValue();
       }catch (Exception e){
           logger.error(e.getMessage());
           throw new Exception("添加业务数据发生异常，"+e.getMessage(), e);
       }
    }

    public Integer updateById(Integer id) throws Exception{
        try{
            String sql="UPDATE "+TABLE+ " SET last_edit_time= :now WHERE id= :id";
            MapSqlParameterSource ps = new MapSqlParameterSource();
            ps.addValue("id",id);
            ps.addValue("now",new Date());
            return getNamedParameterJdbcTemplate().update(sql, ps);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new Exception("updateById 发生异常", e);
        }
    }

    @Override
    public void delete(Integer entId, String name) throws Exception {
        try{
            String sql="DELETE FROM "+ TABLE + " WHERE ent_id = :entId and name = :name";
            MapSqlParameterSource ps = new MapSqlParameterSource();
            ps.addValue("entId", entId);
            ps.addValue("name", name);
            getNamedParameterJdbcTemplate().update(sql, ps);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new Exception("删除业务数据失败,"+e.getMessage(),e);
        }
    }

    /**
     * 根据entId和name更新业务数据表bussiness_data
     * @param entId 企业Id
     * @param name 表名
     * @return 更新的bussiness_data行的id
     * @throws Exception
     */
    @Override
    public Integer updateByEntIdAndTableName(Integer entId, String name) throws Exception {
        try{
            String sql="UPDATE "+TABLE+ " SET last_edit_time= :now WHERE ent_id= :entId and name= :name";
            MapSqlParameterSource ps = new MapSqlParameterSource();
            ps.addValue("entId",entId);
            ps.addValue("name",name);
            ps.addValue("now",new Date());
            return getNamedParameterJdbcTemplate().update(sql, ps);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new Exception("根据entId和name更新业务数据表发生异常,"+e.getMessage(), e);
        }
    }

    @Override
    public BusinessDataEntity findByEntIdAndName(Integer entId, String name) throws Exception {
        try{
            String sql="SELECT * FROM "+TABLE+" WHERE ent_id= :entId and name= :name";
            MapSqlParameterSource args=new MapSqlParameterSource();
            args.addValue("entId",entId);
            args.addValue("name",name);
            BusinessDataEntity bdData=getNamedParameterJdbcTemplate().queryForObject(sql, args, new BusinessDataEntityMapper() );
            Assert.notNull(bdData,"entId和name对应的业务数据BusinessDataEntity不存在");
            return bdData;
        }catch (Exception e) {
            logger.error(e.getMessage());
            throw new Exception("findByEntIdAndName 异常"+e.getMessage(), e);
        }
    }

    protected class BusinessDataEntityMapper implements RowMapper<BusinessDataEntity>{

    public BusinessDataEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

        BusinessDataEntity bdEntity = new BusinessDataEntity();
        bdEntity.setId(rs.getInt("id"));
        bdEntity.setName(rs.getString("name"));
        bdEntity.setEntId(rs.getInt("ent_id"));
        bdEntity.setTableId(rs.getInt("table_id"));
        bdEntity.setCreateTime(rs.getDate("create_time"));
        bdEntity.setDescription(rs.getString("descr"));
        bdEntity.setLastEditTime(rs.getDate("last_edit_time"));
        return bdEntity;
    }
}


}
