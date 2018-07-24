package cn.com.ctsi.busiobj.bean.request.busiobj.data;


import cn.com.ctsi.busiobj.bean.base.UserRequest;
import cn.com.ctsi.busiobj.util.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CreateTemplateDataRequest extends UserRequest {

    @NotNull(message = "The param [table_id] is null.")
    @JsonProperty("table_id")
    private Integer tableId;//自定义表id

    @NotNull(message = "The param [row_list] is null.")
    @JsonProperty("row_list")
    private List<Map<String,Object>> rowList;//要添加的每一行的数据

    @Override
    public String toString() {
        return "CreateTemplateDataRequest{" +
                "tableId=" + tableId +
                ", rowList=" + showList(rowList) +
                '}';
    }


    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public List<Map<String, Object>> getRowList() {
        return rowList;
    }

    public void setRowList(List<Map<String, Object>> rowList) {
        this.rowList = rowList;
    }

    public String showList(List<Map<String, Object>> rowList){
        StringBuilder sb=new StringBuilder();
        for(Map<String,Object> row:rowList){
            sb.append("[");
            Set<String> keySet=row.keySet();
            if(BaseBean.isNotEmpty(keySet)){
                for(String colName:keySet){
                    sb.append(colName).append(":").append(row.get(colName));
                }

            }
            sb.append("],");
        }
        return sb.toString();
    }
}
