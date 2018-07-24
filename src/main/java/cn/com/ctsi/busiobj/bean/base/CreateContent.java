/*
 * Copyright (C) 2015 China Telecom System Integration Co., Ltd.
 * All rights reserved.
 */

package cn.com.ctsi.busiobj.bean.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * The type Create content.
 */
public class CreateContent implements Serializable {

	private static final long serialVersionUID = 2147608968710877780L;

	@JsonProperty("table_id")
	private Integer tableId;

	@Override
	public String toString() {
		return "CreateContent{" +
				"tableId=" + tableId +
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
}
