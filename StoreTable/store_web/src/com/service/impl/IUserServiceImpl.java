package com.service.impl;

import com.bean.User;
import com.dao.IUserDao;
import com.dao.impl.IUserDaoImpl;
import com.service.IUserService;

public class IUserServiceImpl implements IUserService {
    private IUserDao dao = new IUserDaoImpl();
    @Override
    public User findUsername(User user) {
        return dao.findUsername(user);
    }
}
