package cn.com.ctsi.busiobj.bean.base;

public class DepartmentParent {

    private Integer id;

    private String name;

    @Override
    public String toString() {
        return "DepartmentParent{" +
                "id=" + id +
                ", name='" + name + '\'' +
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
}
