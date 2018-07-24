/*
 * Copyright (C) 2015 China Telecom System Integration Co., Ltd.
 * All rights reserved.
 */

package cn.com.ctsi.busiobj.bean.base;

import java.io.Serializable;


public class Status implements Serializable {

    public static Integer CODE_SUCCESS=0;
    public static Integer CODE_FAIL=1;
    private static final long serialVersionUID = 6388735705298093443L;
    private Integer code;
    private String desc;


    @Override
    public String toString() {
        return "Status{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * Gets desc.
     *
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Sets desc.
     *
     * @param desc the desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
