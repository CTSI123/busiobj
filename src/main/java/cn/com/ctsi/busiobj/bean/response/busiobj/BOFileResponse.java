package cn.com.ctsi.busiobj.bean.response.busiobj;

import cn.com.ctsi.busiobj.bean.base.FileUploadUrl;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BOFileResponse {

    @JsonProperty("files_url")
    List<FileUploadUrl> fileUploadUrlList;

    @Override
    public String toString() {
        return "BOFileResponse{" +
                "fileUploadUrlList=" + fileUploadUrlList +
                '}';
    }

    public List<FileUploadUrl> getFileUploadUrlList() {
        return fileUploadUrlList;
    }

    public void setFileUploadUrlList(List<FileUploadUrl> fileUploadUrlList) {
        this.fileUploadUrlList = fileUploadUrlList;
    }
}
