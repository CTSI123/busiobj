package cn.com.ctsi.busiobj.bean.base;

public class GeneralResponse {
    public static final String CODE_SUCCESS="0";
    public static final String CODE_FAIL="1";


    private String code;
    private String info;

    @Override
    public String toString() {
        return "GeneralResponse{" +
                "code='" + code + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    public GeneralResponse() {
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}