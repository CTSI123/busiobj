package cn.com.ctsi.busiobj.bean.base;

import javax.validation.constraints.NotNull;

public class GetTreeReq {

    //企业id
    @NotNull(message = "the entId is null")
    private Integer entId;
    //用户名id
    @NotNull(message = "the mdn is null")
    private String mdn;


    @Override
    public String toString() {
        return "GetTreeReq{" +
                "entId=" + entId +
                ", mdn='" + mdn + '\'' +
                '}';
    }

    public Integer getEntId() {
        return entId;
    }

    public void setEntId(Integer entId) {
        this.entId = entId;
    }

    public String getMdn() {
        return mdn;
    }

    public void setMdn(String mdn) {
        this.mdn = mdn;
    }
}
