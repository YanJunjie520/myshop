package com.shop.myshop.service.impl;

import com.shop.myshop.dao.UserDao;
import com.shop.myshop.dao.impl.UserDaoImpl;
import com.shop.myshop.entity.User;
import com.shop.myshop.service.UserService;
import com.shop.myshop.utils.EmailUtils;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    @Override
    public boolean checkedUser(String username) throws SQLException {

        //1、创建dao访问对象
        UserDao userDao = new UserDaoImpl();
        //2、执行结果
        User user = userDao.selectUserByUname(username);
        //3、处理返回值
        //user == null   false
        //user != null   true

        if(user != null) {
            return true;
        }
        return false;
    }

    @Override
    public int registerUser(User user) throws SQLException {

        //1、用户保存到数据库
        UserDao userDao = new UserDaoImpl();
        int row = userDao.insertUser(user);

        //2、发送一封邮件
        EmailUtils.sendEmail(user);
        return row;
    }

    @Override
    public int activateUser(String code) throws SQLException {

        UserDao userDao = new UserDaoImpl();
        //1、根据激活码查找用户
        User user = userDao.selectUserByUcode(code);

        if(user == null) {
            return 0;    //激活失败
        }
        //2、判断用户是否激活
        if(user.getUstatus() == 1) {
            return 2;   //已经激活
        }

        //3、若未激活，进行激活操作
        int i = userDao.updateUstatusByUid(user.getUid());
        if(i>0) {
            return 1;    //激活成功
        }
        return 0;
    }

    @Override
    public User login(String username, String password) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.selectUserByUname(username);
        if(user != null && user.getUpassword().equals(password)) {
            return user;
        }
        return null;
    }
}
