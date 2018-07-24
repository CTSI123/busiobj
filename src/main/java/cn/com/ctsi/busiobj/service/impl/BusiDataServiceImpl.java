package cn.com.ctsi.busiobj.service.impl;

import cn.com.ctsi.busiobj.bean.base.*;
import cn.com.ctsi.busiobj.bean.request.busiobj.data.*;
import cn.com.ctsi.busiobj.bean.request.busiobj.table.QueryTemplateTableRequest;
import cn.com.ctsi.busiobj.bean.request.cdm.data.*;
import cn.com.ctsi.busiobj.bean.response.busiobj.BODataQueryByIdRes;
import cn.com.ctsi.busiobj.bean.response.busiobj.BODataQueryListRes;
import cn.com.ctsi.busiobj.bean.response.busiobj.BOTableQueryRes;
import cn.com.ctsi.busiobj.bean.response.cdm.data.CdmTemplateDataQueryListRes;
import cn.com.ctsi.busiobj.dao.BusiTableDao;
import cn.com.ctsi.busiobj.exception.TableException;
import cn.com.ctsi.busiobj.service.BusiDataService;
import cn.com.ctsi.busiobj.service.BusiTableService;
import cn.com.ctsi.busiobj.service.CdmApiService;
import cn.com.ctsi.busiobj.util.BaseBean;
import cn.com.ctsi.busiobj.util.FeignClientApiUtil;
import cn.com.ctsi.busiobj.util.LogUtil;
import cn.com.ctsi.busiobj.util.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.*;


@Service
@Transactional(rollbackFor = TableException.class)
public class BusiDataServiceImpl implements BusiDataService {

    @Autowired
    BusiTableDao busiTableDao;

    @Autowired
    FeignClientApiUtil feignClientApiUtil;

    @Resource
    CdmApiService cdmApiServiceImpl;

    @Autowired
    BusiTableService busiTableService;

    @Autowired
    BusiDataService busiDataServiceImpl;

    /**
     * 添加数据
     * @param cdReq
     * @return
     */
    @Override
    public Integer insertTemplateData(CreateTemplateDataRequest cdReq) throws Exception{
        try{
            BusinessDataEntity bdEntity=busiTableDao.findByTableId(cdReq.getTableId());
            String tableName=bdEntity.getName();
            String key=feignClientApiUtil.getEntKeyByEntId(cdReq.getEnterpriseId());
            CdmTemplateDataInsertReq cdmTemplateDataInsertReq =(CdmTemplateDataInsertReq) cdmApiServiceImpl.jointCdmTemplateDataRequest(cdReq,tableName,key,cdReq.getTableId());
            Integer dataId= cdmApiServiceImpl.sendInsertCdmTemplateDataReq(cdmTemplateDataInsertReq);
            Integer busiDataId=busiTableDao.updateById(bdEntity.getId());
            Assert.notNull(busiDataId,"业务数据表修改时间更新失败");
            return busiDataId;
        }catch (Exception e){
            LogUtil.logError("insertTemplateData 发生异常,"+e.getMessage(),this.getClass());
            throw new Exception("insertTemplateData 发生异常,"+e.getMessage(),e);
        }

    }


    /**
     *  删除业务数据表数据
      * @param ddReq
     * @return
     */
    public BaseResponseNoBody deleteTemplateData(DeleteTemplateDataRequest ddReq) throws Exception{
        BaseResponseNoBody res=new BaseResponseNoBody();
        try{
            BusinessDataEntity bdEntity=busiTableDao.findByTableId(ddReq.getTableId());
            String tableName=bdEntity.getName();
            String key=feignClientApiUtil.getEntKeyByEntId(ddReq.getEnterpriseId());
            CdmTemplateDataDeleteReq cdmTemplateDataDeleteReq =(CdmTemplateDataDeleteReq) cdmApiServiceImpl.jointCdmTemplateDataRequest(ddReq,tableName,key,ddReq.getTableId());
            cdmApiServiceImpl.sendDeleteCdmTemplateDataReq(cdmTemplateDataDeleteReq);
            Integer busiDataId=busiTableDao.updateById(bdEntity.getId());
            Assert.notNull(busiDataId,"业务数据表修改时间更新失败");
            res.setMessage("删除业务数据表数据成功");
            res.setCode(BaseResponse.API_RESULT_SUCCESS);
            return res;
        }catch (Exception e){
            LogUtil.logError("deleteTemplateData 发生异常,"+e.getMessage(),this.getClass());
            throw new Exception("deleteTemplateData 发生异常,"+e.getMessage(),e);
        }
    }

    /**
     * 更新业务数据表数据
     * @param udReq
     * @return
     */
    @Override
    public BaseResponse updateTemplateData(UpdateTemplateDataRequest udReq) throws Exception{
        BaseResponse res=new BaseResponse();
        try{
            BusinessDataEntity bdEntity=busiTableDao.findByTableId(udReq.getTableId());
            String tableName=bdEntity.getName();
            String key=feignClientApiUtil.getEntKeyByEntId(udReq.getEnterpriseId());
            CdmTemplateDataUpdateReq cdmTemplateDataUpdateReq =(CdmTemplateDataUpdateReq) cdmApiServiceImpl.jointCdmTemplateDataRequest(udReq,tableName,key,udReq.getTableId());
            cdmApiServiceImpl.sendUpdateCdmTemplateDataReq(cdmTemplateDataUpdateReq);
            Integer dataId=busiTableDao.updateByEntIdAndTableName(udReq.getEnterpriseId(),tableName);
            Assert.notNull(dataId,"根据EntId和Name更新业务数据表失败");
            res.setMessage("更新业务数据表数据成功");
            res.setCode(BaseResponse.API_RESULT_SUCCESS);
            return res;
        }catch (Exception e){
            LogUtil.logError("updateTemplateData 发生异常,"+e.getMessage(),this.getClass());
            throw new Exception("updateTemplateData 发生异常,"+e.getMessage(),e);
        }

    }

