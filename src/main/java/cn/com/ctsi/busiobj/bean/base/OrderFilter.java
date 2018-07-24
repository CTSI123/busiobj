package cn.com.ctsi.busiobj.bean.base;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class OrderFilter implements Serializable {

    private static final long serialVersionUID = 3379240739737488260L;

    @NotNull(message = "The name of OrderFilter is null.")
    private String name;
    @NotNull(message = "The type of OrderFilter is null.")
    @Range(min = 1, max = 2, message = "The type of OrderFilter is between 1 and 2.")
    private Integer type;

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
     * Gets type.
     *
     * @return the type
     */
    public Integer getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "OrderFilter{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}

