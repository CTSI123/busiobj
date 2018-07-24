package cn.com.ctsi.busiobj.controller;

import cn.com.ctsi.busiobj.bean.base.*;
import cn.com.ctsi.busiobj.util.FeignClientApiUtil;
import cn.com.ctsi.busiobj.util.LogUtil;
import cn.com.ctsi.busiobj.util.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping(value = "/basis/department")
public class DepartmentController {

    @Autowired
    FeignClientApiUtil feignClientApiUtil;

    @Autowired
    ParamUtil paramUtil;

    @PostMapping(value = "/get")
    public BaseResponse<String> getDeptName(@RequestBody @Valid GetDepartmentNameReq req, BindingResult result){
        BaseResponse<String> res=new BaseResponse<>();
        try{
            paramUtil.requestParamCheck(res,result);
            String mdn=req.getMdn();
            String entKey=feignClientApiUtil.getEntKeyByEntId(req.getEntId());
            Integer userId=feignClientApiUtil.getUserId(entKey,mdn);
            String departName=feignClientApiUtil.getDepartmentName(req.getDepId(),req.getEntId(),userId);
            res.setBody(departName);
        }catch (Exception e){
            LogUtil.logError(" 获取企业Name异常,"+e.getMessage(),this.getClass());
            res.setCode(BaseResponse.API_RESULT_FAIL);
            res.setMessage("获取企业Name异常,"+e.getMessage());
        }
        res.setTimestamp(new Date().getTime());
        return res;
    }

    @RequestMapping(value = "/queryTree", method = RequestMethod.POST)
    public DepQueryResponse queryTree(@RequestBody @Valid GetTreeReq request, BindingResult result) {
        DepQueryResponse res=new DepQueryResponse();
        try{
            paramUtil.requestParamCheck(res,result);
            String mdn=request.getMdn();
            String entKey=feignClientApiUtil.getEntKeyByEntId(request.getEntId());
            Integer userId=feignClientApiUtil.getUserId(entKey,mdn);
            res=feignClientApiUtil.queryDeptTree(request.getEntId(),userId);
            res.setCode(GeneralResponse.CODE_SUCCESS);
            res.setInfo("获取部门树成功");
        }catch (Exception e){
            LogUtil.logError(" 获取部门树异常,"+e.getMessage(),this.getClass());
            res.setCode(GeneralResponse.CODE_FAIL);
            res.setInfo("获取部门树失败");
        }
        return  res;
    }

}
