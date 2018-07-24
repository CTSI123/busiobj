package cn.com.ctsi.busiobj.service.impl;

import cn.com.ctsi.busiobj.bean.base.*;
import cn.com.ctsi.busiobj.bean.request.busiobj.data.*;
import cn.com.ctsi.busiobj.bean.request.busiobj.table.CreateTemplateTableRequest;
import cn.com.ctsi.busiobj.bean.request.busiobj.table.DeleteTemplateTableRequest;
import cn.com.ctsi.busiobj.bean.request.busiobj.table.QueryTemplateTableRequest;
import cn.com.ctsi.busiobj.bean.request.busiobj.table.UpdateTemplateTableReuest;
import cn.com.ctsi.busiobj.bean.request.cdm.data.*;
import cn.com.ctsi.busiobj.bean.request.cdm.table.*;
import cn.com.ctsi.busiobj.bean.request.common.BaseRequest;
import cn.com.ctsi.busiobj.bean.response.busiobj.BOTableQueryRes;
import cn.com.ctsi.busiobj.bean.response.busiobj.GetUserIdByMdnAndEntKeyRes;
import cn.com.ctsi.busiobj.bean.response.cdm.data.*;
import cn.com.ctsi.busiobj.bean.response.cdm.table.CdmTemplateTableDeleteRes;
import cn.com.ctsi.busiobj.bean.response.cdm.table.CdmTemplateTableQueryRes;
import cn.com.ctsi.busiobj.bean.response.cdm.table.CdmTemplateTableUpdateRes;
import cn.com.ctsi.busiobj.bean.response.cdm.table.CdmCreateTemplateTableRes;
import cn.com.ctsi.busiobj.client.PermissionApi;
import cn.com.ctsi.busiobj.service.BusiTableService;
import cn.com.ctsi.busiobj.service.CdmApiService;
import cn.com.ctsi.busiobj.util.BaseBean;
import cn.com.ctsi.busiobj.util.FeignClientApiUtil;
import cn.com.ctsi.busiobj.util.LogUtil;
import cn.com.ctsi.busiobj.util.ParamUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Service(value="cdmApiService")
public class CdmApiServiceImpl implements CdmApiService {

    @Autowired
    PermissionApi permissionApi;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    BusiTableService busiTableService;

    @Autowired
    FeignClientApiUtil feignClientApiUtil;


    @Value("${cdm.template.base.url}")
    String cdmTemplateBaseUrl;

    @Value("${cdm.table.create.url}")
    String tableCreateUrl;

    @Value("${cdm.table.delete.url}")
    String tableDeleteUrl;

    @Value("${cdm.table.update.url}")
    String tableUpdateUrl;

    @Value("${cdm.table.query.url}")
    String tableQueryUrl;

    @Value("${cdm.data.insert.url}")
    String dataInsertUrl;

    @Value("${cdm.data.delete.url}")
    String dataDeleteUrl;

    @Value("${cdm.data.update.url}")
    String dataUpdateUrl;

    @Value("${cdm.data.query.byid.url}")
    String dataQueryByIdUrl;

    @Value("${cdm.data.query.list.url}")
    String dataQueryListUrl;




    /**
     *
     * @param cctReq
     * @return
     * @throws Exception
     */
    public Integer sendCreateCdmTemplateTableReq(CdmTemplateTableCreateReq cctReq)throws Exception{
        try{
            CdmCreateTemplateTableRes cdmCreateTemplateTableRes =restTemplate.postForObject(cdmTemplateBaseUrl+tableCreateUrl,cctReq,CdmCreateTemplateTableRes.class);
            Assert.notNull(cdmCreateTemplateTableRes,"调用CDM接口，创建业务数据表失败返回为null");
            int code= cdmCreateTemplateTableRes.getStatus().getCode();
            Assert.isTrue((code==Status.CODE_SUCCESS),"sendCreateCdmTemplateTableReq 创建业务数据表失败,"+ cdmCreateTemplateTableRes.getStatus().getDesc());
            Integer tableId= cdmCreateTemplateTableRes.getContent().getTableId();
            Assert.notNull(tableId,"创建业务数据表失败返回tableId为null");
            return tableId;
        }catch (Exception e){
            LogUtil.logError("调用cdm接口创建业务数据表失败,"+e.getMessage()+",请求为"+cctReq,this.getClass());
            throw new Exception("调用cdm接口创建业务数据表失败,"+e.getMessage());
        }
    }

