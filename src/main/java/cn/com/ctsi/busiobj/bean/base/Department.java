package cn.com.ctsi.busiobj.bean.base;

import java.util.List;


public class Department {

    //部门id
    private Integer id;
    //名称
    private String name;
    //父id 0为没有上级（已改为等于部门id时没有上级）
   private Integer parentId;
    //企业id
    private Integer entId;
    //是否被关注（1 关注 0 未关注）
    private Integer isAttention;
    //企业key
    private String entKey;
    //下级部门
    private String remark;
    private List<Department> departments;
    private String cpsFlag;
    private String cpsId;
    private Integer status;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", entId=" + entId +
                ", isAttention=" + isAttention +
                ", entKey='" + entKey + '\'' +
                ", remark='" + remark + '\'' +
                ", departments=" + departments +
                ", cpsFlag='" + cpsFlag + '\'' +
                ", cpsId='" + cpsId + '\'' +
                ", status=" + status +
                '}';
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets parent id.
     *
     * @return the parent id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * Sets parent id.
     *
     * @param parentId the parent id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * Gets ent id.
     *
     * @return the ent id
     */
    public Integer getEntId() {
        return entId;
    }

    /**
     * Sets ent id.
     *
     * @param entId the ent id
     */
    public void setEntId(Integer entId) {
        this.entId = entId;
    }

    /**
     * Gets is attention.
     *
     * @return the is attention
     */
    public Integer getIsAttention() {
        return isAttention;
    }

    /**
     * Sets is attention.
     *
     * @param isAttention the is attention
     */
    public void setIsAttention(Integer isAttention) {
        this.isAttention = isAttention;
    }

    /**
     * Gets ent key.
     *
     * @return the ent key
     */
    public String getEntKey() {
        return entKey;
    }

    /**
     * Sets ent key.
     *
     * @param entKey the ent key
     */
    public void setEntKey(String entKey) {
        this.entKey = entKey;
    }

    /**
     * Gets remark.
     *
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Sets remark.
     *
     * @param remark the remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * Gets departments.
     *
     * @return the departments
     */
    public List<Department> getDepartments() {
        return departments;
    }

    /**
     * Sets departments.
     *
     * @param departments the departments
     */
    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    /**
     * Gets cps flag.
     *
     * @return the cps flag
     */
    public String getCpsFlag() {
        return cpsFlag;
    }

    /**
     * Sets cps flag.
     *
     * @param cpsFlag the cps flag
     */
    public void setCpsFlag(String cpsFlag) {
        this.cpsFlag = cpsFlag;
    }

    /**
     * Gets cps id.
     *
     * @return the cps id
     */
    public String getCpsId() {
        return cpsId;
    }

    /**
     * Sets cps id.
     *
     * @param cpsId the cps id
     */
    public void setCpsId(String cpsId) {
        this.cpsId = cpsId;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}
