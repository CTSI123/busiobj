/*
 * Copyright (C) 2015 China Telecom System Integration Co., Ltd.
 * All rights reserved.
 */

package cn.com.ctsi.busiobj.bean.base;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


public class KeyValue implements Serializable {

    private static final long serialVersionUID = -6118986283168692075L;

    @NotNull(message = "The param [key] is null.")
    private Integer key;

    @NotNull(message = "The param [value] is null.")
    private String value;

    @Override
    public String toString() {
        return "KeyValue{" +
                "key=" + key +
                ", value='" + value + '\'' +
                '}';
    }

    /**
     * Gets key.
     *
     * @return the key
     */
    public Integer getKey() {
        return key;
    }

    /**
     * Sets key.
     *
     * @param key the key
     */
    public void setKey(Integer key) {
        this.key = key;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue(String value) {
        this.value = value;
    }
}
