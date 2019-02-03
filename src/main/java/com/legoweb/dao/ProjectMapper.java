package com.legoweb.dao;

import com.legoweb.entity.PageCondition;
import com.legoweb.entity.Project;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface ProjectMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Project record);

    int insertSelective(Project record);

    int uniqueProject(Project record);

    Project selectByPrimaryKey(String id);

    List<Project> selectByNameOrId(@Param("id") String key);

    List<Project> selectProjects(PageCondition pageCondition);
    int selectCounts(PageCondition pageCondition);
    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
}