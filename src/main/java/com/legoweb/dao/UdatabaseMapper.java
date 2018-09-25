package com.legoweb.dao;

import com.legoweb.entity.PageCondition;
import com.legoweb.entity.Udatabase;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UdatabaseMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Udatabase record);

    int insertSelective(Udatabase record);


    Udatabase selectByPrimaryKey(Integer id);
    List<Udatabase> selectList(PageCondition pageCondition);

    int updateByPrimaryKeySelective(Udatabase record);

    int updateByPrimaryKey(Udatabase record);
}