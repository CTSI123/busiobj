package cn.com.ctsi.busiobj.client;

import cn.com.ctsi.busiobj.bean.request.busiobj.data.GetUserIdByMdnAndEntKeyReq;
import cn.com.ctsi.busiobj.bean.response.busiobj.GetUserIdByMdnAndEntKeyRes;
import cn.com.ctsi.busiobj.config.FeiginClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="${permission.name}",configuration = FeiginClientConfig.class)
public  interface  PermissionApi {

    @RequestMapping(value="/user/getUserByMdnAndEntKey", method = RequestMethod.POST)
    public GetUserIdByMdnAndEntKeyRes getUserByMdnAndEntKey(GetUserIdByMdnAndEntKeyReq req);
}