    /**
     * 根据dataId查询cdm实体数据
     * @param qdbIReq
     * @return
     */
    @Override
    public BODataQueryByIdRes queryTemplateDataById(QueryTemplateDataByIdRequest qdbIReq) throws Exception {
        BODataQueryByIdRes boDataQueryByIdRes=new BODataQueryByIdRes();
        try{
            List<Column> columnList=cdmApiServiceImpl.getRealColumnList(qdbIReq.getTableId().toString(),qdbIReq.getEnterpriseId());

            CdmQueryTemplateDataListReq cqdlReq=new CdmQueryTemplateDataListReq();
            cqdlReq.setEntId(qdbIReq.getEnterpriseId());
            cqdlReq.setTableId(qdbIReq.getTableId());
            Filter filter=new Filter();
            //转换为查询条件为id的QueryDataList请求
            List<SelectFilter> selectFilterList=cdmApiServiceImpl.getSelectFilter(qdbIReq.getSelectColNames(),columnList);
            filter.setSelect(selectFilterList);


            if(qdbIReq.getDataIds()!=null&&qdbIReq.getDataIds().size()>0){
                List<ColumnLimit> columnLimits=new ArrayList<>();
                for(String id:qdbIReq.getDataIds()){
                    if(BaseBean.isNotEmpty(id)){
                        ColumnLimit columnLimit=new ColumnLimit();
                        columnLimit.setName("id");
                        columnLimit.setValue(id);
                        columnLimit.setType(1);//in
                        columnLimits.add(columnLimit);
                    }
                }
                WhereFilter whereFilter=new WhereFilter();
                whereFilter.setOr(columnLimits);
                filter.setWhere(whereFilter);
            }
            String key=feignClientApiUtil.getEntKeyByEntId(qdbIReq.getEnterpriseId());
            cqdlReq.setFilter(filter);
            cqdlReq.setKey(key);
            BusinessDataEntity bdEntity=busiTableDao.findByTableId(qdbIReq.getTableId());
            String tableName=bdEntity.getName();
            cqdlReq.setTableName(tableName);
            CdmTemplateDataQueryListRes res= cdmApiServiceImpl.sendCdmTemplateDataQueryListReq(cqdlReq);
            Assert.notNull(res,"queryTemplateDataById失败");
            boDataQueryByIdRes.setContent(res.getContent());
            return boDataQueryByIdRes;
        }catch (Exception e){
            LogUtil.logError("queryTemplateDataById 发生异常,"+e.getMessage(),this.getClass());
            throw new Exception("queryTemplateDataById 发生异常,"+e.getMessage(),e);
        }

    }


    /**
     * 分页查询cdm实体数据
     * @param qdlReq
     * @return
     * @throws Exception
     */
    @Override
    public BODataQueryListRes queryTemplateDataList(QueryTemplateDataListRequest qdlReq) throws Exception {
        BODataQueryListRes boDataQueryListRes=new BODataQueryListRes();
        try {
            BusinessDataEntity bdEntity=busiTableDao.findByTableId(qdlReq.getTableId());
            String tableName=bdEntity.getName();
            String key=feignClientApiUtil.getEntKeyByEntId(qdlReq.getEnterpriseId());
            CdmQueryTemplateDataListReq cdqlReq=(CdmQueryTemplateDataListReq) cdmApiServiceImpl.jointCdmTemplateDataRequest(qdlReq,tableName,key,bdEntity.getTableId());
            CdmTemplateDataQueryListRes res= cdmApiServiceImpl.sendCdmTemplateDataQueryListReq(cdqlReq);
            List<Map<String,Object>> rowList=res.getContent();
            Integer userId=feignClientApiUtil.getUserId(key,qdlReq.getMdn());

            cdmApiServiceImpl.getRealColumnList(qdlReq.getTableId().toString(),qdlReq.getEnterpriseId());

            List<Column> columnList=cdmApiServiceImpl.getRealColumnList(qdlReq.getTableId().toString(),qdlReq.getEnterpriseId());

            for(Map<String,Object> row:rowList){
                Set<String> colNameSet=row.keySet();
                for(String s:colNameSet){
                    if(row.get(s)!=null){
                        for(Column column:columnList){
                            if(column.getColumnName().equals(s)){
                                if(column.getAddPcStyle().equals(ParamUtil.getShowStyleDeptTree())){
                                        String deptName=feignClientApiUtil.getDepartmentName(Integer.valueOf(row.get(s).toString()),qdlReq.getEnterpriseId(),userId);
                                        row.put(s,deptName);

                                }
                                if(column.getAddPcStyle().equals(ParamUtil.getShowStyleUserTree())){
                                        String[] employeeIds=row.get(s).toString().split(",");
                                        StringBuilder sb=new StringBuilder();
                                        for(String id:employeeIds){
                                            String userName=feignClientApiUtil.queryNameById(Integer.valueOf(id));
                                            sb.append(userName);
                                        }
                                        row.put(s,sb.toString());
                                }
                            }
                        }
                    }
                }
            }
            boDataQueryListRes.setContent(res.getContent());
            boDataQueryListRes.setPage(res.getPage());
            return boDataQueryListRes;
        }catch (Exception e){
            LogUtil.logError("queryTemplateDataList 发生异常,"+e.getMessage(),this.getClass());
            throw new Exception("queryTemplateDataList 发生异常,"+e.getMessage(),e);
        }
    }
}
