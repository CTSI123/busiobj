package cn.com.ctsi.busiobj.bean.response.cdm.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * The type Data content.
 */
public class DataContent implements Serializable {

    private static final long serialVersionUID = 3246144104597749110L;

    @JsonProperty("data_id")
    private Integer dataId;

    @Override
    public String toString() {
        return "DataContent{" +
                "dataId=" + dataId +
                '}';
    }

    /**
     * Gets data id.
     *
     * @return the data id
     */
    public Integer getDataId() {
        return dataId;
    }

    /**
     * Sets data id.
     *
     * @param dataId the data id
     */
    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }
}
