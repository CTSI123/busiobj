/*
 * Copyright (C) 2015 China Telecom System Integration Co., Ltd.
 * All rights reserved.
 */

package cn.com.ctsi.busiobj.bean.response.cdm.table;

import cn.com.ctsi.busiobj.bean.base.Table;

import java.io.Serializable;
import java.util.List;


public class CdmTemplateTableQueryRes extends TableRes implements Serializable {

    private static final long serialVersionUID = 4992308656970635162L;

    private List<Table> tables;

    @Override
    public String toString() {
        return "CdmTemplateTableQueryRes{" +
                "tables=" + tables +
                '}';
    }

    /**
     * Gets tables.
     *
     * @return the tables
     */
    public List<Table> getTables() {
        return tables;
    }

    /**
     * Sets tables.
     *
     * @param tables the tables
     */
    public void setTables(List<Table> tables) {
        this.tables = tables;
    }
}