    /**
     * 调用CDM接口，删除业务数据表
     * @param ctdReq cdm删除表请求
     * @throws Exception
     */
    public void sendDeleteCdmTemplateTableReq(CdmTemplateTableDeleteReq ctdReq) throws Exception{
        try{
            CdmTemplateTableDeleteRes ctdRes=restTemplate.postForObject(cdmTemplateBaseUrl+tableDeleteUrl,ctdReq,CdmTemplateTableDeleteRes.class);
            Assert.notNull(ctdRes,"调用CDM接口，删除业务数据表返回为null");
            int code=ctdRes.getStatus().getCode();
            Assert.isTrue((code==Status.CODE_SUCCESS),"sendDeleteCdmTemplateTableReq 删除cdm实体数据表失败");
        }catch (Exception e){
            LogUtil.logError("调用cdm接口删除业务数据表失败,"+e.getMessage()+",请求为"+ctdReq,this.getClass());
            throw new Exception("调用cdm接口删除业务数据表失败,"+e.getMessage());
        }
    }

    /**
     * 调用CDM接口，更新业务数据表
     * @param ctuReq
     * @throws Exception
     */
    public void sendUpateCdmTemplateTableReq(CdmTemplateTableUpdateReq ctuReq) throws Exception{
        try{
            CdmTemplateTableUpdateRes ctuRes=restTemplate.postForObject(cdmTemplateBaseUrl+tableUpdateUrl,ctuReq,CdmTemplateTableUpdateRes.class);
            Assert.notNull(ctuRes,"调用CDM接口更新业务数据表返回为null");
            int code=ctuRes.getStatus().getCode();
            Assert.isTrue((code==Status.CODE_SUCCESS),"sendUpateCdmTemplateTableReq 更新cdm实体数据表失败"+ctuRes.getStatus().getDesc());
        }catch (Exception e){
            LogUtil.logError("调用cdm接口更新业务数据表失败,"+e.getMessage()+",请求为"+ctuReq,this.getClass());
            throw new Exception("调用cdm接口更新业务数据表失败,"+e.getMessage());
        }
    }

    /**
     * 调用CDM接口，查询业务数据表
     * @param ctqReq
     * @return
     * @throws Exception
     */
    public CdmTemplateTableQueryRes sendQueryCdmTemplateTableReq(CdmTemplateTableQueryReq ctqReq) throws Exception{
        try{
            CdmTemplateTableQueryRes ctqRes=restTemplate.postForObject(cdmTemplateBaseUrl+tableQueryUrl,ctqReq,CdmTemplateTableQueryRes.class);
            Assert.notNull(ctqRes,"调用CDM接口查询业务数据表返回为null");
            int code=ctqRes.getStatus().getCode();
            Assert.isTrue(code==Status.CODE_SUCCESS,"sendQueryCdmTemplateTableReq 查询业务数据表失败");
            Assert.notNull(ctqRes.getTables(),"查询获取的表信息为null");
            return ctqRes;
        }catch (Exception e){
            LogUtil.logError("调用cdm接口查询业务数据表失败,"+e.getMessage()+",请求为"+ctqReq,this.getClass());
            throw new Exception("调用cdm接口查询业务数据表失败,"+e.getMessage());
        }
    }


    /**
     * 调用CDM接口，添加业务数据
     * @param cdmTemplateDataInsertReq
     * @return 业务数据Id
     * @throws Exception
     */
    public Integer sendInsertCdmTemplateDataReq(CdmTemplateDataInsertReq cdmTemplateDataInsertReq) throws Exception{
        try{
            CdmTemplateDataCreateRes cdmTemplateDataCreateRes =restTemplate.postForObject(cdmTemplateBaseUrl+dataInsertUrl, cdmTemplateDataInsertReq,CdmTemplateDataCreateRes.class);
            Assert.notNull(cdmTemplateDataCreateRes,"调用CDM接口添加业务数据返回为null");
            int code= cdmTemplateDataCreateRes.getStatus().getCode();
            Assert.isTrue((code==Status.CODE_SUCCESS),"sendInsertCdmTemplateDataReq 失败,"+ cdmTemplateDataCreateRes.getStatus().getDesc());
            Integer dataId= cdmTemplateDataCreateRes.getContent().getDataId();
            Assert.notNull(dataId,"sendInsertCdmTemplateDataReq 添加业务数据返回dataId为null");
            return dataId;
        }catch (Exception e){
            LogUtil.logError("调用cdm接口添加业务数据失败,"+e.getMessage()+",请求为"+cdmTemplateDataInsertReq,this.getClass());
            throw new Exception("调用cdm接口添加业务数据失败,"+e.getMessage());
        }
    }

    public void sendDeleteCdmTemplateDataReq(CdmTemplateDataDeleteReq cdmTemplateDataDeleteReq) throws Exception{
        try{
            CdmTemplateDataDeleteRes cdmTemplateDataDeleteRes =restTemplate.postForObject(cdmTemplateBaseUrl+dataDeleteUrl, cdmTemplateDataDeleteReq,CdmTemplateDataDeleteRes.class);
            Assert.notNull(cdmTemplateDataDeleteRes,"sendDeleteCdmTemplateDataReq 调用CDM接口删除业务数据返回为null");
            int code= cdmTemplateDataDeleteRes.getStatus().getCode();
            Assert.isTrue((code==Status.CODE_SUCCESS),"sendDeleteCdmTemplateDataReq 删除业务数据失败,"+ cdmTemplateDataDeleteRes.getStatus().getDesc());
        }catch (Exception e){
            LogUtil.logError("调用cdm接口删除业务数据失败,"+e.getMessage()+",请求为"+cdmTemplateDataDeleteReq,this.getClass());
            throw new Exception("调用cdm接口删除业务数据失败,"+e.getMessage());
        }
    }

