package cn.com.ctsi.busiobj.bean.request.busiobj.data;




import cn.com.ctsi.busiobj.bean.base.UserRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

public class QueryTemplateDataListRequest extends UserRequest {


    @JsonProperty("table_id")
    @NotNull(message = "The param [table_id] is null.")
    private Integer tableId;

    @Min(value = 0, message = "The param [page] should be more than 0.")
    private Integer page;//查询的页数

    @Min(value = 1, message = "The param [page_size] should be more than 1.")
    @JsonProperty("page_size")
    private Integer pageSize;//每页的条数

    private List<String> select;//查询语句中的select部分

    private Map<String,Object> where;//查询语句中的where部分

    private Map<String,Object> order;//查询语句中的order部分


    @Override
    public String toString() {
        return "QueryTemplateDataListRequest{" +
                "tableId=" + tableId +
                ", page=" + page +
                ", pageSize=" + pageSize +
                ", select=" + select +
                ", where=" + where +
                ", order=" + order +
                '}';
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


    public List<String> getSelect() {
        return select;
    }

    public void setSelect(List<String> select) {
        this.select = select;
    }

    public Map<String, Object> getWhere() {
        return where;
    }

    public void setWhere(Map<String, Object> where) {
        this.where = where;
    }

    public Map<String, Object> getOrder() {
        return order;
    }

    public void setOrder(Map<String, Object> order) {
        this.order = order;
    }
}
