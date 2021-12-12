package com.shop.myshop.service;

import com.shop.myshop.entity.User;

import java.sql.SQLException;

public interface UserService {

    /**
     * 检测用户名是否存在
     * @param username 被检测的用户名
     * @return boolean   true存在   false不存在
     */
    boolean checkedUser(String username) throws SQLException;

    /**
     * 注册的业务逻辑
     * @param user
     * @return 插入数据影响的行数
     */
    int registerUser(User user) throws SQLException;

    /**
     * 激活方法
     * @param code  根据激活码进行激活
     * @return 三个状态  0激活失败   1激活成功    2已经激活
     */
    int activateUser(String code) throws SQLException;

    User login(String username, String password) throws SQLException;
}
