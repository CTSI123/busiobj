package cn.com.ctsi.busiobj.bean.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class UserReq {

    @NotNull(message = "The param [enteprise_id] is null.")
    @JsonProperty("enterprise_id")
    private Integer enterpriseId;//企业ID

    @NotNull(message = "The param [mdn] is null.")
    @JsonProperty("mdn")
    private String mdn;//操作人手机号


    @Override
    public String toString() {
        return "UserReq{" +
                "enterpriseId=" + enterpriseId +
                ", mdn='" + mdn + '\'' +
                '}';
    }


    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getMdn() {
        return mdn;
    }

    public void setMdn(String mdn) {
        this.mdn = mdn;
    }
}
