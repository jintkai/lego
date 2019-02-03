package com.legoapi.entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.Date;

public final class HttpLog {

    @Setter @Getter
    private ObjectId id;
    @Setter @Getter
    private Integer code;
    @Setter @Getter
    private String msg;
    @Setter @Getter
    private Long spendTime;

    @Setter @Getter
    private String requestUrl;
    @Setter @Getter
    private Object requestParams;
    @Setter @Getter
    private Object requestHeaders;
    @Setter @Getter
    private Integer methodType;
    @Setter @Getter
    private Integer paramsType;

    @Setter @Getter
    private int statusCode;
    @Setter @Getter
    private Object responseHeaders;
    @Setter @Getter
    private Object responseBody;
    @Setter @Getter
    private Date creatTime;

    public HttpLog() {
    }

    public HttpLog(String id, Integer code, String msg, Long spendTime, String requestUrl, Object requestParams, Object requestHeaders, int methodType, Integer paramsType, int statusCode, Object responseHeaders, Object responseBody, Date creatTime) {
       // this.id = id;
        this.id = new ObjectId();
        this.code = code;
        this.msg = msg;
        this.spendTime = spendTime;
        this.requestUrl = requestUrl;
        this.requestParams = requestParams;
        this.requestHeaders = requestHeaders;
        this.methodType = methodType;
        this.paramsType = paramsType;
        this.statusCode = statusCode;
        this.responseHeaders = responseHeaders;
        this.responseBody = responseBody;
        this.creatTime = creatTime;
    }
}
