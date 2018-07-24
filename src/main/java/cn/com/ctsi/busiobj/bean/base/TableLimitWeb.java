package cn.com.ctsi.busiobj.bean.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TableLimitWeb {

    @JsonProperty("content")
    private ContentLimit contentLimit;

    @JsonProperty("columns")
    private List<ColumnLimitWeb> columnLimitWebs;

    @Override
    public String toString() {
        return "TableLimitWeb{" +
                "contentLimit=" + contentLimit +
                ", columnLimitWebs=" + columnLimitWebs +
                '}';
    }

    public ContentLimit getContentLimit() {
        return contentLimit;
    }

    public void setContentLimit(ContentLimit contentLimit) {
        this.contentLimit = contentLimit;
    }

    public List<ColumnLimitWeb> getColumnLimitWebs() {
        return columnLimitWebs;
    }

    public void setColumnLimitWebs(List<ColumnLimitWeb> columnLimitWebs) {
        this.columnLimitWebs = columnLimitWebs;
    }
}
