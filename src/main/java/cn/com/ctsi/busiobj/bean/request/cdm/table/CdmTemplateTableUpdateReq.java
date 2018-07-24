package cn.com.ctsi.busiobj.bean.request.cdm.table;


import cn.com.ctsi.busiobj.bean.base.Content;
import cn.com.ctsi.busiobj.bean.request.common.Domain;
import cn.com.ctsi.busiobj.bean.request.common.UpdateColumn;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;


public class CdmTemplateTableUpdateReq extends TableReq implements Serializable {

	private static final long serialVersionUID = 2470632177528768612L;

	@NotNull(message = "The param [table_name] is null.")
	@JsonProperty("table_name")
	private String tableName;

	@JsonProperty("table_id")
	private Integer tableId;

	@NotNull(message = "The param [op] is null.")
	@Range(min = 1, max = 7, message = "The op must be between 1 and 7.")
	private Integer op;

	@Valid
	private Content content;

	@Valid
	private List<UpdateColumn> columns;

//	@Valid
//	private List<Domain> domains;


	@Override
	public String toString() {
		return "CdmTemplateTableUpdateReq{" +
				"tableName='" + tableName + '\'' +
				", tableId=" + tableId +
				", op=" + op +
				", content=" + content +
				", columns=" + columns +
//				", domains=" + domains +
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
	 * Gets op.
	 *
	 * @return the op
	 */
	public Integer getOp() {
		return op;
	}

	/**
	 * Sets op.
	 *
	 * @param op
	 *                the op
	 */
	public void setOp(Integer op) {
		this.op = op;
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
	 * @param content
	 *                the content
	 */
	public void setContent(Content content) {
		this.content = content;
	}

	/**
	 * Gets columns.
	 *
	 * @return the columns
	 */
	public List<UpdateColumn> getColumns() {
		return columns;
	}

	/**
	 * Sets columns.
	 *
	 * @param columns
	 *                the columns
	 */
	public void setColumns(List<UpdateColumn> columns) {
		this.columns = columns;
	}

	/**
	 * Gets domains.
	 *
	 * @return the domains
	 */
//	public List<Domain> getDomains() {
//		return domains;
//	}
//
//	/**
//	 * Sets domains.
//	 *
//	 * @param domains
//	 *                the domains
//	 */
//	public void setDomains(List<Domain> domains) {
//		this.domains = domains;
//	}

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
}
