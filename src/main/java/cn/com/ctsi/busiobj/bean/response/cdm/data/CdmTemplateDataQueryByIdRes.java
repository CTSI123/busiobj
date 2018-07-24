/*
 * Copyright (C) 2015 China Telecom System Integration Co., Ltd.
 * All rights reserved.
 */

package cn.com.ctsi.busiobj.bean.response.cdm.data;


import java.io.Serializable;
import java.util.List;
import java.util.Map;


public class CdmTemplateDataQueryByIdRes extends DataRes implements Serializable {


    private static final long serialVersionUID = -6458144101509272916L;

    private List<Map<String, Object>> content;

    @Override
    public String toString() {
        return "CdmTemplateDataQueryByIdRes{" +
                "content=" + content +
                '}';
    }

    public List<Map<String, Object>> getContent() {
        return content;
    }

    public void setContent(List<Map<String, Object>> content) {
        this.content = content;
    }
}
