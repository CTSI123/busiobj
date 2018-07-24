/*
 * Copyright (C) 2015 China Telecom System Integration Co., Ltd.
 * All rights reserved.
 */

package cn.com.ctsi.busiobj.bean.request.cdm.table;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


public class CdmTemplateTableDeleteReq extends TableReq implements Serializable {

	private static final long serialVersionUID = -7049409495120941269L;

	@NotNull(message = "The param [table_name] is null.")
	@JsonProperty("table_name")
	private String tableName;

	@JsonProperty("table_id")
	private Integer tableId;

	@Override
	public String toString() {
		return "CdmTemplateTableDeleteReq{" +
				"tableName='" + tableName + '\'' +
				", tableId=" + tableId +
				'}';
	}

	/**
	 * Gets table id.
	 *
	 * @return the table id
	 */
	public Integer getTableId() {
		return tableId;
	}

	/**
	 * Sets table id.
	 *
	 * @param tableId
	 *                the table id
	 */
	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
