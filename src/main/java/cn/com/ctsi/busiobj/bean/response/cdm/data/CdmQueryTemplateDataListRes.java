/*
 * Copyright (C) 2015 China Telecom System Integration Co., Ltd.
 * All rights reserved.
 */

package cn.com.ctsi.busiobj.bean.response.cdm.data;


import cn.com.ctsi.busiobj.bean.base.Page;
import cn.com.ctsi.busiobj.bean.response.cdm.data.DataRes;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public class CdmQueryTemplateDataListRes extends DataRes implements Serializable {

    private static final long serialVersionUID = -8963747721536028493L;


    private List<Map<String, Object>> content;

    private Page page;


    public List<Map<String, Object>> getContent() {
        return content;
    }


    public void setContent(List<Map<String, Object>> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CdmQueryTemplateDataListRes{" +
                "content=" + content +
                ", page=" + page +
                '}';
    }

    public Page getPage() {
        return page;
    }


    public void setPage(Page page) {
        this.page = page;
    }
}
