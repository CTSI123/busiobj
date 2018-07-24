package cn.com.ctsi.busiobj.bean.base;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class SelectFilter implements Serializable {

    private static final long serialVersionUID = 7472270503691008006L;
    @NotNull(message = "The name of SelectFilter is null.")
    private String name;

    @NotNull(message = "The show of SelectFilter is null.")
    private Boolean show;

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
     * Is show.
     *
     * @return the boolean
     */
    public Boolean isShow() {
        return show;
    }

    /**
     * Sets show.
     *
     * @param show the show
     */
    public void setShow(Boolean show) {
        this.show = show;
    }

    @Override
    public String toString() {
        return "SelectFilter{" +
                "name='" + name + '\'' +
                ", show=" + show +
                '}';
    }
}

