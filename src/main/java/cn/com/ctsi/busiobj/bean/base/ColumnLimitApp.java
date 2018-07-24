package cn.com.ctsi.busiobj.bean.base;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ColumnLimitApp extends ColumnLimitCommon {

    @JsonProperty("add_mob_style")
    private String addMobStyle;

    @JsonProperty("edit_mob_style")
    private String editMobStyle;

    @JsonProperty("list_mob_style")
    private String listMobStyle;

    @JsonProperty("view_mob_style")
    private String viewMobStyle;

    @Override
    public String toString() {
        return "ColumnLimitApp{" +
                "addMobStyle='" + addMobStyle + '\'' +
                ", editMobStyle='" + editMobStyle + '\'' +
                ", listMobStyle='" + listMobStyle + '\'' +
                ", viewMobStyle='" + viewMobStyle + '\'' +
                '}';
    }

    public String getAddMobStyle() {
        return addMobStyle;
    }

    public void setAddMobStyle(String addMobStyle) {
        this.addMobStyle = addMobStyle;
    }

    public String getEditMobStyle() {
        return editMobStyle;
    }

    public void setEditMobStyle(String editMobStyle) {
        this.editMobStyle = editMobStyle;
    }

    public String getListMobStyle() {
        return listMobStyle;
    }

    public void setListMobStyle(String listMobStyle) {
        this.listMobStyle = listMobStyle;
    }

    public String getViewMobStyle() {
        return viewMobStyle;
    }

    public void setViewMobStyle(String viewMobStyle) {
        this.viewMobStyle = viewMobStyle;
    }
}
