package com.legoweb.dao;

import java.util.List;

import com.legoweb.entity.PageCondition;
import org.apache.ibatis.annotations.Param;
import com.legoweb.entity.TestCase;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestCaseMapper {


    int updateByPrimaryKey(TestCase record);


    int insertSelective(TestCase record);


    int deleteByPrimaryKey(Integer id);
    List<TestCase> selectList(PageCondition pageCondition);

    int selectCount(TestCase testCase);

    int insert(TestCase record);

    TestCase selectByPrimaryKey(Integer id);

    int uniqueCase(TestCase testCase);

    int updateByPrimaryKeySelective(TestCase record);

}
