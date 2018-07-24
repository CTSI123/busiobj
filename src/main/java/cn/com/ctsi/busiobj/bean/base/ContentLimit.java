package cn.com.ctsi.busiobj.bean.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ContentLimit implements Serializable {



    @NotNull(message = "The param [table_name] is null.")
    @NotBlank(message = "The param [table_name] is blank.")
    @JsonProperty("table_name")
    private String tableName;


    @JsonProperty("table_name_desc")
    private String tableNameDesc;

    @Override
    public String toString() {
        return "ContentLimit{" +
                "tableName='" + tableName + '\'' +
                ", tableNameDesc='" + tableNameDesc + '\'' +
                '}';
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
}
