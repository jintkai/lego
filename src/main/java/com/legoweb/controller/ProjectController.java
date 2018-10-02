package com.legoweb.controller;

import com.legoweb.entity.Project;
import com.legoweb.entity.Resp;
import com.legoweb.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lego/project")

public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping(method = RequestMethod.POST)
    public Resp insertProject(@RequestBody Project project) {
        Resp resp ;
        project.setStatus(1);
        resp = projectService.createProject(project, 111L);
        return resp;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Resp selectProject(@PathVariable(required = true) String id) {
        Resp resp = new Resp();
        resp = projectService.selectByKey(id, 111);
        return resp;
    }

    @RequestMapping(value = "/{page}/{pageSize}", method = RequestMethod.POST)
    public Resp selectProjects(@PathVariable(required = true) Integer page,
                               @PathVariable(required = true) Integer pageSize,
                               @RequestBody Project project) {
        Resp resp = projectService.selectProjects(project, page, pageSize);
        return resp;
    }

    /**
     * 根据id或者名称模糊查询项目信息
     * @param key
     * @return
     */
    @RequestMapping(value="/vague/{key}",method=RequestMethod.GET)
    public Resp selectByIdOrName(@PathVariable(required = true) String key){
        Resp resp = projectService.selectByIdOrName(key);
        return resp;
    }

}
