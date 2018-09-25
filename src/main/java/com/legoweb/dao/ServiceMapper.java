package com.legoweb.dao;

import com.legoweb.entity.Service;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface ServiceMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Service record);

    int insertSelective(Service record);


    Service selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Service record);

    int updateByPrimaryKey(Service record);
}