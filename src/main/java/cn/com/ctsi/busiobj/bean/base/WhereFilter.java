package cn.com.ctsi.busiobj.bean.base;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

public class WhereFilter implements Serializable {

    private static final long serialVersionUID = -4404841949459463449L;
    @Valid
    private List<ColumnLimit> and;
    @Valid
    private List<ColumnLimit> or;


    public List<ColumnLimit> getAnd() {
        return and;
    }

    public void setAnd(List<ColumnLimit> and) {
        this.and = and;
    }

    public List<ColumnLimit> getOr() {
        return or;
    }

    public void setOr(List<ColumnLimit> or) {
        this.or = or;
    }

    @Override
    public String toString() {
        return "WhereFilter{" +
                "and=" + and +
                ", or=" + or +
                '}';
    }
}