    /**
     * 调用CDM接口更新业务数据
     * @param cdmTemplateDataUpdateReq
     * @throws Exception
     */
    public void sendUpdateCdmTemplateDataReq(CdmTemplateDataUpdateReq cdmTemplateDataUpdateReq) throws Exception{
        try{
            CdmTemplateDataUpdateRes cdmTemplateDataUpdateRes =restTemplate.postForObject(cdmTemplateBaseUrl+dataUpdateUrl, cdmTemplateDataUpdateReq,CdmTemplateDataUpdateRes.class);
            Assert.notNull(cdmTemplateDataUpdateRes,"sendUpdateCdmTemplateDataReq 调用CDM接口更新业务数据返回为null");
            int code= cdmTemplateDataUpdateRes.getStatus().getCode();
            Assert.isTrue((code== Status.CODE_SUCCESS),"sendUpdateCdmTemplateDataReq 更新业务数据失败,"+ cdmTemplateDataUpdateRes.getStatus().getDesc());
        }catch (Exception e){
            LogUtil.logError("调用cdm接口更新业务数据失败,"+e.getMessage()+",请求为"+cdmTemplateDataUpdateReq,this.getClass());
            throw new Exception("调用cdm接口根据dataId查询业务数据失败，"+e.getMessage()+"请求信息为："+cdmTemplateDataUpdateReq);
        }
    }

    /**
     * 调用CDM接口根据Id查询业务数据
     * @param cdmTemplateDataQueryByIdReq
     * @return
     * @throws Exception
     */
    public CdmTemplateDataQueryByIdRes sendCdmTemplateDataQueryByIdReq(CdmTemplateDataQueryByIdReq cdmTemplateDataQueryByIdReq) throws Exception{
        try{
            CdmTemplateDataQueryByIdRes dqbIRes=restTemplate.postForObject(cdmTemplateBaseUrl+dataQueryByIdUrl, cdmTemplateDataQueryByIdReq,CdmTemplateDataQueryByIdRes.class);
            Assert.notNull(dqbIRes,"sendCdmTemplateDataQueryByIdReq 调用CDM接口查询业务数据返回为null");
            int code=dqbIRes.getStatus().getCode();
            Assert.isTrue((code== Status.CODE_SUCCESS),"sendCdmTemplateDataQueryByIdReq 根据dataId查询业务数据失败,"+dqbIRes.getStatus().getDesc());
            return dqbIRes;
        }catch (Exception e){
            LogUtil.logError("调用cdm接口根据dataId查询业务数据失败，"+e.getMessage()+"请求信息为："+cdmTemplateDataQueryByIdReq,this.getClass());
            throw new Exception("调用cdm接口根据dataId查询业务数据失败，"+e.getMessage()+"请求信息为："+cdmTemplateDataQueryByIdReq);
        }
    }

    /**
     * 调用CDM接口根据查询业务数据列表
     * @param cdmQueryTemplateDataListReq
     * @return
     * @throws Exception
     */
    public CdmTemplateDataQueryListRes sendCdmTemplateDataQueryListReq(CdmQueryTemplateDataListReq cdmQueryTemplateDataListReq) throws Exception{
        try{
            CdmTemplateDataQueryListRes cdqlRes=restTemplate.postForObject(cdmTemplateBaseUrl+dataQueryListUrl, cdmQueryTemplateDataListReq,CdmTemplateDataQueryListRes.class);
            Assert.notNull(cdqlRes,"sendCdmTemplateDataQueryListReq 调用CDM接口查询业务数据返回为null");
            int code=cdqlRes.getStatus().getCode();
            Assert.isTrue((code== Status.CODE_SUCCESS),"sendCdmTemplateDataQueryListReq 查询dataList失败"+cdqlRes.getStatus().getDesc());
            return cdqlRes;
        }catch (Exception e){
            LogUtil.logError("调用cdm接口查询dataList失败，"+e.getMessage()+"请求信息为："+cdmQueryTemplateDataListReq,this.getClass());
            throw new Exception("调用cdm接口查询dataList失败，"+e.getMessage()+"请求信息为："+cdmQueryTemplateDataListReq);
        }
    }




