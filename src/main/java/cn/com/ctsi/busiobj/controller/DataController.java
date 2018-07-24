package cn.com.ctsi.busiobj.controller;

import cn.com.ctsi.busiobj.bean.base.BaseResponse;
import cn.com.ctsi.busiobj.bean.base.BaseResponseNoBody;
import cn.com.ctsi.busiobj.bean.request.busiobj.data.*;
import cn.com.ctsi.busiobj.bean.response.busiobj.BODataQueryByIdRes;
import cn.com.ctsi.busiobj.bean.response.busiobj.BODataQueryListRes;
import cn.com.ctsi.busiobj.service.BusiDataService;
import cn.com.ctsi.busiobj.util.LogUtil;
import cn.com.ctsi.busiobj.util.ParamUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping(value = "/api/data")
public class DataController {


    @Autowired
    BusiDataService busiDataService;

    @Autowired
    ParamUtil paramUtil;




    /**
     * 创建业务数据
     * @param cdReq
     * @return
     */

    @PostMapping(value = "/create")
    public BaseResponse<Integer> createData(@RequestBody @Valid CreateTemplateDataRequest cdReq, BindingResult result){
        BaseResponse<Integer> res=new BaseResponse<>();
        try{
            paramUtil.requestParamCheck(res,result);
            if(res.getCode()!=BaseResponse.API_RESULT_FAIL){
                Integer busiDataId=busiDataService.insertTemplateData(cdReq);
                res.setBody(busiDataId);
                res.setCode(BaseResponse.API_RESULT_SUCCESS);
                res.setMessage("添加cdm实体数据成功");
            }
        }catch (Exception e){
            LogUtil.logError(" createData 异常,"+e.getMessage(),this.getClass());
            res.setCode(BaseResponse.API_RESULT_FAIL);
            res.setMessage("添加cdm实体数据失败,"+e.getMessage());
        }
        res.setTimestamp(new Date().getTime());
        return res;
    }


    @PostMapping("/delete")
    public BaseResponseNoBody deleteData(@RequestBody @Valid DeleteTemplateDataRequest ddReq, BindingResult result){
        BaseResponseNoBody res=new BaseResponseNoBody();
        try{
            paramUtil.requestParamCheck(res,result);
            if(res.getCode()!=BaseResponse.API_RESULT_FAIL){
                res=busiDataService.deleteTemplateData(ddReq);
            }
        }catch (Exception e){
            LogUtil.logError("deleteData异常,"+e.getMessage(),this.getClass());
            res.setCode(BaseResponse.API_RESULT_FAIL);
            res.setMessage("删除cdm实体数据失败");
        }
        res.setTimestamp(new Date().getTime());
        return res;
    }



    @PostMapping("/update")
    public BaseResponse updateData(@RequestBody @Valid UpdateTemplateDataRequest req, BindingResult result){
        BaseResponse res=new BaseResponse<>();
        try{
            paramUtil.requestParamCheck(res,result);
            if(res.getCode()!=BaseResponse.API_RESULT_FAIL){
                res=busiDataService.updateTemplateData(req);
            }
        }catch (Exception e){
            LogUtil.logError("updateData异常,"+e.getMessage(),this.getClass());
            res.setCode(BaseResponse.API_RESULT_FAIL);
            res.setMessage("更新cdm实体数据失败,"+e.getMessage());
        }
        res.setTimestamp(new Date().getTime());
        return res;
    }


    @PostMapping("/queryById")
    public BaseResponse<BODataQueryByIdRes> queryDataById(@RequestBody @Valid QueryTemplateDataByIdRequest req, BindingResult result){
        BaseResponse<BODataQueryByIdRes> res=new BaseResponse();
        try{
            paramUtil.requestParamCheck(res,result);
            if(res.getCode()!=BaseResponse.API_RESULT_FAIL){
                BODataQueryByIdRes bodqIdRes =busiDataService.queryTemplateDataById(req);
                res.setBody(bodqIdRes);
                res.setCode(BaseResponse.API_RESULT_SUCCESS);
                res.setMessage("queryDataById 成功");
            }
        }catch (Exception e){
            LogUtil.logError("queryDataById异常,"+e.getMessage(),this.getClass());
            res.setCode(BaseResponse.API_RESULT_FAIL);
            res.setMessage("queryDataById 失败");
        }
        res.setTimestamp(new Date().getTime());
        return res;
    }


    @PostMapping("/queryList")
    public BaseResponse<BODataQueryListRes> queryDataList(@RequestBody @Valid QueryTemplateDataListRequest qdlReq, BindingResult result){
        BaseResponse<BODataQueryListRes> res=new BaseResponse<>();
        try{
            paramUtil.requestParamCheck(res,result);
            if(res.getCode()!=BaseResponse.API_RESULT_FAIL){
                BODataQueryListRes boDataQueryListRes =busiDataService.queryTemplateDataList(qdlReq);
                res.setBody(boDataQueryListRes);
                res.setCode(BaseResponse.API_RESULT_SUCCESS);
                res.setMessage("queryDataList 成功");
            }
        }catch (Exception e){
            LogUtil.logError("queryDataList异常,"+e.getMessage(),this.getClass());
            res.setCode(BaseResponse.API_RESULT_FAIL);
            res.setMessage("queryDataList 失败");
        }
        res.setTimestamp(new Date().getTime());
        return res;
    }
}
