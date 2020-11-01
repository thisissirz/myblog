package com.whgc.mapper;

import com.whgc.bean.User;

public interface UserMapper {

    public User getUser(String username, String password);
}
