package cn.com.ctsi.busiobj.bean.response.busiobj;

import java.util.List;
import java.util.Map;

public class BODataQueryByIdRes {

    private List<Map<String, Object>> content;

    @Override
    public String toString() {
        return "BODataQueryByIdRes{" +
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
