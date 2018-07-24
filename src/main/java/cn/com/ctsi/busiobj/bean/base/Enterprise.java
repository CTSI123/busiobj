package cn.com.ctsi.busiobj.bean.base;


public class Enterprise {

    //企业id
    private Integer id;
    //父企业id
    private Integer parentId;
    //企业名称
    private String name;
    //企业代码
    private String entCode;
    //地区代码
    private String areaCode;
    //联系人
    private String contact;
    //联系方式
    private String contactTel;
    //email
    private String email;
    //logo地址
    private String logoUrl;
    //登录地址
    private String loginUrl;
    //企业key
    private String entKey;
    //定位方式
    private Integer locType;
    //销售品code
    private String packageCode;

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
     * Gets ent code.
     *
     * @return the ent code
     */
    public String getEntCode() {
        return entCode;
    }

    /**
     * Sets ent code.
     *
     * @param entCode the ent code
     */
    public void setEntCode(String entCode) {
        this.entCode = entCode;
    }

    /**
     * Gets area code.
     *
     * @return the area code
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * Sets area code.
     *
     * @param areaCode the area code
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * Gets contact.
     *
     * @return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * Sets contact.
     *
     * @param contact the contact
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * Gets contact tel.
     *
     * @return the contact tel
     */
    public String getContactTel() {
        return contactTel;
    }

    /**
     * Sets contact tel.
     *
     * @param contactTel the contact tel
     */
    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets logo url.
     *
     * @return the logo url
     */
    public String getLogoUrl() {
        return logoUrl;
    }

    /**
     * Sets logo url.
     *
     * @param logoUrl the logo url
     */
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    /**
     * Gets login url.
     *
     * @return the login url
     */
    public String getLoginUrl() {
        return loginUrl;
    }

    /**
     * Sets login url.
     *
     * @param loginUrl the login url
     */
    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    /**
     * Gets loc type.
     *
     * @return the loc type
     */
    public Integer getLocType() {
        return locType;
    }

    /**
     * Sets loc type.
     *
     * @param locType the loc type
     */
    public void setLocType(Integer locType) {
        this.locType = locType;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }
}
