package cn.com.ctsi.busiobj.dao;


import cn.com.ctsi.busiobj.bean.base.BusinessDataEntity;


public interface BusiTableDao {

    public abstract Boolean isExist(Integer entId,String name)throws Exception;

    public abstract BusinessDataEntity findByTableId(Integer tableId)throws Exception;

    public abstract Integer insert(Integer entId, String name,String desc,Integer tableId) throws Exception;

    public abstract Integer updateById(Integer id) throws Exception;

    public abstract void delete(Integer entId, String name) throws Exception;

    public abstract Integer updateByEntIdAndTableName(Integer entId,String name) throws Exception;

    public abstract BusinessDataEntity findByEntIdAndName(Integer entId,String name) throws Exception;

}
