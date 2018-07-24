package cn.com.ctsi.busiobj.bean.base;

/**
 * The type Get tree request.
 */
public class GetTreeRequest {
    //企业id
    private Integer entId;
    //用户名id
    private Integer userId;
    //部门id
    private Integer depId;
    //时间戳 by Qi
    private Long timestamp;
    //当前页 by Qi
    //@Range(min = 10, max = 150)
    private Integer currPage;
    //每页记录数 by Qi
    private Integer recNumPerPage;

    @Override
    public String toString() {
        return "GetTreeRequest{" +
                "entId=" + entId +
                ", userId=" + userId +
                ", depId=" + depId +
                ", timestamp=" + timestamp +
                ", currPage=" + currPage +
                ", recNumPerPage=" + recNumPerPage +
                '}';
    }

    /**
     * Gets dep id.
     *
     * @return the dep id
     */
    public Integer getDepId() {
        return depId;
    }

    /**
     * Sets dep id.
     *
     * @param depId the dep id
     */
    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    /**
     * Gets ent id.
     *
     * @return the ent id
     */
    public Integer getEntId() {
        return entId;
    }

    /**
     * Sets ent id.
     *
     * @param entId the ent id
     */
    public void setEntId(Integer entId) {
        this.entId = entId;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public Integer getRecNumPerPage() {
        return recNumPerPage;
    }

    public void setRecNumPerPage(Integer recNumPerPage) {
        this.recNumPerPage = recNumPerPage;
    }
}
