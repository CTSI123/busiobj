package cn.com.ctsi.busiobj.bean.base;

public class DepGetRequest {

    private Integer depId;
    private Integer entId;
    private Integer userId;

    @Override
    public String toString() {
        return "DepGetRequest{" +
                "depId=" + depId +
                ", entId=" + entId +
                ", userId=" + userId +
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
