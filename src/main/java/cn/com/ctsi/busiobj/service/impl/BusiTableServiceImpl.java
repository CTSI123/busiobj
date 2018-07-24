package cn.com.ctsi.busiobj.service.impl;

import cn.com.ctsi.busiobj.bean.base.*;
import cn.com.ctsi.busiobj.bean.request.busiobj.table.CreateTemplateTableRequest;
import cn.com.ctsi.busiobj.bean.request.busiobj.table.DeleteTemplateTableRequest;
import cn.com.ctsi.busiobj.bean.request.busiobj.table.QueryTemplateTableRequest;
import cn.com.ctsi.busiobj.bean.request.cdm.table.*;
import cn.com.ctsi.busiobj.bean.request.busiobj.table.UpdateTemplateTableReuest;
import cn.com.ctsi.busiobj.bean.response.busiobj.BOTableQueryAppRes;
import cn.com.ctsi.busiobj.bean.response.busiobj.BOTableQueryRes;
import cn.com.ctsi.busiobj.bean.response.busiobj.BOTableQueryWebRes;
import cn.com.ctsi.busiobj.bean.response.cdm.table.CdmTemplateTableQueryRes;
import cn.com.ctsi.busiobj.dao.BusiTableDao;
import cn.com.ctsi.busiobj.exception.TableException;
import cn.com.ctsi.busiobj.service.BusiTableService;
import cn.com.ctsi.busiobj.service.CdmApiService;
import cn.com.ctsi.busiobj.util.FeignClientApiUtil;
import cn.com.ctsi.busiobj.util.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(rollbackFor = TableException.class)
public class BusiTableServiceImpl implements BusiTableService {

    private static final Logger logger = LoggerFactory.getLogger(BusiTableServiceImpl.class);

    @Autowired
    BusiTableDao busiDataTableDao;

    @Autowired
    FeignClientApiUtil feignClientApiUtil;

    @Autowired
    CdmApiService cdmApiServiceImpl;




    /**
     *  1.到业务数据表，做(enterpriseId + name)的唯一性校验
     *  2.调用cdm接口，创建实体数据表
     *  3.创建业务数据表数据，设置创建时间为当前时间
     * @param req 创建业务数据表请求
     * @return
     */
    @Override
    public Integer createCdmTemplateTable(CreateTemplateTableRequest req) throws Exception{
        BaseResponse<Integer> res=new BaseResponse<>();
        try{
            Boolean existFlag=busiDataTableDao.isExist(req.getEnterpriseId(),req.getTableName());
            Assert.isTrue(!existFlag,"(enterpriseId + name)的唯一性校验不通过,同名业务数据表已经存在");
            String key=feignClientApiUtil.getEntKeyByEntId(req.getEnterpriseId());
            TableReq tableReq= cdmApiServiceImpl.jointCdmTemplateTableReq(req,key,null);
            Assert.notNull(tableReq,"拼接的Cdm请求为null");
            CdmTemplateTableCreateReq cctReq=(CdmTemplateTableCreateReq)tableReq;

            Integer tableId= cdmApiServiceImpl.sendCreateCdmTemplateTableReq(cctReq);
            Integer id=busiDataTableDao.insert(req.getEnterpriseId(),req.getTableName(),req.getTbDesc(),tableId);
            Assert.notNull(id,"创建业务数据表返回id为null");
            return id;
        }catch (Exception e){
            LogUtil.logError("createCdmTemplateTable 异常，"+e.getMessage(),this.getClass());
            throw new Exception("createCdmTemplateTable 异常,"+e.getMessage());
        }
    }


