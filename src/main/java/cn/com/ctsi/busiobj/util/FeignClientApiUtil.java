package cn.com.ctsi.busiobj.util;


import cn.com.ctsi.busiobj.bean.base.*;
import cn.com.ctsi.busiobj.bean.request.busiobj.data.GetUserIdByMdnAndEntKeyReq;
import cn.com.ctsi.busiobj.bean.response.busiobj.GetUserIdByMdnAndEntKeyRes;
import cn.com.ctsi.busiobj.client.CopMainApi;
import cn.com.ctsi.busiobj.client.PermissionApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

@Configuration
public class FeignClientApiUtil {

    @Autowired
    CopMainApi copMainApi;

    @Autowired
    PermissionApi permissionApi;

    public String getEntKeyByEntId(Integer entId)throws Exception{
        try{
            String key=copMainApi.queryEntById(entId).getEntKey();
            return key;
        }catch (Exception e){
            throw new Exception("调用main服务通过EntId获取EntKey失败，entId为："+entId+"异常信息为:"+e.getMessage());
        }
    }



    public Integer getUserId(String entKey,String mdn)throws Exception{
        try {
            GetUserIdByMdnAndEntKeyReq getUserIdReq=new GetUserIdByMdnAndEntKeyReq();
            getUserIdReq.setMdn(mdn);
            getUserIdReq.setEntKey(entKey);
            GetUserIdByMdnAndEntKeyRes getUserIdRes=permissionApi.getUserByMdnAndEntKey(getUserIdReq);
            Assert.notNull(getUserIdRes,"查询userIdf返回响应为空");
            Integer userId=getUserIdRes.getUser().getId();
            return userId;
        }catch (Exception e){
            throw new Exception("调用permission服务getUserByMdnAndEntKey失败，异常信息为:"+e.getMessage());
        }

    }

    public String getDepartmentName(Integer depId,Integer entId,Integer userId)throws Exception {
        try {
            DepGetRequest request = new DepGetRequest();
            request.setDepId(depId);
            request.setEntId(entId);
            request.setUserId(userId);
            DepGetResponse res = copMainApi.get(request);
            if (res.getCode().equals("00000")) {
                return res.getDepartment().getName();
            } else {
                throw new Exception("返回码为：" + res.getCode());
            }

        } catch (Exception e) {
            throw new Exception("调用main服务获取部门name失败，异常信息为:" + e.getMessage());
        }
    }

        public String queryNameById(Integer userId)throws Exception{
            try {
                String userName=copMainApi.queryNameById(userId);
                if (userName!=null&&userName.length()>0) {
                    return userName;
                } else {
                    throw new Exception("调用main服务根据userId获取人员名字失败,userId为"+userId);
                }
            } catch (Exception e) {
                throw new Exception("调用main服务根据userId查询人员名字失败，userId为:"+userId+"异常信息为:" + e.getMessage());
            }
        }


    public DepQueryResponse queryDeptTree(Integer entId,Integer userId)throws Exception{
        try {
            GetTreeRequest getTreeRequest=new GetTreeRequest();
            getTreeRequest.setEntId(entId);
            getTreeRequest.setUserId(userId);
            DepQueryResponse res=copMainApi.query(getTreeRequest);
            Assert.notNull(res,"调用main查询部门树返回为null");
            return res;
        } catch (Exception e) {
            throw new Exception("调用main查询部门树异常，异常信息为:" + e.getMessage());
        }
    }



    public QueryWithEmpRes queryEmpTree(Integer entId,String mdn)throws Exception{
        QueryWithEmpRes res=new QueryWithEmpRes();
        try{
            String entKey=this.getEntKeyByEntId(entId);
            Integer userId=this.getUserId(entKey,mdn);
            GetTreeRequest getTreeRequest=new GetTreeRequest();
            getTreeRequest.setUserId(userId);
            getTreeRequest.setEntId(entId);
            res=copMainApi.queryWithEmp(getTreeRequest);
            Assert.notNull(res,"调用main查询含有人员树返回为null");
            return res;
        }catch (Exception e){
            throw new Exception("调用main查询含有人员树异常，异常信息为:" + e.getMessage());
        }
    }


}
