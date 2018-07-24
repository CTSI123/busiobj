/*
 * Copyright (C) 2015 China Telecom System Integration Co., Ltd.
 * All rights reserved.
 */

package cn.com.ctsi.busiobj.bean.request.cdm.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;


public class CdmTemplateDataDeleteReq extends DataReq implements Serializable {

    private static final long serialVersionUID = -2983695002365956154L;

    @NotNull(message = "The param [data_ids] is null.")
    @Size(min = 1)
    @JsonProperty("data_ids")
    private List<String> dataIds;

    @Override
    public String toString() {
        return "CdmTemplateDataDeleteReq{" +
                "dataIds=" + dataIds +
                '}';
    }

    public List<String> getDataIds() {
        return dataIds;
    }

    public void setDataIds(List<String> dataIds) {
        this.dataIds = dataIds;
    }
}