    /**
     * 1.到业务数据表，做(enterpriseId + name)的唯一性校验,判断要删除的表的业务数据是否存在；
     * 2.调用cdm接口删除cdm实体表
     * 3.删除业务数据表的相关数据
     * @param req
     * @return
     * @throws Exception
     */
    @Override
    public void deleteCdmTemplateTable(DeleteTemplateTableRequest req) throws Exception {
        try{
            BusinessDataEntity bdEntity=busiDataTableDao.findByTableId(req.getTableId());
            String[] tableName={bdEntity.getName()};
            String key=feignClientApiUtil.getEntKeyByEntId(req.getEnterpriseId());
            TableReq tableReq= cdmApiServiceImpl.jointCdmTemplateTableReq(req,key,tableName);
            Assert.notNull(tableReq,"拼接的Cdm请求为null");
            CdmTemplateTableDeleteReq ccdReq=(CdmTemplateTableDeleteReq)tableReq;
            cdmApiServiceImpl.sendDeleteCdmTemplateTableReq(ccdReq);
            busiDataTableDao.delete(req.getEnterpriseId(),bdEntity.getName());
        }catch (Exception e){
            LogUtil.logError("deleteCdmTemplateTable异常，"+e.getMessage(),this.getClass());
            throw new Exception(" deleteCdmTemplateTable异常，"+e.getMessage());
        }
    }

    /**
     * 1.到业务数据表，做(enterpriseId + name)的唯一性校验,判断要更改的业务数据表是否存在；
     * 2.调用cdm接口更新cdm实体表
     * 3.修改业务数据表的最后修改时间
     * @param req
     * @throws Exception
     */
    @Override
    public void updateCdmTemplateTable(UpdateTemplateTableReuest req) throws Exception {
        try{
            BusinessDataEntity bdEntity=busiDataTableDao.findByTableId(req.getContentUpdate().getTableId());
            String[] tableName={bdEntity.getName()};
            String key=feignClientApiUtil.getEntKeyByEntId(req.getEnterpriseId());
            TableReq tableReq= cdmApiServiceImpl.jointCdmTemplateTableReq(req,key,tableName);
            Assert.notNull(tableReq,"拼接的Cdm请求为null");
            CdmTemplateTableUpdateReq ctuReq=(CdmTemplateTableUpdateReq)tableReq;
            cdmApiServiceImpl.sendUpateCdmTemplateTableReq(ctuReq);
            busiDataTableDao.updateByEntIdAndTableName(req.getEnterpriseId(),tableName[0]);
        }catch (Exception e){
            LogUtil.logError("updateCdmTemplateTable异常，"+e.getMessage(),this.getClass());
            throw new Exception(" updateCdmTemplateTable异常，"+e.getMessage());

        }
    }

    /**
     * 后端调用查询表信息
     * @param req
     * @return
     * @throws Exception
     */
    public BOTableQueryRes queryCdmTemplateTable(QueryTemplateTableRequest req) throws Exception{
        BOTableQueryRes butqRes=new BOTableQueryRes();
        try{
            String[] tableIds=req.getTableIds().split(",");
            String[] tableNames=new String[tableIds.length];
            for(int i=0;i<tableIds.length;i++){
                Integer tabId = new Integer(tableIds[i]);
                BusinessDataEntity bdEntity=busiDataTableDao.findByTableId(tabId);
                tableNames[i]=bdEntity.getName();
            }
            String key=feignClientApiUtil.getEntKeyByEntId(req.getEntid());
            CdmTemplateTableQueryReq ctqReq=(CdmTemplateTableQueryReq) cdmApiServiceImpl.jointCdmTemplateTableReq(req,key,tableNames);
            Assert.notNull(ctqReq,"拼接的Cdm请求为null");
            CdmTemplateTableQueryRes res=cdmApiServiceImpl.sendQueryCdmTemplateTableReq(ctqReq);
            butqRes.setTables(res.getTables());
            return butqRes;
        }catch (Exception e){
            LogUtil.logError("queryCdmTemplateTable异常，"+e.getMessage(),this.getClass());
            throw new Exception("queryCdmTemplateTable异常，"+e.getMessage());
        }
    }

