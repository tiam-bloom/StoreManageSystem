package com.dao.impl;

import com.bean.User;
import com.dao.IUserDao;
import com.jdbc.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import java.sql.SQLException;

public class IUserDaoImpl implements IUserDao {
    @Override
    public User findUsername(User user) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDs());
        try {
            String sql = "select * from s_user where username =? and psw =?";
            return qr.query(sql,new BeanHandler<User>(User.class),user.getUsername(),user.getPsw() );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
