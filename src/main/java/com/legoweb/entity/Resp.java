package com.legoweb.entity;

import com.legoweb.enums.ErrorCode;

import java.io.Serializable;

public class Resp implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer code;
    private String msg;
    private Object data;

    public Resp() {
    }

    public Resp(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Resp SuccessResp() {
        return new Resp(200, null, null);
    }

    public static Resp SuccessResp(Object object) {
        return new Resp(200, null, object);
    }

    public static Resp ErrorResp(int code, String msg, Object data) {
        return new Resp(code, msg, data);
    }
}
