package cn.com.ctsi.busiobj.service;

import cn.com.ctsi.busiobj.bean.base.*;
import cn.com.ctsi.busiobj.bean.request.cdm.data.*;
import cn.com.ctsi.busiobj.bean.request.cdm.table.*;
import cn.com.ctsi.busiobj.bean.request.common.BaseRequest;
import cn.com.ctsi.busiobj.bean.response.cdm.data.*;
import cn.com.ctsi.busiobj.bean.response.cdm.table.CdmTemplateTableQueryRes;

import java.util.List;


public interface CdmApiService {

    public Integer sendCreateCdmTemplateTableReq(CdmTemplateTableCreateReq cctReq)throws Exception;

    public void sendDeleteCdmTemplateTableReq(CdmTemplateTableDeleteReq ctdReq) throws Exception;

    public void sendUpateCdmTemplateTableReq(CdmTemplateTableUpdateReq ctuReq) throws Exception;

    public CdmTemplateTableQueryRes sendQueryCdmTemplateTableReq(CdmTemplateTableQueryReq ctqReq) throws Exception;

    public Integer sendInsertCdmTemplateDataReq(CdmTemplateDataInsertReq cdmTemplateDataInsertReq) throws Exception;

    public void sendDeleteCdmTemplateDataReq(CdmTemplateDataDeleteReq cdmTemplateDataDeleteReq) throws Exception;

    public void sendUpdateCdmTemplateDataReq(CdmTemplateDataUpdateReq cdmTemplateDataUpdateReq) throws Exception;

    public CdmTemplateDataQueryByIdRes sendCdmTemplateDataQueryByIdReq(CdmTemplateDataQueryByIdReq cdmTemplateDataQueryByIdReq) throws Exception;

    public CdmTemplateDataQueryListRes sendCdmTemplateDataQueryListReq(CdmQueryTemplateDataListReq cdmQueryTemplateDataListReq) throws Exception;

    public List<Column> getRealColumnList(String tableId, Integer entId)throws Exception;

    public TableReq jointCdmTemplateTableReq(BaseRequest request, String entKey, String[] tableNames);

    public DataReq jointCdmTemplateDataRequest(UserRequest request, String tableName, String entKey, Integer tableId) throws Exception;

    public List<SelectFilter> getSelectFilter(List<String> selectList,List<Column> columnList);
}
