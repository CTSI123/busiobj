/*
 * Copyright (C) 2015 China Telecom System Integration Co., Ltd.
 * All rights reserved.
 */

package cn.com.ctsi.busiobj.bean.request.cdm.table;

import cn.com.ctsi.busiobj.bean.base.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 调用cdm平台创建cdm实体表的请求
 */
public class CdmTemplateTableCreateReq extends TableReq implements Serializable {

	private static final long serialVersionUID = 4728576258041395877L;

	@Valid
	@NotNull(message = "The param [content] is null.")
	private Content content;

	@Valid
	@NotNull(message = "The param [columns] is null.")
	private List<Column> columns;

	@JsonProperty("tbl_id")
	private int tblId;

	@Override
	public String toString() {
		return "CdmTemplateTableCreateReq{" +
				"content=" + content +
				", columns=" + columns +
				", tblId=" + tblId +
				'}';
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	public int getTblId() {
		return tblId;
	}

	public void setTblId(int tblId) {
		this.tblId = tblId;
	}
}
