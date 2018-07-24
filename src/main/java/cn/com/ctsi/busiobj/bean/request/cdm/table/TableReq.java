/*
 * Copyright (C) 2015 China Telecom System Integration Co., Ltd.
 * All rights reserved.
 */

package cn.com.ctsi.busiobj.bean.request.cdm.table;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * The type Table req.
 */
public class TableReq implements Serializable {

	private static final long serialVersionUID = -7425284393674254378L;

	@JsonProperty("pro_id")
	private Integer proId;

	@JsonProperty("ent_id")
	private Integer entId;

	@NotNull(message = "The param [key] should not be null.")
	@JsonProperty("key")
	private String key;


	@Override
	public String toString() {
		return "TableReq{" +
				"proId=" + proId +
				", entId=" + entId +
				", key='" + key + '\'' +
				'}';
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
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


}
