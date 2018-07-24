package cn.com.ctsi.busiobj.client;

import cn.com.ctsi.busiobj.bean.base.*;
import cn.com.ctsi.busiobj.config.FeiginClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@FeignClient(name="${cop.main.name}",configuration = FeiginClientConfig.class)
public interface CopMainApi {


    /**
     * get Enterprise by EntId
     * @param id
     * @return
     */
    @RequestMapping(value = "/basis/enterprise/entCach/queryEntById/{id}",method = RequestMethod.GET)
    Enterprise queryEntById(@PathVariable("id") Integer id);


    /**
     * get Department Id by UserId and EntId
     * @param request
     * @return
     */
    @RequestMapping(value="/basis/department/query", method = RequestMethod.POST)
    public DepQueryResponse query(@RequestBody GetTreeRequest request);


    @RequestMapping(value = "/basis/department/get",method = RequestMethod.POST)
    public DepGetResponse get(@RequestBody DepGetRequest request) ;


    @RequestMapping(value = "/basis/employee/queryNameById/{id}",method = RequestMethod.GET)
    public String queryNameById(@PathVariable("id") Integer id);


    /**
     * 查询部门树带人员
     * @param request
     * @return
     */
    @RequestMapping(value = "/basis/department/queryWithEmp", method = RequestMethod.POST)
    public QueryWithEmpRes queryWithEmp(@RequestBody GetTreeRequest request);

}
