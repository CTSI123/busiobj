package cn.com.ctsi.busiobj.bean.request.busiobj.table;


import cn.com.ctsi.busiobj.bean.base.ContentUpdate;
import cn.com.ctsi.busiobj.bean.request.common.BaseRequest;
import cn.com.ctsi.busiobj.bean.request.common.UpdateColumn;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public class UpdateTemplateTableReuest extends BaseRequest implements Serializable{

    private static final long serialVersionUID = -4084223793336224779L;

    @NotNull(message = "The param [enterprise_id] is null.")
    @JsonProperty("enterprise_id")
    private Integer enterpriseId;


    /**
     * 1.update_table（修改表的描述信息）
     * 2.add _columns
     * 3.update _columns（修改列的设置）
     * 4.delete _columns
     * 5. 6. 7 操作暂时不支持
     */
    @NotNull(message = "The param [op] is null.")
    @Range(min = 1, max = 7, message = "The op must be between 1 and 7.")
    private Integer op;

//    @Valid
    @JsonProperty("content")
    private ContentUpdate contentUpdate;

//    @Valid
    @JsonProperty("columns")
    private List<UpdateColumn> columns;


    @Override
    public String toString() {
        return "UpdateTemplateTableReuest{" +
                "enterpriseId=" + enterpriseId +
                ", op=" + op +
                ", contentUpdate=" + contentUpdate +
                ", columns=" + columns +
                '}';
    }

    public Integer getOp() {
        return op;
    }

    public void setOp(Integer op) {
        this.op = op;
    }

    public ContentUpdate getContentUpdate() {
        return contentUpdate;
    }

    public void setContentUpdate(ContentUpdate contentUpdate) {
        this.contentUpdate = contentUpdate;
    }

    public List<UpdateColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<UpdateColumn> columns) {
        this.columns = columns;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }
}
