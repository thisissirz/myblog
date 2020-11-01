package com.whgc.service;

import com.whgc.bean.User;

public interface UserService {

    public User getUser(String username, String password);
}
