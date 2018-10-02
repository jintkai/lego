package com.legoweb.service;

import com.legoweb.dao.ProjectMapper;
import com.legoweb.entity.PageCondition;
import com.legoweb.entity.Project;
import com.legoweb.entity.Resp;
import com.legoweb.enums.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.legoweb.utils.Utils;
@Service
public class ProjectService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProjectMapper projectMapper;

    public Resp createProject(Project project, Long userId) {
        Resp resp ;
        project.setId(Utils.getUUID32());
        Integer isUnique = projectMapper.uniqueProject(project);
        if(isUnique !=0){
            resp = Resp.ErrorResp(500,"项目名称不唯一！",null);
            return resp;
        }
        projectMapper.insert(project);
        resp = Resp.SuccessResp();
        return resp;
    }

    public Resp selectByKey(String id, Integer userId) {
        Resp resp = new Resp();
        Project project = projectMapper.selectByPrimaryKey(id);
        resp = Resp.SuccessResp(project);
        return resp;
    }

    public Resp selectProjects(Project project,Integer page,Integer pageSize){
        Resp resp ;
        PageCondition<Project> pageCondition = new PageCondition<>();
        pageCondition.setPage(page);
        pageCondition.setPageSize(pageSize);
        pageCondition.setTotal(projectMapper.selectCounts(pageCondition));
        pageCondition.setList(projectMapper.selectProjects(pageCondition));
        resp = Resp.SuccessResp(pageCondition);
        return resp;
    }

    public Resp selectByIdOrName(String key){
        Resp resp;
        resp = Resp.SuccessResp(projectMapper.selectByNameOrId(key));
        return resp;
    }

}