    /**
     * 拼接向cdm发送的Table请求
     * @param request
     * @param entKey
     * @param tableNames
     * @return
     */
    public TableReq jointCdmTemplateTableReq(BaseRequest request,String entKey,String[] tableNames){
        if(request instanceof CreateTemplateTableRequest){
            CreateTemplateTableRequest req=(CreateTemplateTableRequest)request;
            CdmTemplateTableCreateReq cctReq=new CdmTemplateTableCreateReq();
            Content content=new Content();
            content.setTableName(req.getTableName());
            content.setTableNameDesc(req.getTbDesc());
            content.setTableType(req.getTableType());
            content.setTableId(req.getTblId());
            cctReq.setContent(content);
            cctReq.setEntId(req.getEnterpriseId());
            cctReq.setKey(entKey);
            cctReq.setColumns(req.getColumnList());
            return cctReq;
        }else if(request instanceof DeleteTemplateTableRequest){
            DeleteTemplateTableRequest req=(DeleteTemplateTableRequest)request;
            CdmTemplateTableDeleteReq cdmTemplateTableDeleteReq =new CdmTemplateTableDeleteReq();
            cdmTemplateTableDeleteReq.setTableName(tableNames[0]);
            cdmTemplateTableDeleteReq.setKey(entKey);
            cdmTemplateTableDeleteReq.setTableId(req.getTableId());
            cdmTemplateTableDeleteReq.setEntId(req.getEnterpriseId());
            return cdmTemplateTableDeleteReq;
        }else if(request instanceof UpdateTemplateTableReuest){
            UpdateTemplateTableReuest req=(UpdateTemplateTableReuest)request;
            CdmTemplateTableUpdateReq cdmTemplateTableUpdateReq =new CdmTemplateTableUpdateReq();
            cdmTemplateTableUpdateReq.setTableName(tableNames[0]);
            cdmTemplateTableUpdateReq.setTableId(req.getContentUpdate().getTableId());
            cdmTemplateTableUpdateReq.setOp(req.getOp());
            cdmTemplateTableUpdateReq.setColumns(req.getColumns());
            Content content=new Content();
            content.setTableId(req.getContentUpdate().getTableId());
            content.setTableName(tableNames[0]);
            content.setTableNameDesc(req.getContentUpdate().getTableNameDesc());
            content.setTableType(req.getContentUpdate().getTableType());
            cdmTemplateTableUpdateReq.setContent(content);
            cdmTemplateTableUpdateReq.setKey(entKey);
            return cdmTemplateTableUpdateReq;
        }else if(request instanceof QueryTemplateTableRequest){
            QueryTemplateTableRequest req=(QueryTemplateTableRequest)request;
            CdmTemplateTableQueryReq cdmTemplateTableQueryReq =new CdmTemplateTableQueryReq();
            cdmTemplateTableQueryReq.setTableIds(req.getTableIds());
            cdmTemplateTableQueryReq.setTableNames(tableNames);
            cdmTemplateTableQueryReq.setKey(entKey);
            return cdmTemplateTableQueryReq;
        }
        return null;
    }


    /**
     * 拼接向cdm发送的Data请求
     * @param request
     * @param tableName
     * @param entKey
     * @param tableId
     * @return
     */
    public DataReq jointCdmTemplateDataRequest(UserRequest request,String tableName, String entKey,Integer tableId) throws Exception {
        if(request instanceof CreateTemplateDataRequest){
            CreateTemplateDataRequest cdReq=(CreateTemplateDataRequest)request;
            CdmTemplateDataInsertReq cdmTemplateDataInsertReq =new CdmTemplateDataInsertReq();
            cdmTemplateDataInsertReq.setTableId(cdReq.getTableId());
            cdmTemplateDataInsertReq.setData(insertData(cdReq,entKey));
            cdmTemplateDataInsertReq.setEntId(cdReq.getEnterpriseId());
            cdmTemplateDataInsertReq.setTableName(tableName);
            cdmTemplateDataInsertReq.setKey(entKey);
            cdmTemplateDataInsertReq.setTableId(tableId);
            return cdmTemplateDataInsertReq;
        }else if(request instanceof DeleteTemplateDataRequest){
            DeleteTemplateDataRequest ddReq=(DeleteTemplateDataRequest)request;
            CdmTemplateDataDeleteReq cddReq=new CdmTemplateDataDeleteReq();
            cddReq.setDataIds(ddReq.getDataIds());
            cddReq.setTableName(tableName);
            cddReq.setTableId(tableId);
            cddReq.setEntId(ddReq.getEnterpriseId());
            cddReq.setKey(entKey);
            return cddReq;
        }else if(request instanceof UpdateTemplateDataRequest){
            UpdateTemplateDataRequest udReq=(UpdateTemplateDataRequest)request;
            CdmTemplateDataUpdateReq cduReq=new CdmTemplateDataUpdateReq();
            cduReq.setData(updateData(udReq,entKey));
            cduReq.setDataId(udReq.getDataId());
            cduReq.setKey(entKey);
            cduReq.setTableName(tableName);
            cduReq.setTableId(tableId);
            cduReq.setEntId(udReq.getEnterpriseId());
            return cduReq;
        } else if(request instanceof QueryTemplateDataListRequest){
            QueryTemplateDataListRequest qdlReq=(QueryTemplateDataListRequest)request;
            CdmQueryTemplateDataListReq cqdlReq=new CdmQueryTemplateDataListReq();
            cqdlReq.setPage(qdlReq.getPage());
            cqdlReq.setPageSize(qdlReq.getPageSize());
            joinFileters(qdlReq,cqdlReq);
            cqdlReq.setPageSize(qdlReq.getPageSize());
            cqdlReq.setKey(entKey);
            cqdlReq.setTableName(tableName);
            cqdlReq.setTableId(tableId);
            return cqdlReq;
        }
        return null;
    }

