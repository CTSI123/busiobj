package cn.com.ctsi.busiobj.bean.base;

import java.util.List;

public class Children {

    private Integer id;
    /**
     * 排序index
     */
    private Integer index;
    /**
     * 手机号
     */
    private String mdn;
    /**
     * logo url
     */
    private String logoUrl;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 备注
     */
    private String remark;
    /**
     * 定位方式：2 粗定位 4客户端定位（字段对应值与云平台一致）
     */
    private Integer locationMode;
    /**
     * 名称
     */
    private String name;
    /**
     * 是否为部门  0是1不是
     */
    private Integer isDep;
    /**
     * 是否被关注  0是1不是
     */
    private Integer isAttention;
    /**
     * 企业key
     */
    private String entKey;
    /**
     * 下级部门，人员
     */
    private List<Children> children;

    @Override
    public String toString() {
        return "Children{" +
                "id=" + id +
                ", index=" + index +
                ", mdn='" + mdn + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", gender=" + gender +
                ", remark='" + remark + '\'' +
                ", locationMode=" + locationMode +
                ", name='" + name + '\'' +
                ", isDep=" + isDep +
                ", isAttention=" + isAttention +
                ", entKey='" + entKey + '\'' +
                ", children=" + children +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getMdn() {
        return mdn;
    }

    public void setMdn(String mdn) {
        this.mdn = mdn;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getLocationMode() {
        return locationMode;
    }

    public void setLocationMode(Integer locationMode) {
        this.locationMode = locationMode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsDep() {
        return isDep;
    }

    public void setIsDep(Integer isDep) {
        this.isDep = isDep;
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

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }
}
