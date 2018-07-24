package cn.com.ctsi.busiobj.bean.request.busiobj.upload;


public class FileUploadReq {

    public static Integer STORAGETYPE_FASTDEFS=0;
    public static Integer STORAGETYPE_CLOUD=1;

    private String fileId;

    private Integer storageType;

    private String fileType;

    private Integer chunkIndex;

    private Integer chunkCount;

    private String fileMD5;

    private Integer thumbnail;

    private Integer thumbnailWidth;

    private Integer thumbnailHeight;

    private String fileName;

    private Integer folderId;

    private String key;

    @Override
    public String toString() {
        return "FileUploadReq{" +
                "fileId='" + fileId + '\'' +
                ", storageType=" + storageType +
                ", fileType='" + fileType + '\'' +
                ", chunkIndex=" + chunkIndex +
                ", chunkCount=" + chunkCount +
                ", fileMD5='" + fileMD5 + '\'' +
                ", thumbnail=" + thumbnail +
                ", thumbnailWidth=" + thumbnailWidth +
                ", thumbnailHeight=" + thumbnailHeight +
                ", fileName='" + fileName + '\'' +
                ", folderId=" + folderId +
                ", key='" + key + '\'' +
                '}';
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public Integer getStorageType() {
        return storageType;
    }

    public void setStorageType(Integer storageType) {
        this.storageType = storageType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Integer getChunkIndex() {
        return chunkIndex;
    }

    public void setChunkIndex(Integer chunkIndex) {
        this.chunkIndex = chunkIndex;
    }

    public Integer getChunkCount() {
        return chunkCount;
    }

    public void setChunkCount(Integer chunkCount) {
        this.chunkCount = chunkCount;
    }

    public String getFileMD5() {
        return fileMD5;
    }

    public void setFileMD5(String fileMD5) {
        this.fileMD5 = fileMD5;
    }

    public Integer getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Integer thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getThumbnailWidth() {
        return thumbnailWidth;
    }

    public void setThumbnailWidth(Integer thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
    }

    public Integer getThumbnailHeight() {
        return thumbnailHeight;
    }

    public void setThumbnailHeight(Integer thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
