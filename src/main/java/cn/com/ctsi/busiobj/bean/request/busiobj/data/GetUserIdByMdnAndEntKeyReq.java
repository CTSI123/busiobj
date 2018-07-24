package cn.com.ctsi.busiobj.bean.request.busiobj.data;

public class GetUserIdByMdnAndEntKeyReq {

    private String mdn;

    private String entKey;

    @Override
    public String toString() {
        return "GetUserIdByMdnAndEntKeyReq{" +
                "mdn='" + mdn + '\'' +
                ", entKey='" + entKey + '\'' +
                '}';
    }

    public String getMdn() {
        return mdn;
    }

    public void setMdn(String mdn) {
        this.mdn = mdn;
    }

    public String getEntKey() {
        return entKey;
    }

    public void setEntKey(String entKey) {
        this.entKey = entKey;
    }
}
