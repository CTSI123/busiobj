/*
 * Copyright (C) 2015 China Telecom System Integration Co., Ltd.
 * All rights reserved.
 */

package cn.com.ctsi.busiobj.bean.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;


public class ColumnLimitCommon implements Serializable {


    @NotNull(message = "The param [column_name] is null.")
    @NotBlank(message = "The param [column_name] is blank.")
    @JsonProperty("column_name")
    private String columnName;

    @NotNull(message = "The param [column_name_desc] is null.")
    @NotBlank(message = "The param [column_name_desc] is blank.")
    @JsonProperty("column_name_desc")
    private String columnNameDesc;

    @JsonProperty("default_value")
    private Object defaultValue;

    @Valid
    @JsonProperty("key_values")
    private List<KeyValue> keyValues;

    @JsonProperty("can_query")
    private Boolean canQuery;

    @JsonProperty("is_nullable")
    private Boolean isNullable;

    @JsonProperty("validation_style")
    private String validationStyle;

    @Override
    public String toString() {
        return "ColumnLimitCommon{" +
                "columnName='" + columnName + '\'' +
                ", columnNameDesc='" + columnNameDesc + '\'' +
                ", defaultValue=" + defaultValue +
                ", keyValues=" + keyValues +
                ", canQuery=" + canQuery +
                ", validationStyle='" + validationStyle + '\'' +
                '}';
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnNameDesc() {
        return columnNameDesc;
    }

    public void setColumnNameDesc(String columnNameDesc) {
        this.columnNameDesc = columnNameDesc;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    public List<KeyValue> getKeyValues() {
        return keyValues;
    }

    public void setKeyValues(List<KeyValue> keyValues) {
        this.keyValues = keyValues;
    }

    public Boolean getCanQuery() {
        return canQuery;
    }

    public void setCanQuery(Boolean canQuery) {
        this.canQuery = canQuery;
    }

    public String getValidationStyle() {
        return validationStyle;
    }

    public void setValidationStyle(String validationStyle) {
        this.validationStyle = validationStyle;
    }

    public Boolean getNullable() {
        return isNullable;
    }

    public void setNullable(Boolean nullable) {
        isNullable = nullable;
    }
}
