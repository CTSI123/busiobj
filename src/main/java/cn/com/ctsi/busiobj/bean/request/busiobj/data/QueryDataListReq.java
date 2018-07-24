package cn.com.ctsi.busiobj.bean.request.busiobj.data;

import cn.com.ctsi.busiobj.bean.base.Filter;
import cn.com.ctsi.busiobj.bean.request.cdm.data.DataReq;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class QueryDataListReq extends DataReq {


    @Valid
    @NotNull(message = "The param [filter] is null.")
    private Filter filter;

    @Min(value = 0, message = "The param [page] should be more than 0.")
    private Integer page;

    @Min(value = 1, message = "The param [page_size] should be more than 1.")
    @JsonProperty("page_size")
    private Integer pageSize;

    /**
     * Gets filter.
     *
     * @return the filter
     */
    public Filter getFilter() {
        return filter;
    }

    /**
     * Sets filter.
     *
     * @param filter the filter
     */
    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    /**
     * Gets page.
     *
     * @return the page
     */
    public Integer getPage() {
        return page;
    }

    /**
     * Sets page.
     *
     * @param page the page
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * Gets page size.
     *
     * @return the page size
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * Sets page size.
     *
     * @param pageSize the page size
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


    @Override
    public String toString() {
        return "QueryDataListReq{" +
                "filter=" + filter +
                ", page=" + page +
                ", pageSize=" + pageSize +
                '}';
    }
}
