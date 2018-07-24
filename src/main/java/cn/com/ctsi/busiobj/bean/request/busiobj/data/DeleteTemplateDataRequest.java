package cn.com.ctsi.busiobj.bean.request.busiobj.data;


import cn.com.ctsi.busiobj.bean.base.UserRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class DeleteTemplateDataRequest extends UserRequest {

    @NotNull(message = "The param [table_id] is null.")
    @JsonProperty("table_id")
    private Integer tableId;//自定义表id


    @NotNull(message = "The param [data_ids] is null.")
    @Size(min = 1)
    @JsonProperty("data_ids")
    private List<String> dataIds;//待删除数据的id列表

    @Override
    public String toString() {
        return "DeleteTemplateDataRequest{" +
                "tableId=" + tableId +
                ", dataIds=" + dataIds +
                '}';
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public List<String> getDataIds() {
        return dataIds;
    }

    public void setDataIds(List<String> dataIds) {
        this.dataIds = dataIds;
    }
}