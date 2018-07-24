package cn.com.ctsi.busiobj.bean.base;

public class DepGetResponse {

    private DepartmentRequest department;

    private String code;
    private String info;

    public DepartmentRequest getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentRequest department) {
        this.department = department;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "DepGetResponse{" +
                "department=" + department +
                ", code='" + code + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
