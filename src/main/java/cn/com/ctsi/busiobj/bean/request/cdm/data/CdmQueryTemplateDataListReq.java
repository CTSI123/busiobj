/*
 * Copyright (C) 2015 China Telecom System Integration Co., Ltd.
 * All rights reserved.
 */

package cn.com.ctsi.busiobj.bean.request.cdm.data;


import cn.com.ctsi.busiobj.bean.request.busiobj.data.QueryDataListReq;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;


public class CdmQueryTemplateDataListReq extends QueryDataListReq implements Serializable {

    private static final long serialVersionUID = 3915535186177536447L;

    @Valid
    @JsonProperty("add_users")
    private List<String> addUsers;
    @JsonProperty("poi_data_id")
    private Integer poiDataId;
    @JsonProperty("start_time")
    private String startTime;
    @JsonProperty("end_time")
    private String endTime;


    @Min(value = 0, message = "The param [page] should be more than 0.")
    private Integer page;
    @Min(value = 1, message = "The param [page_size] should be more than 1.")
    @JsonProperty("page_size")
    private Integer pageSize;


    @JsonProperty("select_col_names")
    @NotNull(message = "The param [select_col_names] is null.")
    private List<String> selectColNames;

    @Override
    public String toString() {
        return "CdmQueryTemplateDataListReq{" +
                "addUsers=" + addUsers +
                ", poiDataId=" + poiDataId +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", page=" + page +
                ", pageSize=" + pageSize +
                ", selectColNames=" + selectColNames +
                ",filter=" + getFilter().toString() +
                ", page=" + page +
                ", pageSize=" + pageSize +


                '}';
    }

    public List<String> getAddUsers() {
        return addUsers;
    }

    public void setAddUsers(List<String> addUsers) {
        this.addUsers = addUsers;
    }

    public Integer getPoiDataId() {
        return poiDataId;
    }

    public void setPoiDataId(Integer poiDataId) {
        this.poiDataId = poiDataId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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

    public List<String> getSelectColNames() {
        return selectColNames;
    }

    public void setSelectColNames(List<String> selectColNames) {
        this.selectColNames = selectColNames;
    }
}
