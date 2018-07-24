package cn.com.ctsi.busiobj.service;

import cn.com.ctsi.busiobj.bean.base.BaseResponse;
import cn.com.ctsi.busiobj.bean.base.BaseResponseNoBody;
import cn.com.ctsi.busiobj.bean.request.busiobj.data.*;
import cn.com.ctsi.busiobj.bean.response.busiobj.BODataQueryByIdRes;
import cn.com.ctsi.busiobj.bean.response.busiobj.BODataQueryListRes;
import cn.com.ctsi.busiobj.bean.response.busiobj.BOFileResponse;
import cn.com.ctsi.busiobj.bean.response.cdm.data.CdmTemplateDataQueryByIdRes;
import cn.com.ctsi.busiobj.bean.response.cdm.data.CdmTemplateDataQueryListRes;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BusiDataService {

    public abstract Integer insertTemplateData(CreateTemplateDataRequest cdReq) throws Exception;

    public abstract BaseResponseNoBody deleteTemplateData(DeleteTemplateDataRequest ddReq) throws Exception;

    public abstract BaseResponse updateTemplateData(UpdateTemplateDataRequest udReq) throws Exception;

    public abstract BODataQueryByIdRes queryTemplateDataById(QueryTemplateDataByIdRequest qdbIReq) throws Exception;

    public abstract BODataQueryListRes queryTemplateDataList(QueryTemplateDataListRequest qdlReq) throws Exception;

//    public abstract CdmTemplateDataQueryListRes staTemplateDataList (QueryStaTemplateDataListRequest qdlReq) throws Exception;


}
