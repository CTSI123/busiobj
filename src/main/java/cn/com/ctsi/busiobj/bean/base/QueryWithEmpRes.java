package cn.com.ctsi.busiobj.bean.base;

import java.util.List;

public class QueryWithEmpRes extends GeneralResponse {

    /**
     * 企业id
     */
    private Integer id;
    /**
     * 父企业id
     */
    private Integer parentId;
    /**
     * 企业名称
     */
    private String name;
    /**
     * 企业代码
     */
    private String entCode;
    /**
     * 地区代码
     */
    private String areaCode;
    /**
     * 联系人
     */
    private String contact;
    /**
     * 联系方式
     */
    private String contactTel;
    /**
     * email
     */
    private String email;
    /**
     * logo地址
     */
    private String logoUrl;
    /**
     * 登录地址
     */
    private String loginUrl;
    /**
     * 企业key
     */
    private String entKey;
    /**
     * 组织机构树
     */
    private List<Children> children;
    /**
     * 人员列表（包含所属部门id）By Qi
     */
    private List<Employee> employees;
    /**
     * 当前页 by Qi
     */
    private Integer currPage;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 每页记录数 by Qi
     */
    private Integer recNumPerPage;

    @Override
    public String toString() {
        return "QueryWithEmpRes{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", entCode='" + entCode + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", contact='" + contact + '\'' +
                ", contactTel='" + contactTel + '\'' +
                ", email='" + email + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", loginUrl='" + loginUrl + '\'' +
                ", entKey='" + entKey + '\'' +
                ", children=" + children +
                ", employees=" + employees +
                ", currPage=" + currPage +
                ", totalPage=" + totalPage +
                ", recNumPerPage=" + recNumPerPage +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getRecNumPerPage() {
        return recNumPerPage;
    }

    public void setRecNumPerPage(Integer recNumPerPage) {
        this.recNumPerPage = recNumPerPage;
    }
}
