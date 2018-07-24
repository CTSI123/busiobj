package cn.com.ctsi.busiobj.bean.request.cdm.data;


import cn.com.ctsi.busiobj.bean.base.Data;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;


public class CdmTemplateDataUpdateReq extends DataReq implements Serializable {

    private static final long serialVersionUID = 7537388728796561835L;

    @NotNull(message = "The param [data_id] is null.")
    @JsonProperty("data_id")
    private Integer dataId;

    @Valid
    @NotNull(message = "The param [data] is null.")
    private List<Data> data;


    @Override
    public String toString() {
        return "CdmTemplateDataUpdateReq{" +
                "dataId=" + dataId +
                ", data=" + data +
                '}';
    }

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
