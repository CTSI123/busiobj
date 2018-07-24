package cn.com.ctsi.busiobj.bean.request.busiobj.data;


import cn.com.ctsi.busiobj.bean.base.UserRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

public class UpdateTemplateDataRequest extends UserRequest {

    @NotNull(message = "The param [data_id] is null.")
    @JsonProperty("data_id")
    private Integer dataId;//修改的数据ID


    @NotNull(message = "The param [table_id] is null.")
    @JsonProperty("table_id")
    private Integer tableId;//更新的表的id


    @NotNull(message = "The param [data] is null.")
    private Map<String,Object> data;//更新的列名及该列希望修改为的值

    @Override
    public String toString() {
        return "UpdateTemplateDataRequest{" +
                "dataId=" + dataId +
                ", data=" + data +
                ", tableId=" + tableId +
                '}';
    }

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

}
