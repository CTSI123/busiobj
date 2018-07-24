package cn.com.ctsi.busiobj.service;



import cn.com.ctsi.busiobj.bean.request.busiobj.table.CreateTemplateTableRequest;
import cn.com.ctsi.busiobj.bean.request.busiobj.table.DeleteTemplateTableRequest;
import cn.com.ctsi.busiobj.bean.request.busiobj.table.QueryTemplateTableRequest;
import cn.com.ctsi.busiobj.bean.request.busiobj.table.UpdateTemplateTableReuest;
import cn.com.ctsi.busiobj.bean.response.busiobj.BOTableQueryAppRes;
import cn.com.ctsi.busiobj.bean.response.busiobj.BOTableQueryRes;
import cn.com.ctsi.busiobj.bean.response.busiobj.BOTableQueryWebRes;

public interface BusiTableService {

    public abstract Integer createCdmTemplateTable(CreateTemplateTableRequest req) throws Exception;

    public abstract void deleteCdmTemplateTable(DeleteTemplateTableRequest req) throws Exception;

    public abstract void updateCdmTemplateTable(UpdateTemplateTableReuest req) throws Exception;

    public abstract BOTableQueryRes queryCdmTemplateTable(QueryTemplateTableRequest req) throws Exception;

    public abstract BOTableQueryWebRes queryCdmTemplateTableWeb(QueryTemplateTableRequest req) throws Exception;

    public abstract BOTableQueryAppRes queryCdmTemplateTableApp(QueryTemplateTableRequest req) throws Exception;
}
