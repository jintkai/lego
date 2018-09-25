package com.legoweb.dao;

import com.legoweb.entity.PageCondition;
import com.legoweb.entity.Params;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ParamsMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Params record);

    int insertSelective(Params record);


    Params selectByPrimaryKey(Integer id);

    List<Params> selectParams(PageCondition pageCondition);

    int updateByPrimaryKeySelective(Params record);

    int updateByPrimaryKey(Params record);
}