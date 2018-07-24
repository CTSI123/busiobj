package cn.com.ctsi.busiobj.bean.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TableLimitApp {

    @JsonProperty("content")
    private ContentLimit contentLimit;

    @JsonProperty("columns")
    private List<ColumnLimitApp> columnLimitApps;

    @Override
    public String toString() {
        return "TableLimitApp{" +
                "contentLimit=" + contentLimit +
                ", columnLimitApps=" + columnLimitApps +
                '}';
    }

    public ContentLimit getContentLimit() {
        return contentLimit;
    }

    public void setContentLimit(ContentLimit contentLimit) {
        this.contentLimit = contentLimit;
    }

    public List<ColumnLimitApp> getColumnLimitApps() {
        return columnLimitApps;
    }

    public void setColumnLimitApps(List<ColumnLimitApp> columnLimitApps) {
        this.columnLimitApps = columnLimitApps;
    }
}
