package cn.com.ctsi.busiobj.bean.base;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ColumnLimitWeb extends ColumnLimitCommon {

    @JsonProperty("add_pc_style")
    private String addPcStyle;

    @JsonProperty("edit_pc_style")
    private String editPcStyle;

    @JsonProperty("list_pc_style")
    private String listPcStyle;

    @JsonProperty("view_pc_style")
    private String viewPcStyle;

    @Override
    public String toString() {
        return "ColumnLimitWeb{" +
                "addPcStyle='" + addPcStyle + '\'' +
                ", editPcStyle='" + editPcStyle + '\'' +
                ", listPcStyle='" + listPcStyle + '\'' +
                ", viewPcStyle='" + viewPcStyle + '\'' +
                '}';
    }

    public String getAddPcStyle() {
        return addPcStyle;
    }

    public void setAddPcStyle(String addPcStyle) {
        this.addPcStyle = addPcStyle;
    }

    public String getEditPcStyle() {
        return editPcStyle;
    }

    public void setEditPcStyle(String editPcStyle) {
        this.editPcStyle = editPcStyle;
    }

    public String getListPcStyle() {
        return listPcStyle;
    }

    public void setListPcStyle(String listPcStyle) {
        this.listPcStyle = listPcStyle;
    }

    public String getViewPcStyle() {
        return viewPcStyle;
    }

    public void setViewPcStyle(String viewPcStyle) {
        this.viewPcStyle = viewPcStyle;
    }
}
