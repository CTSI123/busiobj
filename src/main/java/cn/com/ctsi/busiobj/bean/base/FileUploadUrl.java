package cn.com.ctsi.busiobj.bean.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class FileUploadUrl {

    @NotNull(message = "The param [column_name] is null")
    @JsonProperty("column_name")
    private String columnName;//文件上传的列名

    @NotNull(message = "The param [file_path] is null")
    @JsonProperty("file_path")
    private String filePath;//文件url

    @JsonProperty("thumbnail_path")
    private String thumbnailPath;//缩略图url

    @JsonProperty("frame_image_path")
    private String frameImgPath;//视频第一帧图像url

    @Override
    public String toString() {
        return "BOFileResponse{" +
                "columnName='" + columnName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", thumbnailPath='" + thumbnailPath + '\'' +
                ", frameImgPath='" + frameImgPath + '\'' +
                '}';
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    public String getFrameImgPath() {
        return frameImgPath;
    }

    public void setFrameImgPath(String frameImgPath) {
        this.frameImgPath = frameImgPath;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

}
