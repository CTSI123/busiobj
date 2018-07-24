/*
 * Copyright (C) 2015 China Telecom System Integration Co., Ltd.
 * All rights reserved.
 */

package cn.com.ctsi.busiobj.bean.base;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


public class Data implements Serializable {

    private static final long serialVersionUID = -1282412492191500084L;
    @NotNull(message = "The param [key] is null.")
    private String key;

    @NotNull(message = "The param [value] is null.")
    private Object value;

    @Override
    public String toString() {
        return "Data{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}
