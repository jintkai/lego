package com.legoweb.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

public class Project implements Serializable {


    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Getter @Setter
    private String projectName;
    @Getter @Setter
    private Integer status;
    @Getter @Setter
    private String description;
    @Getter @Setter
    private Date createTime;
    @Getter @Setter
    private Date updateTime;
    @Getter @Setter
    private static final long serialVersionUID = 1L;
}