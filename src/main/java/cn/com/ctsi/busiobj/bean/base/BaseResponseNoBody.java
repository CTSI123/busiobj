package cn.com.ctsi.busiobj.bean.base;

public class BaseResponseNoBody {

    public static final int API_RESULT_SUCCESS = 1;
    public static final int API_RESULT_FAIL = 0;

    private int code = 1;
    private String message;
    private long timestamp;

    @Override
    public String toString() {
        return "BaseResponseNoBody{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
