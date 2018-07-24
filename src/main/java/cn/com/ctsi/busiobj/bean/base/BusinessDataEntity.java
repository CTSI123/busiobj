package cn.com.ctsi.busiobj.bean.base;

import java.io.Serializable;
import java.util.Date;

public class BusinessDataEntity implements Serializable{
    private static final long serialVersionUID = 6741143352939226320L;

    private Integer id;
    private Integer entId; //企业Id
    private String name;//名称
    private String description;//描述
    private Date createTime;//创建时间
    private Date lastEditTime;//最后修改时间
    private Integer tableId;//实体表id

    @Override
    public String toString() {
        return "BusinessDataEntity{" +
                "id=" + id +
                ", entId=" + entId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", lastEditTime=" + lastEditTime +
                ", tableId=" + tableId +
                '}';
    }

    public Integer getEntId() {
        return entId;
    }

    public void setEntId(Integer entId) {
        this.entId = entId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
