package com.legoweb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

public class TestCase implements Serializable {

    @Getter @Setter
    private Integer paramsType;
    @Getter @Setter
    private String caseParams;
    @Getter @Setter
    private String caseDescription;
    @Getter @Setter
    private static final long serialVersionUID = 1L;
    @Getter @Setter
    private Integer id;
    @Getter @Setter
    private String caseUrl;
    @Getter @Setter
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Getter @Setter
    private Date updateTime;
    @Getter @Setter
    private Integer serviceId;
    @Getter @Setter
    private String caseName;
    @Getter @Setter
    private Integer methodType;
    @Getter @Setter
    private String creator;
    @Getter @Setter
    private String projectId;
    @Getter @Setter
    private Integer caseStatus;

}
