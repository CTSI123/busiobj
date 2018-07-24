

package cn.com.ctsi.busiobj.bean.request.cdm.data;


import cn.com.ctsi.busiobj.bean.base.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;


public class CdmTemplateDataInsertReq extends DataReq implements Serializable {

    private static final long serialVersionUID = -6923804190880133613L;

    @Valid
    @NotNull(message = "The param [data] is null.")
    private List<Data> data;

    @Override
    public String toString() {
        return "CdmTemplateDataInsertReq{" +
                "data=" + data +
                '}';
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

}
