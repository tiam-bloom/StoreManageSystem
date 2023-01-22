package com.service;

import com.po.User;

public interface UserService {
    public User findUser(String username,String psw);
    public int addUser(User user);
}
