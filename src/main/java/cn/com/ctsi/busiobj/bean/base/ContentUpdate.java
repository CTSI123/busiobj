package cn.com.ctsi.busiobj.bean.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

public class ContentUpdate {

    @JsonProperty("table_id")
    @NotNull(message = "The param [table_id] is null.")
    private Integer tableId;

    @JsonProperty("table_name")
    private String tableName;

    @JsonProperty("table_name_desc")
    private String tableNameDesc;

    /**
     * 1.基础表   2.模板表
     */
    @NotNull(message = "The param [table_type] is null.")
    @Range(min = 1, max = 2, message = "The param [table_type] must be between 1 and 2.")
    @JsonProperty("table_type")
    private Integer tableType;

    @Override
    public String toString() {
        return "ContentUpdate{" +
                "tableId=" + tableId +
                ", tableName='" + tableName + '\'' +
                ", tableNameDesc='" + tableNameDesc + '\'' +
                ", tableType=" + tableType +
                '}';
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableNameDesc() {
        return tableNameDesc;
    }

    public void setTableNameDesc(String tableNameDesc) {
        this.tableNameDesc = tableNameDesc;
    }

    public Integer getTableType() {
        return tableType;
    }

    public void setTableType(Integer tableType) {
        this.tableType = tableType;
    }
}
