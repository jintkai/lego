package com.legoweb.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

public class Udatabase implements Serializable {
    @Getter @Setter
    private Integer id;
    @Getter @Setter
    private String dbName;
    @Getter @Setter
    private String dbType;
    @Getter @Setter
    private String dbUrl;
    @Getter @Setter
    private String dbUser;
    @Getter @Setter
    private String dbPassword;
    @Getter @Setter
    private String dbDescription;
    @Getter @Setter
    private String projectId;
    @Getter @Setter
    private String projectName;
    @Getter @Setter
    private Date createTime;
    @Getter @Setter
    private Date updateTime;
    @Getter @Setter
    private static final long serialVersionUID = 1L;


}