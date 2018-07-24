package cn.com.ctsi.busiobj.bean.response.busiobj;

import cn.com.ctsi.busiobj.bean.base.User;

public class GetUserIdByMdnAndEntKeyRes {

    private User user;

    private String code;

    private String message;

    @Override
    public String toString() {
        return "GetUserIdByMdnAndEntKeyRes{" +
                "user=" + user +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
