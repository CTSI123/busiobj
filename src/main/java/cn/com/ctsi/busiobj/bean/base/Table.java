/*
 * Copyright (C) 2015 China Telecom System Integration Co., Ltd.
 * All rights reserved.
 */

package cn.com.ctsi.busiobj.bean.base;


import java.io.Serializable;
import java.util.List;


public class Table implements Serializable {

    private static final long serialVersionUID = -5577538720051099362L;
    private Content content;
    private List<Column> columns;

    @Override
    public String toString() {
        return "Table{" +
                "content=" + content +
                ", columns=" + columns +
                '}';
    }

    /**
     * Gets content.
     *
     * @return the content
     */
    public Content getContent() {
        return content;
    }

    /**
     * Sets content.
     *
     * @param content the content
     */
    public void setContent(Content content) {
        this.content = content;
    }

    /**
     * Gets columns.
     *
     * @return the columns
     */
    public List<Column> getColumns() {
        return columns;
    }

    /**
     * Sets columns.
     *
     * @param columns the columns
     */
    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

}
