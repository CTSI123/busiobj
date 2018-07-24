package cn.com.ctsi.busiobj.bean.base;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public class Filter implements Serializable {

    private static final long serialVersionUID = -2602279143309825790L;

    @Valid
    @NotNull(message = "The param [select] is null.")
    private List<SelectFilter> select;

    @Valid
    private WhereFilter where;
    @Valid
    private List<OrderFilter> order;

    @Override
    public String toString() {
        return "Filter{" +
                "select=" + select +
                ", where=" + where +
                ", order=" + order +
                '}';
    }

    /**
     * Gets select.
     *
     * @return the select
     */
    public List<SelectFilter> getSelect() {
        return select;
    }

    /**
     * Sets select.
     *
     * @param select the select
     */
    public void setSelect(List<SelectFilter> select) {
        this.select = select;
    }

    /**
     * Gets where.
     *
     * @return the where
     */
    public WhereFilter getWhere() {
        return where;
    }

    /**
     * Sets where.
     *
     * @param where the where
     */
    public void setWhere(WhereFilter where) {
        this.where = where;
    }

    /**
     * Gets order.
     *
     * @return the order
     */
    public List<OrderFilter> getOrder() {
        return order;
    }

    /**
     * Sets order.
     *
     * @param order the order
     */
    public void setOrder(List<OrderFilter> order) {
        this.order = order;
    }
}

