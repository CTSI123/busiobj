package cn.com.ctsi.busiobj.controller;


import cn.com.ctsi.busiobj.bean.base.BaseResponse;
import cn.com.ctsi.busiobj.bean.base.GeneralResponse;
import cn.com.ctsi.busiobj.bean.base.QueryWithEmpRes;
import cn.com.ctsi.busiobj.util.FeignClientApiUtil;
import cn.com.ctsi.busiobj.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/basis/employee")
public class EmployeeController {


    @Autowired
    FeignClientApiUtil feignClientApiUtil;

    @GetMapping("/queryEmployeeTree/{entId}/{mdn}")
    public QueryWithEmpRes queryEmployeeTree(@PathVariable("entId") Integer entId, @PathVariable("mdn") String mdn){
        QueryWithEmpRes res=new QueryWithEmpRes();
        try {
            res=feignClientApiUtil.queryEmpTree(entId,mdn);
            res.setCode(GeneralResponse.CODE_SUCCESS);
            res.setInfo("获取部门树成功");
        } catch (Exception e) {
            LogUtil.logError(" 获取部门树异常",this.getClass());
            res.setCode(GeneralResponse.CODE_FAIL);
            res.setInfo("获取部门树失败");
        }
        return res;
    }

    @GetMapping("/queryEmployeeName/{userIds}")
    public BaseResponse<String> queryEmployeeName(@PathVariable("userIds") String userIds)throws Exception{
        BaseResponse res=new BaseResponse();
        try {
            String[] ids=userIds.split(",");
            StringBuilder sb=new StringBuilder();
            for(String id:ids){
                String userName=feignClientApiUtil.queryNameById(Integer.valueOf(id));
                sb.append(userName).append(",");
            }
            sb.substring(0,sb.length()-2);
            res.setBody(sb.toString());
            res.setCode(BaseResponse.API_RESULT_SUCCESS);
            res.setMessage("查询人员名字成功");
        } catch (Exception e) {
            LogUtil.logError(" 调用main服务获取部门树异常,"+e.getMessage(),this.getClass());
            res.setCode(BaseResponse.API_RESULT_FAIL);
            res.setMessage("调用main服务查询人员名字失败");
        }
        return res;
    }
}
