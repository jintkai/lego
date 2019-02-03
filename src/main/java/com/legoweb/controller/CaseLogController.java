package com.legoweb.controller;

import com.legoweb.entity.CaseLog;
import com.legoweb.entity.Resp;
import com.legoweb.service.CaseLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lego/caselog")
public class CaseLogController {

    @Autowired
    private CaseLogService caseLogService;

    @RequestMapping(value = "/{page}/{pageSize}", method = RequestMethod.POST)
    public Resp selectList(@PathVariable(required = true) Integer page,
                           @PathVariable(required = true) Integer pageSize,
                           @RequestBody CaseLog caseLog) {
        return caseLogService.selectLogs(caseLog, page, pageSize);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Resp selectLog(@PathVariable(required = true) Integer id) {
        return caseLogService.selectResponseLog(id);
    }
}
