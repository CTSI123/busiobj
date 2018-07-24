/*
 * Copyright (C) 2015 China Telecom System Integration Co., Ltd.
 * All rights reserved.
 */

package cn.com.ctsi.busiobj.bean.base;

import java.io.Serializable;

/**
 * Created by RenDi on 2015/4/10.
 */
public class TableRes implements Serializable {

    private static final long serialVersionUID = -5978069157441184669L;
    private Status status;

    @Override
    public String toString() {
        return "TableRes{" +
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
