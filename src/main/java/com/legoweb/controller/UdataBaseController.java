package com.legoweb.controller;

import com.legoweb.entity.Project;
import com.legoweb.entity.Resp;
import com.legoweb.entity.Udatabase;
import com.legoweb.service.UdataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lego/database")
public class UdataBaseController {

    @Autowired
    UdataBaseService service;

    @RequestMapping(method = RequestMethod.POST)
    public Resp insertProject(@RequestBody Udatabase udatabase) {
        Resp resp;
        resp = service.insertDatabase(udatabase);
        return resp;
    }

    @RequestMapping(value = "/{page}/{pageSize}", method = RequestMethod.POST)
    public Resp selectDatabases(@PathVariable(required = true) Integer page,
                                @PathVariable(required = true) Integer pageSize,
                                @RequestBody Udatabase udatabase) {
        Resp resp = service.selectDatabases(udatabase, page, pageSize);
        return resp;
    }

}
