/*
 * Copyright (C) 2015 China Telecom System Integration Co., Ltd.
 * All rights reserved.
 */

package cn.com.ctsi.busiobj.bean.response.cdm.data;

import java.io.Serializable;


public class CdmTemplateDataCreateRes extends DataRes implements Serializable {

    private static final long serialVersionUID = -6118241177089669028L;

    private DataContent content;

    @Override
    public String toString() {
        return "CdmTemplateDataCreateRes{" +
                "content=" + content +
                '}';
    }

    /**
     * Gets content.
     *
     * @return the content
     */
    public DataContent getContent() {
        return content;
    }

    /**
     * Sets content.
     *
     * @param content the content
     */
    public void setContent(DataContent content) {
        this.content = content;
    }
}
