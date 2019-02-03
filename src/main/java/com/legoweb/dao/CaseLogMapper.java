package com.legoweb.dao;

import com.legoweb.entity.CaseLog;

import java.util.List;

import com.legoweb.entity.PageCondition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CaseLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CaseLog record);

    int insertSelective(CaseLog record);

    CaseLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CaseLog record);

    int updateByPrimaryKey(CaseLog record);

    List<CaseLog> selectList(PageCondition pageCondition);

    int selectCount(CaseLog record);
}