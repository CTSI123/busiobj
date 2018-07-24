package cn.com.ctsi.busiobj.bean.base;

import javax.validation.constraints.NotNull;

public class GetDepartmentNameReq{

    @NotNull(message = "the deptId is null")
    private Integer depId;
    @NotNull(message = "the entId is null")
    private Integer entId;
    @NotNull(message = "the mdn is null")
    private String mdn;

    @Override
    public String toString() {
        return "DepartMentController{" +
                "depId=" + depId +
                ", entId=" + entId +
                ", mdn='" + mdn + '\'' +
                '}';
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
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
