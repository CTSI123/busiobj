/*
 * Copyright (C) 2015 China Telecom System Integration Co., Ltd.
 * All rights reserved.
 */

package cn.com.ctsi.busiobj.bean.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * The type Page.
 */
public class Page implements Serializable {

    private static final long serialVersionUID = 7894489053642813159L;

    @JsonProperty("current_page")
    private Integer currentPage;
    @JsonProperty("page_size")
    private Integer pageSize;
    @JsonProperty("actual_size")
    private Integer actualSize;
    private long total;

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", actualSize=" + actualSize +
                ", total=" + total +
                '}';
    }

    /**
     * Gets current page.
     *
     * @return the current page
     */
    public Integer getCurrentPage() {
        return currentPage;
    }

    /**
     * Sets current page.
     *
     * @param currentPage the current page
     */
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
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

    /**
     * Gets actual size.
     *
     * @return the actual size
     */
    public Integer getActualSize() {
        return actualSize;
    }

    /**
     * Sets actual size.
     *
     * @param actualSize the actual size
     */
    public void setActualSize(Integer actualSize) {
        this.actualSize = actualSize;
    }

    /**
     * Gets total.
     *
     * @return the total
     */
    public long getTotal() {
        return total;
    }

    /**
     * Sets total.
     *
     * @param total the total
     */
    public void setTotal(long total) {
        this.total = total;
    }
}
