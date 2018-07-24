package cn.com.ctsi.busiobj.bean.request.busiobj.table;


import cn.com.ctsi.busiobj.bean.request.common.BaseRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class DeleteTemplateTableRequest extends BaseRequest implements Serializable{

    private static final long serialVersionUID = 2475912394647493674L;

    @NotNull(message = "The param [enterprise_id] is null.")
    @JsonProperty("enterprise_id")
    private Integer enterpriseId;


    @NotNull(message = "The param [table_id] is null.")
    @JsonProperty("table_id")
    private Integer tableId;

    @Override
    public String toString() {
        return "DeleteTemplateTableRequest{" +
                "enterpriseId=" + enterpriseId +
                ", tableId=" + tableId +
                '}';
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }


    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }
}
