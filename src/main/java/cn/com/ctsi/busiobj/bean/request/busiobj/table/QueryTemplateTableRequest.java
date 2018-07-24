package cn.com.ctsi.busiobj.bean.request.busiobj.table;

import cn.com.ctsi.busiobj.bean.request.common.BaseRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

public class QueryTemplateTableRequest extends BaseRequest implements Serializable {

    private static final long serialVersionUID = -3988895075058688236L;

    @NotNull(message = "The param [ent_id] is null.")
    @JsonProperty("ent_id")
    private Integer entid;

    @NotNull(message = "The param [table_ids] is null.")
    @JsonProperty("table_ids")
    private String tableIds;

    @Override
    public String toString() {
        return "QueryTemplateTableRequest{" +
                "entid=" + entid +
                ", tableIds='" + tableIds + '\'' +
                '}';
    }

    public Integer getEntid() {
        return entid;
    }

    public void setEntid(Integer entid) {
        this.entid = entid;
    }

    public String getTableIds() {
        return tableIds;
    }

    public void setTableIds(String tableIds) {
        this.tableIds = tableIds;
    }
}
