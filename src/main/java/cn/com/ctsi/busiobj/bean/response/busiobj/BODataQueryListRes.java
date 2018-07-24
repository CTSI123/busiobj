package cn.com.ctsi.busiobj.bean.response.busiobj;

import cn.com.ctsi.busiobj.bean.base.Page;

import java.util.List;
import java.util.Map;

public class BODataQueryListRes {
    private List<Map<String, Object>> content;
    private Page page;

    @Override
    public String toString() {
        return "BODataQueryListRes{" +
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
