package com.wjx.mvprxjavaretrofitrxlifecycle.base;

/**
 * Author: WangJX
 * Time:2018/10/10 17:08
 * Descriprtion:
 */
public class BaseResponse<T> {
    private String msg;
    private int code;
    private T Data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }



    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", Data=" + Data +
                '}';
    }
}
