package cn.com.ctsi.busiobj.bean.request.busiobj.table;


import cn.com.ctsi.busiobj.bean.base.Column;
import cn.com.ctsi.busiobj.bean.request.common.BaseRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public class CreateTemplateTableRequest extends BaseRequest implements Serializable{

    private static final long serialVersionUID = 1646053061961774982L;

    @NotNull(message = "The param [enterprise_id] is null.")
    @JsonProperty("enterprise_id")
    private Integer enterpriseId;

    @NotNull(message = "The param [table_name] is null.")
    @NotBlank(message = "The param [table_name] is blank.")
    @JsonProperty("table_name")
    private String tableName;

    @JsonProperty("table_id")
    private int tblId;

    @JsonProperty("table_desc")
    private String tbDesc;


    @NotNull(message = "The param [table_type] is null.")
    @Range(min = 1, max = 3, message = "The param [table_type] must be between 1 and 3.")
    //1.基础表 2.模板表  3.业务数据自定义表
    @JsonProperty("table_type")
    private Integer tableType;

    @NotNull(message = "The param [column_list] is null.")
    @NotEmpty(message = "The param [column_list] is blank.")
    @JsonProperty("column_list")
    private List<Column> columnList;

    @Override
    public String toString() {
        return "CreateTemplateTableRequest{" +
                "enterpriseId=" + enterpriseId +
                ", tableName='" + tableName + '\'' +
                ", tblId=" + tblId +
                ", tbDesc='" + tbDesc + '\'' +
                ", tableType=" + tableType +
                ", columnList=" + columnList +
                '}';
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getTblId() {
        return tblId;
    }

    public void setTblId(int tblId) {
        this.tblId = tblId;
    }

    public String getTbDesc() {
        return tbDesc;
    }

    public void setTbDesc(String tbDesc) {
        this.tbDesc = tbDesc;
    }

    public Integer getTableType() {
        return tableType;
    }

    public void setTableType(Integer tableType) {
        this.tableType = tableType;
    }

    public List<Column> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<Column> columnList) {
        this.columnList = columnList;
    }
}
