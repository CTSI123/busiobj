package cn.com.ctsi.busiobj.bean.response;

public class SelfDefMenuAddRes {
    public static final String CODE_SUCCESS="0000";
    public static final String CODE_FAIL="0001";

    private String code;//返回码
    private String info;//返回信息

    @Override
    public String toString() {
        return "SelfDefMenuAddRes{" +
                "code='" + code + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
