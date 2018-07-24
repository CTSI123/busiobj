package cn.com.ctsi.busiobj.service.impl;

import cn.com.ctsi.busiobj.bean.base.FilePiece;
import cn.com.ctsi.busiobj.bean.base.FileUploadUrl;
import cn.com.ctsi.busiobj.bean.response.busiobj.BOFileResponse;
import cn.com.ctsi.busiobj.service.FileUploadService;
import cn.com.ctsi.busiobj.util.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileUploadServiceImpl implements FileUploadService {


    @Autowired
    FeignClientApiUtil feignClientApiUtil;

    @Value("${file.upload.url}")
    private String fileUpUrl;



    public BOFileResponse uploadFile(MultipartFile[] files, Integer entId, String colName) throws Exception {

        BOFileResponse boFileResponse = new BOFileResponse();
        List<FileUploadUrl> fileUploadUrlList = new ArrayList<>();
        Assert.notEmpty(files, "待上传文件为空");
        List<MultipartFile> multipartFileList = new ArrayList<>();

        FileUploadUrl fileUploadUrl = new FileUploadUrl();
        StringBuilder filesUrl = new StringBuilder();
        StringBuilder thumbsUrl = new StringBuilder();
        StringBuilder framesImgUrl = new StringBuilder();
        for(MultipartFile file:files){
            if(file.getSize()>0&&!file.getOriginalFilename().equals("")){
                multipartFileList.add(file);
            }
        }
        if(multipartFileList.size()<=0){
            LogUtil.info(this.getClass(),"上传文件为空");
            throw new Exception("上传文件为空");
        }
            for (MultipartFile multipartFile : multipartFileList) {

                File file = FileSpliteUtil.fileSave(multipartFile);
                String entKey = feignClientApiUtil.getEntKeyByEntId(entId);
                String resEntityStr = spliteAndUp(file, entKey);

                if (resEntityStr != null && resEntityStr.length() > 0) {
                    String[] res = resEntityStr.split(",");
                    for (String s : res) {
                        if (s.contains("filePath")) {
                            String fileUrl = s.substring(s.indexOf(":") + 1);
                            filesUrl.append(fileUrl).append(",");
                        }
                        if (s.contains("thumbnailPath")) {
                            String thumbnailPath = s.substring(s.indexOf(":") + 1);
                            thumbsUrl.append(thumbnailPath).append(",");
                        }
                        if (s.contains("frameImgPath")) {
                            String frameImgUrl = s.substring(s.indexOf(":") + 1);
                            framesImgUrl.append(frameImgUrl).append(",");
                        }
                    }
                }
                FileSpliteUtil.clearFileTempSavePath();
            }
            fileUploadUrl.setColumnName(colName);
            fileUploadUrl.setFilePath(filesUrl.toString());
            fileUploadUrl.setThumbnailPath(thumbsUrl.toString());
            fileUploadUrl.setFrameImgPath(framesImgUrl.toString());
            fileUploadUrlList.add(fileUploadUrl);
            Assert.notNull(fileUploadUrlList.get(0).getFilePath(), this.getClass() + ",上传文件返回响应为空");
            boFileResponse.setFileUploadUrlList(fileUploadUrlList);
            LogUtil.info(FileUploadServiceImpl.class, "所有文件的url为：" + fileUploadUrlList.toString());

            return boFileResponse;
        }





    private String spliteAndUp(File file, String entKey) throws Exception {
        String fileName = file.getName();
        long fileSize = file.length();
        String fileType=file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf(".")+1);
        if(!ParamUtil.getFileUpAllSurportedTypes().contains(fileType)){
            throw new Exception("此格式的文件不支持上传，文件名字为;"+fileName+",文件格式为："+fileType);
        }

        //首先要写文件，然后进行加密
        String fileMD5 = Md5Util.fileMD5(file);
        //首先对过大文件进行分片,暂时不分片了
        List<FilePiece> pieces = new ArrayList<>();

//        if (fileSize > FileSpliteUtil.LIMIT_SIZE) {
//            FileSpliteUtil.split(file);
//            pieces = FileSpliteUtil.cutDownFile(file);
//        } else {

            FilePiece piece = new FilePiece(1, file.getPath(), 0, fileSize - 1, 1);
            pieces.add(piece);

//        }

        if (pieces != null && pieces.size() > 0) {
            for (FilePiece p : pieces) {
                MultipartEntityBuilder builder = MultipartEntityBuilder.create();
                builder.addPart("file", new FileBody(new File(p.getFilePath())));
                builder.addTextBody("fileId", p.getFileId());
                builder.addTextBody("fileType", fileType);
                builder.addTextBody("chunkIndex", "" + p.getIndex());
                builder.addTextBody("chunkCount", "" + p.getCount());
                builder.addTextBody("fileMD5", "" + fileMD5);
                if(ParamUtil.getFileUpNeedThumburlTypes().contains(fileType)){
                    builder.addTextBody("thumbnail", "1");//需要缩略图
                } else{
                    builder.addTextBody("thumbnail", "0");//不需要缩略图
                }
                builder.addTextBody("thumbnailWidth", "70");//缩略图宽
                builder.addTextBody("thumbnailHeight", "70");//缩略图高
                builder.addTextBody("storageType", "0");
                builder.addTextBody("key", entKey);
                builder.addTextBody("fileName", "" + fileName);

                HttpEntity reqEntity = builder.build();
                LogUtil.info(this.getClass(),reqEntity.toString());


                String resEntityString = sendFileUpReq(reqEntity);
                Assert.notNull(resEntityString,"返回响应为："+resEntityString);
                Assert.hasLength(resEntityString,"返回响应为："+resEntityString);
                String code=resEntityString.substring(resEntityString.indexOf("code")+6,resEntityString.indexOf("code")+7);//截取返回的状态码，为0时表示上传成功
                if(!code.equals("0")||!resEntityString.contains("filePath")){
                    throw new Exception("上传文件失败，返回错误信息为："+resEntityString);
                }
                return resEntityString;
            }
        }

        return null;
    }


    private String sendFileUpReq(HttpEntity reqEntity) throws Exception {
        HttpClientConnectionManager httpClientConnectionManager = new BasicHttpClientConnectionManager();
        HttpClient httpClient = HttpClientBuilder.create().setConnectionManager(httpClientConnectionManager).build();
        HttpPost post = new HttpPost(fileUpUrl);
        HttpEntity resEntity = MultipartEntityBuilder.create().build();
        String res=null;
        try {
            post.setEntity(reqEntity);
            HttpResponse response = httpClient.execute(post);
            int statusCode = response.getStatusLine().getStatusCode();
            Assert.isTrue(statusCode == HttpStatus.SC_OK, "上传文件失败，HttpStatus=" + statusCode);
            resEntity = response.getEntity();
            res=EntityUtils.toString(resEntity);
            EntityUtils.consume(resEntity);
        } catch (Exception e) {
            LogUtil.logError("sendFileUpReq:" + e.getMessage(), this.getClass());
            throw new Exception("sendFileUpReq:" + e.getMessage());
        } finally {
            if (httpClient != null) {
                httpClientConnectionManager.shutdown();
            }
        }
        return res;
    }
}
