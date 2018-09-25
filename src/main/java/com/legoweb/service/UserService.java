package com.legoweb.service;

import com.legoweb.dao.UserMapper;
import com.legoweb.entity.Resp;
import com.legoweb.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    public Resp createUser(User user, Long userId) {
        Resp resp = new Resp();
        userMapper.insert(user);
        return resp;
    }

}
