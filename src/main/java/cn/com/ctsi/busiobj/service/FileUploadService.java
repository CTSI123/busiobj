package cn.com.ctsi.busiobj.service;

import cn.com.ctsi.busiobj.bean.response.busiobj.BOFileResponse;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


public interface FileUploadService {

    public abstract BOFileResponse uploadFile(MultipartFile[]  multipartFiles,Integer entId,String colName) throws Exception;

}