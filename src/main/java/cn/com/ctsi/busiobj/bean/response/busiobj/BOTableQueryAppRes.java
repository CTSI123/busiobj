package cn.com.ctsi.busiobj.bean.response.busiobj;

import cn.com.ctsi.busiobj.bean.base.TableLimitApp;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BOTableQueryAppRes {

    @JsonProperty("tables")
    private List<TableLimitApp> tableLimitAppList;

    @Override
    public String toString() {
        return "BOTableQueryAppRes{" +
                "tableLimitAppList=" + tableLimitAppList +
                '}';
    }

    public List<TableLimitApp> getTableLimitAppList() {
        return tableLimitAppList;
    }

    public void setTableLimitAppList(List<TableLimitApp> tableLimitAppList) {
        this.tableLimitAppList = tableLimitAppList;
    }
}
