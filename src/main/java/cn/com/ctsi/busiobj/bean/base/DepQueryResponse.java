package cn.com.ctsi.busiobj.bean.base;

import java.util.List;

/**
 * The type Dep query response.
 */
public class DepQueryResponse extends GeneralResponse {

    private List<Department> departments;

    @Override
    public String toString() {
        return "DepQueryResponse{" +
                "departments=" + departments +
                '}';
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


}
