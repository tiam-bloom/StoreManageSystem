package com.dao;

import com.po.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    public User findUser(@Param("username") String username,
                         @Param("psw") String psw);
    public int addUser(User user);
}
