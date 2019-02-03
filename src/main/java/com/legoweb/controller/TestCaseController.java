package com.legoweb.controller;

import com.legoweb.entity.Resp;
import com.legoweb.entity.TestCase;
import com.legoweb.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lego/testcase")
public class TestCaseController {
    @Autowired
    public TestCaseService testCaseService;

    @RequestMapping(value = "/{page}/{pageSize}", method = RequestMethod.POST)
    public Resp selectList(@PathVariable(required = true) Integer page,
                           @PathVariable(required = true) Integer pageSize,
                           @RequestBody TestCase testCase) {
        Resp resp = testCaseService.selectLists(testCase, page, pageSize);
        return resp;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Resp insertCase(@RequestBody TestCase testCase) {
        Resp resp = new Resp();
        resp = testCaseService.insertCase(testCase);
        return resp;
    }

    @RequestMapping(method = RequestMethod.POST, value = "run/{id}")
    public Resp runCase(@PathVariable(required = true) Integer id) {
        Resp resp;
        resp = testCaseService.runCase(id);
        return resp;
    }

}
