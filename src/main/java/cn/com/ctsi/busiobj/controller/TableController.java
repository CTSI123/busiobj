package cn.com.ctsi.busiobj.controller;

import cn.com.ctsi.busiobj.bean.base.BaseResponse;
import cn.com.ctsi.busiobj.bean.request.busiobj.table.CreateTemplateTableRequest;
import cn.com.ctsi.busiobj.bean.request.busiobj.table.DeleteTemplateTableRequest;
import cn.com.ctsi.busiobj.bean.request.busiobj.table.QueryTemplateTableRequest;
import cn.com.ctsi.busiobj.bean.request.busiobj.table.UpdateTemplateTableReuest;
import cn.com.ctsi.busiobj.bean.response.busiobj.BOTableQueryRes;
import cn.com.ctsi.busiobj.bean.response.busiobj.BOTableQueryWebRes;
import cn.com.ctsi.busiobj.bean.response.busiobj.BOTableQueryAppRes;
import cn.com.ctsi.busiobj.service.BusiTableService;
import cn.com.ctsi.busiobj.util.LogUtil;
import cn.com.ctsi.busiobj.util.ParamUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping(value="/api/table")
public class TableController {


    @Autowired
    BusiTableService busiTableService;

    @Autowired
    ParamUtil paramCheckUtil;

    /**
     * 创建业务数据表
     * @param req 创建业务表请求
     * @param result
     * @return
     */
    @PostMapping(value="/create")
    public BaseResponse<Integer> createTable(@RequestBody @Valid CreateTemplateTableRequest req, BindingResult result){
        BaseResponse<Integer> res=new BaseResponse<Integer>();
        try{
            paramCheckUtil.requestParamCheck(res,result);
            if(res.getCode()!=BaseResponse.API_RESULT_FAIL){
                Integer id=busiTableService.createCdmTemplateTable(req);
                res.setBody(id);
                res.setCode(BaseResponse.API_RESULT_SUCCESS);
                res.setMessage("创建cdm实体数据表和添加业务数据成功");
            }
        }catch (Exception e){
            LogUtil.logError("createTable()异常，"+e.getMessage(),this.getClass());
            res.setCode(BaseResponse.API_RESULT_FAIL);
            res.setMessage("创建cdm实体数据表和添加业务数据失败");
        }
        res.setTimestamp(new Date().getTime());
        return res;
    }

    @PostMapping(value="/delete")
    public BaseResponse deleteTable(@RequestBody @Valid DeleteTemplateTableRequest deleteTableRequest, BindingResult result){
        BaseResponse res=new BaseResponse();
        try{
            paramCheckUtil.requestParamCheck(res,result);
            if(res.getCode()!=BaseResponse.API_RESULT_FAIL){
                busiTableService.deleteCdmTemplateTable(deleteTableRequest);
                res.setCode(BaseResponse.API_RESULT_SUCCESS);
                res.setMessage("删除cdm业务数据表成功");
            }
        }catch (Exception e){
            LogUtil.logError("deleteTable 异常,"+e.getMessage(),this.getClass());
            res.setCode(BaseResponse.API_RESULT_FAIL);
            res.setMessage("删除cdm实体数据表失败");
        }
        res.setTimestamp(new Date().getTime());
        return res;
    }


    @PostMapping("/update")
    public BaseResponse updateTable(@RequestBody @Valid UpdateTemplateTableReuest utReq, BindingResult result){
        BaseResponse res=new BaseResponse();
        try{
            paramCheckUtil.requestParamCheck(res,result);
            if(res.getCode()!=BaseResponse.API_RESULT_FAIL){
                busiTableService.updateCdmTemplateTable(utReq);
                res.setCode(BaseResponse.API_RESULT_SUCCESS);
                res.setMessage("更新cdm业务数据成功");
            }
        }catch (Exception e){
            LogUtil.logError("updateTable 异常,"+e.getMessage(),this.getClass());
            res.setCode(BaseResponse.API_RESULT_FAIL);
            res.setMessage("更新cdm业务数据失败");
        }
        res.setTimestamp(new Date().getTime());
        return res;
    }




    @PostMapping("/query")
    public BaseResponse<BOTableQueryRes>  queryTable(@RequestBody @Valid QueryTemplateTableRequest req, BindingResult result) throws Exception{
        BaseResponse res=new BaseResponse();
        try{
            paramCheckUtil.requestParamCheck(res,result);
            if(res.getCode()!=BaseResponse.API_RESULT_FAIL){
                BOTableQueryRes BOTableQueryRes =busiTableService.queryCdmTemplateTable(req);
                res.setBody(BOTableQueryRes);
                res.setCode(BaseResponse.API_RESULT_SUCCESS);
                res.setMessage("查询cdm实体表成功");
            }
        }catch (Exception e){
            LogUtil.logError("queryTable 异常,"+e.getMessage(),this.getClass());
            res.setCode(BaseResponse.API_RESULT_FAIL);
            res.setMessage("查询cdm实体表失败");
        }
        res.setTimestamp(new Date().getTime());
        return res;
    }


    @PostMapping("/queryWeb")
    public BaseResponse<BOTableQueryWebRes>  queryTableWeb(@RequestBody @Valid QueryTemplateTableRequest req, BindingResult result) throws Exception{
        BaseResponse res=new BaseResponse();
        try{
            paramCheckUtil.requestParamCheck(res,result);
            if(res.getCode()!=BaseResponse.API_RESULT_FAIL){
                BOTableQueryWebRes BOTableQueryWebRes =busiTableService.queryCdmTemplateTableWeb(req);
                res.setBody(BOTableQueryWebRes);
                res.setCode(BaseResponse.API_RESULT_SUCCESS);
                res.setMessage("Web端查询cdm实体表成功");
            }
        }catch (Exception e){
            LogUtil.logError("queryTableWeb 异常,"+e.getMessage(),this.getClass());
            res.setCode(BaseResponse.API_RESULT_FAIL);
            res.setMessage("Web端查询cdm实体表失败");
        }
        res.setTimestamp(new Date().getTime());
        return res;
    }


    @PostMapping("/queryApp")
    public BaseResponse<BOTableQueryAppRes>  queryTableApp(@RequestBody @Valid QueryTemplateTableRequest req, BindingResult result) throws Exception{
        BaseResponse res=new BaseResponse();
        try{
            paramCheckUtil.requestParamCheck(res,result);
            if(res.getCode()!=BaseResponse.API_RESULT_FAIL){
                BOTableQueryAppRes BOTableQueryAppRes =busiTableService.queryCdmTemplateTableApp(req);
                res.setBody(BOTableQueryAppRes);
                res.setCode(BaseResponse.API_RESULT_SUCCESS);
                res.setMessage("app端查询cdm实体表成功");
            }
        }catch (Exception e){
            LogUtil.logError("queryTableApp 异常,"+e.getMessage(),this.getClass());
            res.setCode(BaseResponse.API_RESULT_FAIL);
            res.setMessage("app端查询cdm实体表失败");
        }
        res.setTimestamp(new Date().getTime());
        return res;
    }

}
