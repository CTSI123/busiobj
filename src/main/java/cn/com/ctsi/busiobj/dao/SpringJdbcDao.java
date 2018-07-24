package cn.com.ctsi.busiobj.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import java.util.Date;
import java.util.Map;

public class SpringJdbcDao extends NamedParameterJdbcDaoSupport {

    public SpringJdbcDao() {
    }

    public Date getSysDate() {
        String sql = "select sysdate as t from dual";
        Map<String, Object> time = this.getJdbcTemplate().queryForMap(sql);
        return new Date(time.get("t").toString());
    }

    public int getNextRowID(String seqName) {
        String sql = "select " + seqName + ".nextval from dual";
        return ((Integer)this.getJdbcTemplate().queryForObject(sql, Integer.class)).intValue();
    }

    public Integer findCount(String subSql, MapSqlParameterSource args, String tableName) {
        String sql = "select count(*) from " + tableName + " " + subSql;
        return (Integer)this.getNamedParameterJdbcTemplate().queryForObject(sql, args, Integer.class);
    }

    public Integer findCount(String subSql, MapSqlParameterSource args) {
        String sql = "select count(*) from  (" + subSql + ") t";
        return (Integer)this.getNamedParameterJdbcTemplate().queryForObject(sql, args, Integer.class);
    }

    public String getLimitString(String sql, boolean hasOffset) {
        StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);
        if (hasOffset) {
            pagingSelect.append(sql + " limit :recNumPerPage offset :startNum");
        } else {
            pagingSelect.append(sql + " limit :recNumPerPage offset 0");
        }

        return pagingSelect.toString();
    }
}
