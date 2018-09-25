package com.legoweb.controller;

import com.legoweb.entity.Params;
import com.legoweb.entity.Resp;
import com.legoweb.service.ParamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lego/params")
public class ParamsController {

    @Autowired
    private ParamsService paramsService;

    @RequestMapping(method=RequestMethod.POST)
    public Resp insertParams(@RequestBody Params params){
        return paramsService.insertParams(params);
    }
    @RequestMapping(value = "/{page}/{pageSize}", method = RequestMethod.POST)
    public Resp selectLists(@PathVariable(required = true) Integer page, @PathVariable(required = true) Integer pageSize,
                            @RequestBody Params params) {
        return paramsService.selectParams(params, page, pageSize);
    }
}
