package cn.com.ctsi.busiobj.bean.base;

public class BaseResponse<T> extends BaseResponseNoBody{

    private T body;

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
