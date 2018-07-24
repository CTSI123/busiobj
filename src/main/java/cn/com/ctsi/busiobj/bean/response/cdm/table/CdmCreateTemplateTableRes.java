/*
 * Copyright (C) 2015 China Telecom System Integration Co., Ltd.
 * All rights reserved.
 */

package cn.com.ctsi.busiobj.bean.response.cdm.table;


import cn.com.ctsi.busiobj.bean.base.CreateColumn;
import cn.com.ctsi.busiobj.bean.base.CreateContent;
import cn.com.ctsi.busiobj.bean.base.TableRes;

import java.io.Serializable;
import java.util.List;


public class CdmCreateTemplateTableRes extends TableRes implements Serializable {

    private static final long serialVersionUID = 5266649532468811317L;

    private CreateContent content;

    private List<CreateColumn> columns;

    @Override
    public String toString() {
        return "CdmCreateTemplateTableRes{" +
                "content=" + content +
                ", columns=" + columns +
                '}';
    }

    /**
     * Gets content.
     *
     * @return the content
     */
    public CreateContent getContent() {
        return content;
    }

    /**
     * Sets content.
     *
     * @param content the content
     */
    public void setContent(CreateContent content) {
        this.content = content;
    }

    /**
     * Gets columns.
     *
     * @return the columns
     */
    public List<CreateColumn> getColumns() {
        return columns;
    }

    /**
     * Sets columns.
     *
     * @param columns the columns
     */
    public void setColumns(List<CreateColumn> columns) {
        this.columns = columns;
    }
}
