package cn.com.ctsi.busiobj.bean.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

public class MenuInfo {

    @NotNull(message = "The param [table_id] is null.")
    @JsonProperty("table_id")
    private Integer tableId;//自定义表id


    @NotNull(message = "The param [table_name] is null.")
    @JsonProperty("table_name")
    private String tableName;//自定义表英文name


    @NotNull(message = "The param [table_name_desc] is null.")
    @JsonProperty("table_name_desc")
    private String tableNameDesc;//自定义表英文描述

    @NotNull(message = "The param [children_menu] is null.")
    @JsonProperty("children_menu")
    private List<MenuInfo> childrenMenu;//子菜单对应的表信息

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableNameDesc() {
        return tableNameDesc;
    }

    public void setTableNameDesc(String tableNameDesc) {
        this.tableNameDesc = tableNameDesc;
    }

    public List<MenuInfo> getChildrenMenu() {
        return childrenMenu;
    }

    public void setChildrenMenu(List<MenuInfo> childrenMenu) {
        this.childrenMenu = childrenMenu;
    }
}
