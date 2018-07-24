/*
 * Copyright (C) 2015 China Telecom System Integration Co., Ltd.
 * All rights reserved.
 */

package cn.com.ctsi.busiobj.bean.request.cdm.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public class CdmTemplateDataQueryByIdReq extends DataReq implements Serializable {

    private static final long serialVersionUID = -2610173615508443487L;

    @NotNull(message = "The param [data_ids] is null.")
    @JsonProperty("data_ids")
    private List<String> dataIds;

    @NotNull(message = "The param [select_col_names] is null.")
    @JsonProperty("select_col_names")
    private List<String> selectColNames;

    @Override
    public String toString() {
        return "CdmTemplateDataQueryByIdReq{" +
                "dataIds=" + dataIds +
                ", selectColNames=" + selectColNames +
                '}';
    }

    public List<String> getDataIds() {
        return dataIds;
    }

    public void setDataIds(List<String> dataIds) {
        this.dataIds = dataIds;
    }

    public List<String> getSelectColNames() {
        return selectColNames;
    }

    public void setSelectColNames(List<String> selectColNames) {
        this.selectColNames = selectColNames;
    }
}
