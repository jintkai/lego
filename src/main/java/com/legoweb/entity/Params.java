package com.legoweb.entity;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

public class Params implements Serializable {
    @Getter @Setter
    private Integer id;
    @Getter @Setter
    private String paramsName;
    @Getter @Setter
    private String projectId;
    @Getter @Setter
    private String projectName;
    @Getter @Setter
    private String description;
    @Getter @Setter
    private Integer type;
    @Getter @Setter
    private String paramsExpression;

    @Getter @Setter
    private Integer databaseId;
    @Getter @Setter
    private String databaseName;
    @Getter @Setter
    private Date createTime;
    @Getter @Setter
    private Date updateTime;

    private static final long serialVersionUID = 1L;


}