    public void joinFileters(QueryTemplateDataListRequest qdlReq,CdmQueryTemplateDataListReq cqdlReq)throws Exception{
        List<Column> columnList=getRealColumnList(qdlReq.getTableId().toString(),qdlReq.getEnterpriseId());
        Filter filter=new Filter();
        List<String> selectList=qdlReq.getSelect();
        Map<String,Object> where=qdlReq.getWhere();
        Map<String,Object> order=qdlReq.getOrder();

        List<SelectFilter> selectFilterList=getSelectFilter(selectList,columnList);
        filter.setSelect(selectFilterList);

        if(where!=null&&where.size()>0){
            WhereFilter whereFilter=getWhereFilter(where,columnList,qdlReq.getEnterpriseId(),qdlReq.getTableId());
            filter.setWhere(whereFilter);
        }
        List<OrderFilter> orderFilterList=getOrderFilter(order);
        filter.setOrder(orderFilterList);
        cqdlReq.setFilter(filter);
    }


    /**
     * 依据查询列的列类型设置查询条件中的查询类型（equal  like）
     * @param entId
     * @param tableId
     * @param colName
     * @param columnList
     * @return
     * @throws Exception
     */
    public Integer getCommonWhereColType(Integer entId,Integer tableId,String colName,List<Column> columnList)throws Exception{
        Integer whereType=null;
        for(Column column:columnList){
            if(column.getColumnName().equals(colName)){
                Integer colType=column.getColumnType();
                if(colType!=null){
                    if(colType.equals(ParamUtil.getColumnTypeString())||colType.equals(ParamUtil.getColumnTypeText())){
                        whereType=ParamUtil.getWhereFilterTypeLike();
                    }else if(colType.equals(ParamUtil.getColumnTypeBool())||colType.equals(ParamUtil.getColumnTypeInteger())||
                            colType.equals(ParamUtil.getColumnTypeDouble())||colType.equals(ParamUtil.getColumnTypeFloat())||
                            colType.equals(ParamUtil.getColumnTypeKeyValueRadio())){
                        whereType=ParamUtil.getWhereFilterTypeEqual();
                    }
                    Assert.notNull(whereType,"whereFilter中column的type为null");
                    return whereType;
                }
            }
        }
        return null;
    }



    /**
     * 将cdReq中的添加数据转换为cdm需要的数据格式
     * 对每一行添加创建人，添加最后修改人，创建时间，最后修改时间,需要针对当行增加数据或者批量添加数据编程
     * @param
     * @return
     */

    public List<Data> insertData(CreateTemplateDataRequest cdReq, String entKey)throws Exception{
        List<Map<String,Object>> rowList=cdReq.getRowList();
        Date date=new Date();
        List<Data> dataList=new ArrayList<>();


        List<Column> columnList=getRealColumnList(cdReq.getTableId().toString(),cdReq.getEnterpriseId());
        List<String>  colName=new ArrayList<>();
        Integer addUserId=feignClientApiUtil.getUserId(entKey,cdReq.getMdn());

        for(Map<String,Object> row:rowList) {
            Iterator<Map.Entry<String, Object>> it = row.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Object> entry = it.next();
                Data data = new Data();
                data.setKey(entry.getKey());//columnName

                for (Column col : columnList) {
                    if (col.getColumnName().equals(entry.getKey())) {
                        if(entry.getValue()==null&&!col.getIsNullable()){//该列不可为空，但是添加数据中该列传入了空值
                            LogUtil.logError("列"+entry.getKey()+"不可为空，待添加数据中该列传入了null",this.getClass());
                            throw new Exception("列"+entry.getKey()+"不可为空，待添加数据中该列传入了null");
                        }

                        if (!entry.getValue().toString().equals("")&&entry.getValue()!=null) {
                            if (col.getColumnType() == ParamUtil.getColumnTypeBool()) {
                                if(entry.getValue().equals(0)){
                                    data.setValue(false);
                                }else if(entry.getValue().equals(1)){
                                    data.setValue(true);
                                }
                            } else if (col.getColumnType() == ParamUtil.getColumnTypeInteger() || col.getColumnType() == ParamUtil.getColumnTypeKeyValueRadio()) {
                                data.setValue(Integer.valueOf(entry.getValue().toString()));//columnValue
                            } else if (col.getColumnType() == ParamUtil.getColumnTypeFloat()) {
                                data.setValue(Float.valueOf(entry.getValue().toString()));//columnValue
                            } else if (col.getColumnType() == ParamUtil.getColumnTypeDouble()) {
                                data.setValue(Double.valueOf(entry.getValue().toString()));
                            } else if (col.getColumnType() == ParamUtil.getColumnTypeDatetime()) {
                                data.setValue(Long.valueOf(entry.getValue().toString()));
                            }else if(col.getColumnType() == ParamUtil.getColumnTypeKeyValueCheck()){//去除值中的中括号
                                data.setValue(entry.getValue().toString().substring(1,entry.getValue().toString().lastIndexOf("]")));
                            } else {
                                data.setValue(entry.getValue().toString());
                            }
                            colName.add(data.getKey());
                            dataList.add(data);
                        }
                    }
                }
            }
        }

