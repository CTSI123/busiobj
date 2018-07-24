/*
 * Copyright (C) 2015 China Telecom System Integration Co., Ltd.
 * All rights reserved.
 */

package cn.com.ctsi.busiobj.bean.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;


public class Column implements Serializable {

	//返回列的所有信息用

	private static final long serialVersionUID = 5140639886289574029L;

	@JsonProperty("column_id")
	private Integer columnId;

	@NotNull(message = "The param [column_name] is null.")
	@NotBlank(message = "The param [column_name] is blank.")
	@JsonProperty("column_name")
	private String columnName;

	@NotNull(message = "The param [column_name_desc] is null.")
	@NotBlank(message = "The param [column_name_desc] is blank.")
	@JsonProperty("column_name_desc")
	private String columnNameDesc;


	/**
	 * 1----Boolean
	 * 2----integer
	 * 3----float4
	 * 4----double 经纬度
	 * 5----String varchar(16) 发送人 创建人
	 * 6----timestamp(6)  date
	 * 7----"public"."geometry" Geometry_Point（点）
	 * 8----"public"."geometry" Geometry_Line（线）
	 * 9----"public"."geometry" Geometry_Polygon（面）
	 * 10---int4   Key_Value(单选)
	 * 11---Location（位置）
	 * 12---Picture(图片)
	 * 13---Video(视频)
	 * 14---MetaTable(表类型为模板表时使用)
	 */
	@NotNull(message = "The param [column_type] is null.")
	@Range(min = 1, max = 19, message = "The param [column_type] must be between 1 and 20.")
	@JsonProperty("column_type")
	private Integer columnType;

	@NotNull(message = "The param [length] is null.")
	@Min(value = 0, message = "The param [length] is not be less than 0.")
	@JsonProperty("length")
	private Integer length;

	@JsonProperty("default_value")
	private Object defaultValue;

	@JsonProperty("is_nullable")
	private Boolean isNullable;

	@JsonProperty("is_unique")
	private Boolean isUnique;

	@JsonProperty("is_primary")
	private Boolean isPrimary;

	@Valid
	@JsonProperty("key_values")
	private List<KeyValue> keyValues;

	@JsonProperty("ref_table_name")
	private String refTableName;

	@JsonProperty("topic")
	private String topic;

	/*关联的自定义基础表的id，字段类型为MetaTable时使用*/
	private Integer refTableId;

	@JsonProperty("add_mob_style")
	private String addMobStyle;

	@JsonProperty("edit_mob_style")
	private String editMobStyle;

	@JsonProperty("list_mob_style")
	private String listMobStyle;

	@JsonProperty("view_mob_style")
	private String viewMobStyle;

	@JsonProperty("add_pc_style")
	private String addPcStyle;

	@JsonProperty("edit_pc_style")
	private String editPcStyle;

	@JsonProperty("list_pc_style")
	private String listPcStyle;

	@JsonProperty("view_pc_style")
	private String viewPcStyle;

	@JsonProperty("validation_style")
	private String validationStyle;



	@JsonProperty("can_query")
			private Boolean canQuery;

	//字段排序顺序
	private Integer orderId;
	//字段类型，1-模板字段 2-固定字段
	private Integer fieldType;


	@Override
	public String toString() {
		return "Column{" +
				"columnId=" + columnId +
				", columnName='" + columnName + '\'' +
				", columnNameDesc='" + columnNameDesc + '\'' +
				", columnType=" + columnType +
				", length=" + length +
				", defaultValue=" + defaultValue +
				", isNullable=" + isNullable +
				", isUnique=" + isUnique +
				", isPrimary=" + isPrimary +
				", keyValues=" + keyValues +
				", refTableName='" + refTableName + '\'' +
				", topic='" + topic + '\'' +
				", refTableId=" + refTableId +
				", addMobStyle='" + addMobStyle + '\'' +
				", editMobStyle='" + editMobStyle + '\'' +
				", listMobStyle='" + listMobStyle + '\'' +
				", viewMobStyle='" + viewMobStyle + '\'' +
				", addPcStyle='" + addPcStyle + '\'' +
				", editPcStyle='" + editPcStyle + '\'' +
				", listPcStyle='" + listPcStyle + '\'' +
				", viewPcStyle='" + viewPcStyle + '\'' +
				", validationStyle='" + validationStyle + '\'' +
				", canQuery=" + canQuery +
				", orderId=" + orderId +
				", fieldType=" + fieldType +
				'}';
	}

	/**
	 * Gets column id.
	 *
	 * @return the column id
	 */
	public Integer getColumnId() {
		return columnId;
	}

	/**
	 * Sets column id.
	 *
	 * @param columnId
	 *                the column id
	 */
	public void setColumnId(Integer columnId) {
		this.columnId = columnId;
	}

	/**
	 * Gets column name.
	 *
	 * @return the column name
	 */
	public String getColumnName() {
		return columnName;
	}

