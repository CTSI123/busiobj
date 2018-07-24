package cn.com.ctsi.busiobj.bean.request.busiobj.data;



import cn.com.ctsi.busiobj.bean.base.UserRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public class QueryTemplateDataByIdRequest extends UserRequest implements Serializable{

    private static final long serialVersionUID = 4832705012256360645L;


    @NotNull(message = "The param [data_ids] is null.")
    @JsonProperty("data_ids")
    private List<String> dataIds;//数据的id列表

    @JsonProperty("table_id")
    @NotNull(message = "The param [table_id] is null.")
    private Integer tableId;//表id

    @JsonProperty("select_col_names")
    private List<String> selectColNames;//选择查询的列名

    @Override
    public String toString() {
        return "QueryTemplateDataByIdRequest{" +
                "dataIds=" + dataIds +
                ", tableId=" + tableId +
                ", selectColNames='" + selectColNames + '\'' +
                '}';
    }

    public List<String> getDataIds() {
        return dataIds;
    }

    public void setDataIds(List<String> dataIds) {
        this.dataIds = dataIds;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public List<String> getSelectColNames() {
        return selectColNames;
    }

    public void setSelectColNames(List<String> selectColNames) {
        this.selectColNames = selectColNames;
    }
}