        if(!colName.contains("organization_id")){
            LogUtil.logError("organization_id列为非空，添加数据时必须给此列传值",this.getClass());
            throw new Exception("organization_id列为非空，添加数据时必须给此列传值");
        }

            if(!colName.contains("add_user")){
                Data data21=new Data();
                data21.setKey("add_user");
                data21.setValue(addUserId.toString());
                dataList.add(data21);
            }
            if(!colName.contains("add_time")){
                Data dataAddTime=new Data();
                dataAddTime.setKey("add_time");
                dataAddTime.setValue(date.getTime());
                dataList.add(dataAddTime);
            }
            if(!colName.contains("modify_user")){
                Data dataModifyUser=new Data();
                dataModifyUser.setKey("modify_user");
                dataModifyUser.setValue(addUserId.toString());
                dataList.add(dataModifyUser);
            }

            if(!colName.contains("modify_time")){
                Data dataModifyTime=new Data();
                dataModifyTime.setKey("modify_time");
                dataModifyTime.setValue(date.getTime());
                dataList.add(dataModifyTime);
            }

        return dataList;
    }


    /**
     * 将UpdateTemplateDataRequest中的更新数据转换为cdm需要的数据更新形式
     * @param udReq
     * @param entKey
     * @return
     * @throws Exception
     */
    public List<Data> updateData(UpdateTemplateDataRequest udReq,String entKey)throws Exception{
        Map<String,Object> data=udReq.getData();

        List<Data> dataList=new ArrayList<>();
        List<Column> columnList=getRealColumnList(udReq.getTableId().toString(),udReq.getEnterpriseId());

        Set<String> upCol=data.keySet();
        List<String> colName=new ArrayList<>();
        for(String col:upCol){
            if(data.get(col)!=null&&data.get(col).toString().length()>0){
                for (Column column : columnList) {
                    if (column.getColumnName().equals(col)){
                        Data d=new Data();
                        if(column.getColumnType().equals(ParamUtil.getColumnTypeBool())){
                            if(data.get(col).equals(1)){
                                d.setKey(col);
                                d.setValue(true);
                                colName.add(col);
                                dataList.add(d);
                            }else if(data.get(col).equals(0)){
                                d.setKey(col);
                                d.setValue(false);
                                colName.add(col);
                                dataList.add(d);
                            }
                        } else if(column.getColumnType().equals(ParamUtil.getColumnTypeDouble())){
                            d.setKey(col);
                            d.setValue(Double.valueOf(data.get(col).toString()));
                            colName.add(col);
                            dataList.add(d);
                        }else if(column.getColumnType().equals(ParamUtil.getColumnTypeInteger())){
                            d.setKey(col);
                            d.setValue(Integer.valueOf(data.get(col).toString()));
                            colName.add(col);
                            dataList.add(d);
                        }else if(column.getColumnType().equals(ParamUtil.getColumnTypeKeyValueCheck())){
                            if(data.get(col)!=null&&data.get(col).toString().split(",").length>0&&!data.get(col).toString().equals("[]")){
                                    if(col.lastIndexOf("Desc")>0){
                                        d.setKey(col.substring(0,col.lastIndexOf("Desc")));
                                    }else{
                                        d.setKey(col);
                                    }
                                    d.setValue(Integer.valueOf(data.get(col).toString()));
                                    colName.add(col);
                                    dataList.add(d);
                            }
                        }else if(column.getColumnType().equals(ParamUtil.getColumnTypeKeyValueRadio())){
                            if(col.lastIndexOf("Desc")>0){
                                d.setKey(col.substring(0,col.lastIndexOf("Desc")));
                            }else{
                                d.setKey(col);
                            }
                                d.setValue(Integer.valueOf(data.get(col).toString()));
                                colName.add(col);
                                dataList.add(d);
                        }else if(column.getColumnType().equals(ParamUtil.getColumnTypeString())){
                            d.setKey(col);
                            d.setValue(data.get(col).toString());
                            colName.add(col);
                            dataList.add(d);
                        } else{
                                d.setKey(col);
                                d.setValue(data.get(col));
                                colName.add(col);
                                dataList.add(d);
                        }
                    }
                }
            }else{
                for (Column column : columnList) {
                    if (column.getColumnName().equals(col)){
                        if(!column.getIsNullable()){
                            LogUtil.logError("列"+col+"不可为空，待更新数据中该列传入了空值: "+data.get(col),this.getClass());
                            throw new Exception("列"+col+"不可为空，待更新数据中该列传入了空值："+data.get(col));
                        }
                    }
                }

            }

        }

        if(!colName.contains("modify_user")){
            Data data1=new Data();
            data1.setKey("modify_user");
            Integer userId=feignClientApiUtil.getUserId(entKey,udReq.getMdn());
            data1.setValue(userId.toString());
            dataList.add(data1);
        }

        if(!colName.contains("modify_time")){
            Data data2=new Data();
            data2.setKey("modify_time");
            data2.setValue(new Date().getTime());
            dataList.add(data2);
        }
        return dataList;
    }


    /**
     * 获得表中真正存在的列，去除当列类型为单选或者多选时候挂Desc后缀的描述列
     * @param tableId
     * @param entId
     * @return
     * @throws Exception
     */
    public List<Column> getRealColumnList(String tableId,Integer entId)throws Exception{
        QueryTemplateTableRequest req=new QueryTemplateTableRequest();
        req.setTableIds(tableId);
        req.setEntid(entId);
        BOTableQueryRes res=busiTableService.queryCdmTemplateTable(req);
        List<Column> columnList=res.getTables().get(0).getColumns();
        List<Column> colsToDel=new ArrayList<>();
        for(Column column:columnList){//首先过滤掉columnList中列类型为单选或多选中列名以Desc结尾的列
            if(column.getColumnType().equals(ParamUtil.getColumnTypeKeyValueRadio())||column.getColumnType().equals(ParamUtil.getColumnTypeKeyValueCheck())){
                if(column.getColumnName().contains("Desc")){
                    colsToDel.add(column);
                }
            }
        }
        columnList.removeAll(colsToDel);
        return columnList;
    }

    /**
     * 拼接select部分
     * @param selectList
     * @param columnList  表的全部实际列
     * @return
     */
    public List<SelectFilter> getSelectFilter(List<String> selectList,List<Column> columnList){
        List<SelectFilter> selectFilterList=new ArrayList<>();
        if(BaseBean.isNotEmpty(selectList)){
            if(!selectList.contains("id")){
                selectList.add("id");
            }

            for(String s:selectList){
                if(BaseBean.isEmpty(s)){
                    continue;
                }
                if(s.lastIndexOf("Desc")>0){//列名以Desc结尾
                    for (Column column : columnList){
                        if(column.getColumnType().equals(ParamUtil.getColumnTypeKeyValueCheck())||column.getColumnType().equals(ParamUtil.getColumnTypeKeyValueRadio())){//列类型是单选或多选
                            if(column.getColumnName().equals(s.substring(0,s.lastIndexOf("Desc")))){//列类型为单选或者多选，列名以Desc结尾
                                SelectFilter selectFilter=new SelectFilter();
                                selectFilter.setName(s.substring(0,s.lastIndexOf("Desc")));
                                selectFilter.setShow(true);
                                selectFilterList.add(selectFilter);
                            }else if(column.getColumnName().equals(s)){
                                SelectFilter selectFilter=new SelectFilter();
                                selectFilter.setName(s);
                                selectFilter.setShow(true);
                                selectFilterList.add(selectFilter);
                            }
                        }else{//列名以Desc结尾，但列不是单选多选类型
                            if(column.getColumnName().equals(s)){
                                SelectFilter selectFilter=new SelectFilter();
                                selectFilter.setName(s);
                                selectFilter.setShow(true);
                                selectFilterList.add(selectFilter);
                            }
                        }
                    }
                }else{//列不是以Desc结尾
                    SelectFilter selectFilter=new SelectFilter();
                    selectFilter.setName(s);
                    selectFilter.setShow(true);
                    selectFilterList.add(selectFilter);
                }
            }
        }else {//如果传进来的select为空则查询所有列的值
            for(Column col:columnList){
                SelectFilter selectFilter=new SelectFilter();
                selectFilter.setName(col.getColumnName());
                selectFilter.setShow(true);
                selectFilterList.add(selectFilter);
            }
        }
        return selectFilterList;
    }



    /**
     * 拼接where查询条件
     */
    public WhereFilter  getWhereFilter(Map<String,Object> where,List<Column> columnList,Integer entId,Integer tableId)throws Exception{
        try {
            //拼接where，目前只拼接and形式的where查询条件
            WhereFilter whereFilter = new WhereFilter();
            Iterator<String> whereIt = where.keySet().iterator();
            List<ColumnLimit> columnLimitList = new ArrayList<>();
            while (whereIt.hasNext()) {
                String whereCol = whereIt.next();
                if (where.get(whereCol) != null) {
                    for (Column column : columnList) {
                        if (column.getColumnName().equals(whereCol)) {

                            if (column.getColumnType().equals(ParamUtil.getColumnTypeDatetime())) {//日期类型查询类型为between
                                List dateValueList = (ArrayList) where.get(whereCol);
                                if (dateValueList != null && dateValueList.size() == 2) {
                                    StringBuilder dateValues = new StringBuilder();
                                    for (Object o : dateValueList) {
                                        dateValues.append(o.toString()).append(",");
                                    }
                                    dateValues.subSequence(0, dateValues.length() - 1);
                                    ColumnLimit dateCol = new ColumnLimit();
                                    dateCol.setName(whereCol);
                                    dateCol.setValue(dateValues.toString());
                                    dateCol.setType(ParamUtil.getWhereFilterTypeBetween());
                                    columnLimitList.add(dateCol);

                                }
                            } else if (column.getColumnType().equals(ParamUtil.getColumnTypeKeyValueCheck())) {//多选类型在数据库中存的值为多个key用逗号拼接成的字符串，所以查询类型为equal
                                List checkValueList = (ArrayList) where.get(whereCol);
                                if (where.get(whereCol) != null && !where.get(whereCol).toString().equals("[]") && where.get(whereCol).toString().length() > 0) {
                                    StringBuilder checkValues = new StringBuilder("'");
                                    for (Object checkValue : checkValueList) {
                                        checkValues.append(checkValue.toString()).append(",");
                                    }
                                    checkValues.subSequence(0, checkValues.length() - 1);
                                    checkValues.append("'");//因为多选在数据库中的存值为字符串类型，所以需要拼接单引号
                                    ColumnLimit columnLimit = new ColumnLimit();
                                    columnLimit.setName(whereCol);
                                    columnLimit.setValue(checkValues.toString());
                                    columnLimit.setType(ParamUtil.getWhereFilterTypeEqual());
                                    columnLimitList.add(columnLimit);
                                }

                            }else if(column.getColumnType().equals(ParamUtil.getColumnTypeBool())){//如果是布尔类型，需要将数字0 1 转换为true  false
                                if (where.get(whereCol) != null && where.get(whereCol).toString().length() > 0){
                                    ColumnLimit col = new ColumnLimit();
                                    col.setName(whereCol);
                                    if(where.get(whereCol).equals(0)){
                                        Boolean b=false;
                                        col.setValue(b.toString());
                                    }else if(where.get(whereCol).equals(1)){
                                        Boolean b=true;
                                        col.setValue(b.toString());
                                    }
                                    col.setType(ParamUtil.getWhereFilterTypeEqual());
                                    columnLimitList.add(col);
                                }
                            }
                            else {
                                String colVal = where.get(whereCol).toString();
                                if (colVal != null && colVal.length() > 0) {
                                    ColumnLimit col = new ColumnLimit();
                                    col.setName(whereCol);
                                    col.setValue(colVal);
                                    col.setType(getCommonWhereColType(entId, tableId, whereCol, columnList));
                                    columnLimitList.add(col);
                                }
                            }
                        }
                    }
                }
            }
            whereFilter.setAnd(columnLimitList);
            return whereFilter;
        }catch (Exception e){
            LogUtil.logError("拼接where查询条件出错，"+e.getMessage(),this.getClass());
            throw new Exception("拼接where查询条件出错，"+e.getMessage());
        }
    }


    /**
     * 拼接order查询条件,默认以add_time和id进行降序排序
     * @param order
     * @return
     */
    public List<OrderFilter> getOrderFilter(Map<String,Object> order){
        List<OrderFilter> orderFilterList=new ArrayList<>();
        List<String> orderCol=new ArrayList<>();
        if(order!=null&&order.size()>0){
            Iterator<String> orderIt=order.keySet().iterator();
            while(orderIt.hasNext()){
                String orderName=orderIt.next();
                OrderFilter orderFilter=new OrderFilter();
                orderFilter.setName(orderName);
                if(order.get(orderName)!=null){
                    orderFilter.setType((Integer) order.get(orderName));
                    orderCol.add(orderName);
                    orderFilterList.add(orderFilter);
                }
            }
        }
        if(!orderCol.contains("add_time")){
            OrderFilter orderFilter_1=new OrderFilter();
            orderFilter_1.setName("add_time");
            orderFilter_1.setType(2);
            orderFilterList.add(orderFilter_1);
        }

        if(!orderCol.contains("id")){
            OrderFilter orderFilter_2=new OrderFilter();
            orderFilter_2.setName("id");
            orderFilter_2.setType(2);
            orderFilterList.add(orderFilter_2);
        }
        return orderFilterList;
    }
}
