package cn.com.ctsi.busiobj.bean.base;

import java.util.List;

public class DepartmentRequest {

    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 企业CODE(by Qi 2017/07/18)
     */
    private String entCode;

    private DepartmentParent parent;
    /**
     * 企业id
     */
    private Integer entId;
    /**
     * 是否被关注（1关注 0未关注）
     */
    private Integer isAttention;
    /**
     * 企业key
     */
    private String entKey;
    /**
     * 下级部门
     */
    private String remark = "";

    private String cpsFlag;

    private List<Department> departments;

    @Override
    public String toString() {
        return "DepartmentRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", entCode='" + entCode + '\'' +
                ", parent=" + parent +
                ", entId=" + entId +
                ", isAttention=" + isAttention +
                ", entKey='" + entKey + '\'' +
                ", remark='" + remark + '\'' +
                ", cpsFlag='" + cpsFlag + '\'' +
                ", departments=" + departments +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEntCode() {
        return entCode;
    }

    public void setEntCode(String entCode) {
        this.entCode = entCode;
    }

    public DepartmentParent getParent() {
        return parent;
    }

    public void setParent(DepartmentParent parent) {
        this.parent = parent;
    }

    public Integer getEntId() {
        return entId;
    }

    public void setEntId(Integer entId) {
        this.entId = entId;
    }

    public Integer getIsAttention() {
        return isAttention;
    }

    public void setIsAttention(Integer isAttention) {
        this.isAttention = isAttention;
    }

    public String getEntKey() {
        return entKey;
    }

    public void setEntKey(String entKey) {
        this.entKey = entKey;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCpsFlag() {
        return cpsFlag;
    }

    public void setCpsFlag(String cpsFlag) {
        this.cpsFlag = cpsFlag;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
