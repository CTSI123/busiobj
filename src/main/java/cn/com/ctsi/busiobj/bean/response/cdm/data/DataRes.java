/*
 * Copyright (C) 2015 China Telecom System Integration Co., Ltd.
 * All rights reserved.
 */

package cn.com.ctsi.busiobj.bean.response.cdm.data;

import cn.com.ctsi.busiobj.bean.base.Status;

import java.io.Serializable;


public class DataRes implements Serializable {

    private static final long serialVersionUID = -8332374997889470634L;

    private Status status;

    @Override
    public String toString() {
        return "DataRes{" +
                "status=" + status +
                '}';
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(Status status) {
        this.status = status;
    }
}
