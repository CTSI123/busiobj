/*
 * Copyright (C) 2015 China Telecom System Integration Co., Ltd.
 * All rights reserved.
 */

package cn.com.ctsi.busiobj.bean.request.cdm.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * The type Data req.
 */
public class DataReq implements Serializable {

	private static final long serialVersionUID = 7406077889481244931L;

	@JsonProperty("pro_id")
	private Integer proId;

	@JsonProperty("ent_id")
	private Integer entId;

	@NotNull(message = "The param [key] should not be null.")
	@JsonProperty("key")
	private String key;

	@NotNull(message = "The param [table_name] is null.")
	@JsonProperty("table_name")
	private String tableName;

	@JsonProperty("table_id")
	private Integer tableId;


	@Override
	public String toString() {
		return "DataReq{" +
				"proId=" + proId +
				", entId=" + entId +
				", key='" + key + '\'' +
				", tableName='" + tableName + '\'' +
				", tableId=" + tableId +
				'}';
	}

	public Integer getProId() {
		return proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public Integer getEntId() {
		return entId;
	}

	public void setEntId(Integer entId) {
		this.entId = entId;
	}

	public Integer getTableId() {
		return tableId;
	}


	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
