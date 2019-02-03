package com.legoweb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class CaseLog {
    @Getter @Setter
    private Integer id;
    @Getter @Setter
    private Integer caseId;
    @Getter @Setter
    private Integer jobId;
    @Getter @Setter
    private String responseId;
    @Getter @Setter
    private String assertId;
    @Getter @Setter
    private Integer assertResult;
    @Getter @Setter
    private Integer caseType;
    @Getter @Setter
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date creattime;
    @Getter @Setter
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updatetime;

}