package cn.com.ctsi.busiobj.controller;

import cn.com.ctsi.busiobj.bean.base.BaseResponse;
import cn.com.ctsi.busiobj.bean.response.busiobj.BOFileResponse;
import cn.com.ctsi.busiobj.service.FileUploadService;
import cn.com.ctsi.busiobj.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.Date;


@RestController
@RequestMapping(value = "/upload")
public class FileUploadController {

    @Autowired
    FileUploadService fileUploadService;



    @PostMapping("/file/{entId}/{columnName}")
    public BaseResponse<BOFileResponse> uploadFile(@RequestParam("file") MultipartFile[] files, @PathVariable Integer entId, @PathVariable String columnName){
        BaseResponse<BOFileResponse> res=new BaseResponse<>();
        try{
            BOFileResponse boFileResponse=fileUploadService.uploadFile(files,entId,columnName);
            res.setBody(boFileResponse);
            res.setCode(BaseResponse.API_RESULT_SUCCESS);
            res.setMessage("uploadFile 成功");
        }catch (Exception e) {
            LogUtil.logError(this.getClass()+" uploadFile 异常,"+e.getMessage(),this.getClass());
            res.setCode(BaseResponse.API_RESULT_FAIL);
            res.setMessage("uploadFile 失败");
        }
        res.setTimestamp(new Date().getTime());
        return res;
    }
}
