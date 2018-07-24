package cn.com.ctsi.busiobj.bean.request.common;

import cn.com.ctsi.busiobj.bean.base.KeyValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;


public class UpdateColumn implements Serializable {

	private static final long serialVersionUID = -3132284793457990564L;

	@JsonProperty("column_id")
	@NotNull(message = "The col_id is null")
	private Integer columnId;

	@JsonProperty("column_name")
	@NotNull(message = "The col_name is null")
	private String columnName;

	@JsonProperty("column_name_desc")
	private String columnNameDesc;

	@Range(min = 1, max = 19, message = "The param [column_type] must be between 1 and 19.")
	@JsonProperty("column_type")
	private Integer columnType;

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

	@JsonProperty("can_query")
	private Boolean canQuery;

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
	//字段排序顺序更改
	@JsonProperty("order_id")
	private  Integer orderId;

	//字段属于模板字段1还是固定字段2
	@JsonProperty("field_type")
	private Integer fieldType;

	@JsonProperty("ref_table_id")
	private Integer refTableId;

	@JsonProperty("validation_style")
	private String validationStyle;

	@Override
	public String toString() {
		return "UpdateColumn{" +
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
				", canQuery=" + canQuery +
				", addMobStyle='" + addMobStyle + '\'' +
				", editMobStyle='" + editMobStyle + '\'' +
				", listMobStyle='" + listMobStyle + '\'' +
				", viewMobStyle='" + viewMobStyle + '\'' +
				", addPcStyle='" + addPcStyle + '\'' +
				", editPcStyle='" + editPcStyle + '\'' +
				", listPcStyle='" + listPcStyle + '\'' +
				", viewPcStyle='" + viewPcStyle + '\'' +
				", orderId=" + orderId +
				", fieldType=" + fieldType +
				", refTableId=" + refTableId +
				", validationStyle='" + validationStyle + '\'' +
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

	public Boolean getCanQuery() {
		return canQuery;
	}

	public void setCanQuery(Boolean canQuery) {
		this.canQuery = canQuery;
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


	public Integer getRefTableId() {
		return refTableId;
	}

	public void setRefTableId(Integer refTableId) {
		this.refTableId = refTableId;
	}

	public String getValidationStyle() {
		return validationStyle;
	}

	public void setValidationStyle(String validationStyle) {
		this.validationStyle = validationStyle;
	}
}
