/*
 * Copyright (C) 2015 China Telecom System Integration Co., Ltd.
 * All rights reserved.
 */

package cn.com.ctsi.busiobj.bean.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * The type Create column.
 */
public class CreateColumn implements Serializable {

    private static final long serialVersionUID = 7795497948112737098L;

    @JsonProperty("column_id")
    private String columnId;

    @JsonProperty("column_name")
    private String columnName;

    @Override
    public String toString() {
        return "CreateColumn{" +
                "columnId='" + columnId + '\'' +
                ", columnName='" + columnName + '\'' +
                '}';
    }

    /**
     * Gets column id.
     *
     * @return the column id
     */
    public String getColumnId() {
        return columnId;
    }

    /**
     * Sets column id.
     *
     * @param columnId the column id
     */
    public void setColumnId(String columnId) {
        this.columnId = columnId;
    }

    /**
     * Gets column name.
     *
     * @return the column name
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * Sets column name.
     *
     * @param columnName the column name
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
}