	/**
	 * Sets column name.
	 *
	 * @param columnName
	 *                the column name
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * Gets column name desc.
	 *
	 * @return the column name desc
	 */
	public String getColumnNameDesc() {
		return columnNameDesc;
	}

	/**
	 * Sets column name desc.
	 *
	 * @param columnNameDesc
	 *                the column name desc
	 */
	public void setColumnNameDesc(String columnNameDesc) {
		this.columnNameDesc = columnNameDesc;
	}

	/**
	 * Gets column type.
	 *
	 * @return the column type
	 */
	public Integer getColumnType() {
		return columnType;
	}

	/**
	 * Sets column type.
	 *
	 * @param columnType
	 *                the column type
	 */
	public void setColumnType(Integer columnType) {
		this.columnType = columnType;
	}

	/**
	 * Gets length.
	 *
	 * @return the length
	 */
	public Integer getLength() {
		return length;
	}

	/**
	 * Sets length.
	 *
	 * @param length
	 *                the length
	 */
	public void setLength(Integer length) {
		this.length = length;
	}

	/**
	 * Gets default value.
	 *
	 * @return the default value
	 */
	public Object getDefaultValue() {
		return defaultValue;
	}

	/**
	 * Sets default value.
	 *
	 * @param defaultValue
	 *                the default value
	 */
	public void setDefaultValue(Object defaultValue) {
		this.defaultValue = defaultValue;
	}

	/**
	 * Gets is nullable.
	 *
	 * @return the is nullable
	 */
	public Boolean getIsNullable() {
		return isNullable;
	}

	/**
	 * Sets is nullable.
	 *
	 * @param isNullable
	 *                the is nullable
	 */
	public void setIsNullable(Boolean isNullable) {
		this.isNullable = isNullable;
	}

	/**
	 * Gets is unique.
	 *
	 * @return the is unique
	 */
	public Boolean getIsUnique() {
		return isUnique;
	}

	/**
	 * Sets is unique.
	 *
	 * @param isUnique
	 *                the is unique
	 */
	public void setIsUnique(Boolean isUnique) {
		this.isUnique = isUnique;
	}

	/**
	 * Gets is primary.
	 *
	 * @return the is primary
	 */
	public Boolean getIsPrimary() {
		return isPrimary;
	}

	/**
	 * Sets is primary.
	 *
	 * @param isPrimary
	 *                the is primary
	 */
	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	/**
	 * Gets key values.
	 *
	 * @return the key values
	 */
	public List<KeyValue> getKeyValues() {
		return keyValues;
	}

	/**
	 * Sets key values.
	 *
	 * @param keyValues
	 *                the key values
	 */
	public void setKeyValues(List<KeyValue> keyValues) {
		this.keyValues = keyValues;
	}

	public String getRefTableName() {
		return refTableName;
	}

	public void setRefTableName(String refTableName) {
		this.refTableName = refTableName;
	}

	public Integer getRefTableId() {
		return refTableId;
	}

	public void setRefTableId(Integer refTableId) {
		this.refTableId = refTableId;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getAddMobStyle() {
		return addMobStyle;
	}

	public void setAddMobStyle(String addMobStyle) {
		this.addMobStyle = addMobStyle;
	}

	public String getEditMobStyle() {
		return editMobStyle;
	}

	public void setEditMobStyle(String editMobStyle) {
		this.editMobStyle = editMobStyle;
	}

	public String getListMobStyle() {
		return listMobStyle;
	}

	public void setListMobStyle(String listMobStyle) {
		this.listMobStyle = listMobStyle;
	}

	public String getViewMobStyle() {
		return viewMobStyle;
	}

	public void setViewMobStyle(String viewMobStyle) {
		this.viewMobStyle = viewMobStyle;
	}

	public String getAddPcStyle() {
		return addPcStyle;
	}

	public void setAddPcStyle(String addPcStyle) {
		this.addPcStyle = addPcStyle;
	}

	public String getEditPcStyle() {
		return editPcStyle;
	}

	public void setEditPcStyle(String editPcStyle) {
		this.editPcStyle = editPcStyle;
	}

	public String getListPcStyle() {
		return listPcStyle;
	}

	public void setListPcStyle(String listPcStyle) {
		this.listPcStyle = listPcStyle;
	}

	public String getViewPcStyle() {
		return viewPcStyle;
	}

	public void setViewPcStyle(String viewPcStyle) {
		this.viewPcStyle = viewPcStyle;
	}

	public String getValidationStyle() {
		return validationStyle;
	}

	public void setValidationStyle(String validationStyle) {
		this.validationStyle = validationStyle;
	}
	public Boolean getCanQuery() {
		return canQuery;
	}

	public void setCanQuery(Boolean canQuery) {
		this.canQuery = canQuery;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getFieldType() {
		return fieldType;
	}

	public void setFieldType(Integer fieldType) {
		this.fieldType = fieldType;
	}

}
