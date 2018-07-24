/*
 * Copyright (C) 2015 China Telecom System Integration Co., Ltd.
 * All rights reserved.
 */

package cn.com.ctsi.busiobj.bean.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


public class Content implements Serializable {

	private static final long serialVersionUID = 4478452497029714963L;

	@JsonProperty("table_id")
	private Integer tableId;

	@NotNull(message = "The param [table_name] is null.")
	@NotBlank(message = "The param [table_name] is blank.")
	@JsonProperty("table_name")
	private String tableName;

	// @NotNull(message = "The param [table_name_desc] is null.")
	// @NotBlank(message = "The param [table_name_desc] is blank.")
	@JsonProperty("table_name_desc")
	private String tableNameDesc;


	/**
	 * 1.基础表   2.模板表
	 */
	@NotNull(message = "The param [table_type] is null.")
	@Range(min = 1, max = 2, message = "The param [table_type] must be between 1 and 2.")
	@JsonProperty("table_type")
	private Integer tableType;

	@JsonProperty("table_topic")
	private String tableTopic;

	@Override
	public String toString() {
		return "Content{" +
				"tableId=" + tableId +
				", tableName='" + tableName + '\'' +
				", tableNameDesc='" + tableNameDesc + '\'' +
				", tableType=" + tableType +
				", tableTopic='" + tableTopic + '\'' +
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

	/**
	 * Gets table name.
	 *
	 * @return the table name
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * Sets table name.
	 *
	 * @param tableName
	 *                the table name
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * Gets table name desc.
	 *
	 * @return the table name desc
	 */
	public String getTableNameDesc() {
		return tableNameDesc;
	}

	/**
	 * Sets table name desc.
	 *
	 * @param tableNameDesc
	 *                the table name desc
	 */
	public void setTableNameDesc(String tableNameDesc) {
		this.tableNameDesc = tableNameDesc;
	}

	/**
	 * Gets table type.
	 *
	 * @return the table type
	 */
	public Integer getTableType() {
		return tableType;
	}

	/**
	 * Sets table type.
	 *
	 * @param tableType
	 *                the table type
	 */
	public void setTableType(Integer tableType) {
		this.tableType = tableType;
	}

	public String getTableTopic() {
		return tableTopic;
	}

	public void setTableTopic(String tableTopic) {
		this.tableTopic = tableTopic;
	}

}
