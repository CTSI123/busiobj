/*
 * Copyright (C) 2015 China Telecom System Integration Co., Ltd.
 * All rights reserved.
 */

package cn.com.ctsi.busiobj.bean.response.cdm.data;

import cn.com.ctsi.busiobj.bean.base.Page;
import java.io.Serializable;
import java.util.List;
import java.util.Map;


public class CdmTemplateDataQueryListRes extends DataRes implements Serializable {

    private static final long serialVersionUID = -4739278534402137574L;
    private List<Map<String, Object>> content;
    private Page page;

    @Override
    public String toString() {
        return "CdmTemplateDataQueryListRes{" +
                "content=" + content +
                ", page=" + page +
                '}';
    }

    public List<Map<String, Object>> getContent() {
        return content;
    }


    public void setContent(List<Map<String, Object>> content) {
        this.content = content;
    }


    public Page getPage() {
        return page;
    }


    public void setPage(Page page) {
        this.page = page;
    }
}