    /**
     * web端调用查询表信息
     * @param req
     * @return
     * @throws Exception
     */
    @Override
    public BOTableQueryWebRes queryCdmTemplateTableWeb(QueryTemplateTableRequest req) throws Exception {
        BOTableQueryWebRes webTableQres=new BOTableQueryWebRes();
        try{
            BOTableQueryRes res=queryCdmTemplateTable(req);
            List<TableLimitWeb> tableLimitWebList=new ArrayList<>();

            for(Table table:res.getTables()){
                TableLimitWeb tableLimitWeb=new TableLimitWeb();
                List<ColumnLimitWeb> columnLimitWebList=new ArrayList<>();
                for(Column col:table.getColumns()){
                    ColumnLimitWeb colLimiWeb=new ColumnLimitWeb();
                    colLimiWeb.setColumnName(col.getColumnName());
                    colLimiWeb.setColumnNameDesc(col.getColumnNameDesc());
                    colLimiWeb.setCanQuery(col.getCanQuery());
                    colLimiWeb.setDefaultValue(col.getDefaultValue());
                    colLimiWeb.setValidationStyle(col.getValidationStyle());
                    colLimiWeb.setKeyValues(col.getKeyValues());
                    colLimiWeb.setAddPcStyle(col.getAddPcStyle());
                    colLimiWeb.setEditPcStyle(col.getEditPcStyle());
                    colLimiWeb.setNullable(col.getIsNullable());
                    colLimiWeb.setListPcStyle(col.getListPcStyle());
                    colLimiWeb.setViewPcStyle(col.getViewPcStyle());
                    columnLimitWebList.add(colLimiWeb);
                }
                ContentLimit contentLimit =new ContentLimit();
                contentLimit.setTableName(table.getContent().getTableName());
                contentLimit.setTableNameDesc(table.getContent().getTableNameDesc());
                tableLimitWeb.setContentLimit(contentLimit);
                tableLimitWeb.setColumnLimitWebs(columnLimitWebList);
                tableLimitWebList.add(tableLimitWeb);
            }
            webTableQres.setTableLimitWebList(tableLimitWebList);
            return webTableQres;
        }catch (Exception e){
            LogUtil.logError("queryCdmTemplateTableWeb异常，"+e.getMessage(),this.getClass());
            throw new Exception("queryCdmTemplateTableWeb异常，"+e.getMessage());
        }

    }


    /**
     * app端调用查询表信息
     * @param req
     * @return
     * @throws Exception
     */
    @Override
    public BOTableQueryAppRes queryCdmTemplateTableApp(QueryTemplateTableRequest req) throws Exception {
        BOTableQueryAppRes appTableQres=new BOTableQueryAppRes();
        try{
            BOTableQueryRes res=queryCdmTemplateTable(req);
            List<TableLimitApp> tableLimitAppList=new ArrayList<>();

            for(Table table:res.getTables()){
                TableLimitApp tableLimitApp=new TableLimitApp();
                List<ColumnLimitApp> columnLimitAppList=new ArrayList<>();
                for(Column col:table.getColumns()){
                    ColumnLimitApp colLimiApp=new ColumnLimitApp();
                    colLimiApp.setColumnName(col.getColumnName());
                    colLimiApp.setColumnNameDesc(col.getColumnNameDesc());
                    colLimiApp.setCanQuery(col.getCanQuery());
                    colLimiApp.setDefaultValue(col.getDefaultValue());
                    colLimiApp.setNullable(col.getIsNullable());
                    colLimiApp.setValidationStyle(col.getValidationStyle());
                    colLimiApp.setKeyValues(col.getKeyValues());
                    colLimiApp.setAddMobStyle(col.getAddMobStyle());
                    colLimiApp.setEditMobStyle(col.getEditMobStyle());
                    colLimiApp.setListMobStyle(col.getListMobStyle());
                    colLimiApp.setViewMobStyle(col.getViewMobStyle());
                    columnLimitAppList.add(colLimiApp);
                }
                ContentLimit contentLimit =new ContentLimit();
                contentLimit.setTableName(table.getContent().getTableName());
                contentLimit.setTableNameDesc(table.getContent().getTableNameDesc());
                tableLimitApp.setContentLimit(contentLimit);
                tableLimitApp.setColumnLimitApps(columnLimitAppList);
                tableLimitAppList.add(tableLimitApp);
            }
            appTableQres.setTableLimitAppList(tableLimitAppList);
            return appTableQres;
        }catch (Exception e){
            LogUtil.logError("queryCdmTemplateTableApp异常，"+e.getMessage(),this.getClass());
            throw new Exception("queryCdmTemplateTableApp异常，"+e.getMessage());
        }
    }


}
