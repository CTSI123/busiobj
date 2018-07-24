package cn.com.ctsi.busiobj.bean.base;

import cn.com.ctsi.busiobj.util.BaseBean;

import java.util.List;

public class Employee implements Comparable<Employee> {

    /**
     * 人员id
     */
    private Integer id;
    /**
     * 手机号
     */
    private String mdn;
    /**
     * 名称
     */
    private String name;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 所属企业  created By Qi
     */
    private Integer entId;
    /**
     * 是否关注
     */
    private Integer isAttention;
    /**
     * 定位方式  created By Qi
     */
    private Integer locationMode;

    /**
     * 定位激活状态  created By Qi
     */
    private Integer activeStatus;

    /**
     * 附加角色属性
     */
    private List<Role> roles;

    /**
     * 最新位置 created By Qi
     */
    private String locInfo;
    /**
     * 定位时间，格式：yyyy-MM-dd HH:mm:ss  created By Qi
     */
    private String locTime;

    /**
     * 用户id  created By Qi
     */
    private Integer userId;

    /**
     * 用户名  created By Qi
     */
    private String userName;

    /**
     * 用户账号状态  created By Qi
     */
    private Integer userStatus;

    /**
     * 部门id  created By Qi
     */
    private Integer depId;

    /**
     * 部门名  created By Qi
     */
    private String depName;

    /**
     * 部门名列表  created By Qi
     */
    private List<String> depNames;

    /**
     * 添加时间，格式：yyyy-MM-dd HH:mm:ss  created By Qi
     */
    private String addTime;

    /**
     * 账号上次登录时间，格式：yyyy-MM-dd HH:mm:ss  created By Qi
     */
    private String loginTime;

    /**
     * 实际定位结果中的定位类型
     */
    private Integer locType;

    /**
     * 描述
     */
    private String remark;

    private Integer status;

    @Override
    public int compareTo(Employee e) {
        // 只能对一个字段做比较，如果做整个对象的比较就实现不了按指定字段排序了。
        if (BaseBean.isNotEmpty(this.getLocTime()) && BaseBean.isNotEmpty(e.getLocTime())) {//只比较有定位时间的项
            return this.getLocTime().compareTo(e.getLocTime());
        } else {
            if (BaseBean.isNotEmpty(this.getLocTime()) && BaseBean.isEmpty(e.getLocTime())) {//有定位时间的项排在前面
                return 1;
            } else {
                return -1;
            }
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMdn() {
        return mdn;
    }

    public void setMdn(String mdn) {
        this.mdn = mdn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
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

    public Integer getLocationMode() {
        return locationMode;
    }

    public void setLocationMode(Integer locationMode) {
        this.locationMode = locationMode;
    }

    public Integer getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Integer activeStatus) {
        this.activeStatus = activeStatus;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getLocInfo() {
        return locInfo;
    }

    public void setLocInfo(String locInfo) {
        this.locInfo = locInfo;
    }

    public String getLocTime() {
        return locTime;
    }

    public void setLocTime(String locTime) {
        this.locTime = locTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public List<String> getDepNames() {
        return depNames;
    }

    public void setDepNames(List<String> depNames) {
        this.depNames = depNames;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getLocType() {
        return locType;
    }

    public void setLocType(Integer locType) {
        this.locType = locType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}