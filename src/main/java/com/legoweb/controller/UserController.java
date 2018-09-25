package com.legoweb.controller;

import com.legoweb.entity.Resp;
import com.legoweb.entity.User;
import com.legoweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lego/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping( method = RequestMethod.POST)
    public Resp insertUser(@RequestBody User user) {
        Resp resp = userService.createUser(user, 111L);
        return resp;
    }

}
