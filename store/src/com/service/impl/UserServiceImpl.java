package com.service.impl;

import com.dao.UserDao;
import com.po.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User findUser(String username, String psw) {
        return this.userDao.findUser(username,psw);
    }

    @Override
    public int addUser(User user) {
        return this.userDao.addUser(user);
    }
}
