package cn.com.ctsi.busiobj.bean.request.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


public class Domain implements Serializable {

    private static final long serialVersionUID = -2465029689161319050L;

    @NotNull(message = "The param [domain_id] is null.")
    @JsonProperty("domain_id")
    private Integer domainId;

    //    @NotNull(message = "The param [op_limit] is null.")
    @Range(min = 1, max = 2, message = "The param [op_limit] must be between 1 and 2.")
    @JsonProperty("op_limit")
    private Integer opLimit;

    @Override
    public String toString() {
        return "Domain{" +
                "domainId=" + domainId +
                ", opLimit=" + opLimit +
                '}';
    }

    /**
     * Gets domain id.
     *
     * @return the domain id
     */
    public Integer getDomainId() {
        return domainId;
    }

    /**
     * Sets domain id.
     *
     * @param domainId the domain id
     */
    public void setDomainId(Integer domainId) {
        this.domainId = domainId;
    }

    /**
     * Gets op limit.
     *
     * @return the op limit
     */
    public Integer getOpLimit() {
        return opLimit;
    }

    /**
     * Sets op limit.
     *
     * @param opLimit the op limit
     */
    public void setOpLimit(Integer opLimit) {
        this.opLimit = opLimit;
    }
}
