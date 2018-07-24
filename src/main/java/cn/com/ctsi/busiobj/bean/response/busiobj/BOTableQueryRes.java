package cn.com.ctsi.busiobj.bean.response.busiobj;

import cn.com.ctsi.busiobj.bean.base.Table;

import java.util.List;

public class BOTableQueryRes {

    private List<Table> tables;

    @Override
    public String toString() {
        return "BOTableQueryRes{" +
                "tables=" + tables +
                '}';
    }


    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }
}
