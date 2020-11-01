package com.whgc.service.impl;

import com.whgc.bean.User;
import com.whgc.mapper.UserMapper;
import com.whgc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl  implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String username, String password) {
        return userMapper.getUser(username,password);
    }
}
