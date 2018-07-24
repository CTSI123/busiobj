package cn.com.ctsi.busiobj.bean.base;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

public class ColumnLimit {
    //设置查询条件用

    @NotNull(message = "The name of ColumnLimit is null.")
    private String name;
    @NotNull(message = "The type of ColumnLimit is null.")
    @Range(min = 0, max = 12, message = "The type of column_limit is between 1 and 12.")
    private Integer type;
    @NotNull(message = "The value of ColumnLimit is null.")
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ColumnLimit{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", value='" + value + '\'' +
                '}';
    }
}
