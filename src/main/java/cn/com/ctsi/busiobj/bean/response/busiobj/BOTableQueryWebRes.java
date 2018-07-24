package cn.com.ctsi.busiobj.bean.response.busiobj;


import cn.com.ctsi.busiobj.bean.base.TableLimitWeb;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BOTableQueryWebRes {

    @JsonProperty("tables")
    private List<TableLimitWeb> tableLimitWebList;

    @Override
    public String toString() {
        return "BOTableQueryWebRes{" +
                "tableLimitWebList=" + tableLimitWebList +
                '}';
    }

    public List<TableLimitWeb> getTableLimitWebList() {
        return tableLimitWebList;
    }

    public void setTableLimitWebList(List<TableLimitWeb> tableLimitWebList) {
        this.tableLimitWebList = tableLimitWebList;
    }
}
