package cn.com.ctsi.busiobj.bean.base;


import java.util.UUID;

public class FilePiece {
    private int index;//当前索引
    private String filePath;
    private long start;
    private long end;
    private String fileId;
    private int count;//总数

    public FilePiece() {
        this.fileId=UUID.randomUUID().toString();
    }

    public FilePiece(int count, String filePath, long start, long end, int index) {
        this.count = count;
        this.fileId = UUID.randomUUID().toString();
        this.filePath = filePath;
        this.start = start;
        this.end = end;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
