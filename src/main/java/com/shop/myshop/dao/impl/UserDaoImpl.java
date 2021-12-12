package com.shop.myshop.dao.impl;

import com.shop.myshop.dao.UserDao;
import com.shop.myshop.entity.User;
import com.shop.myshop.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库访问实现类
 */
public class UserDaoImpl implements UserDao {

    @Override
    public User selectUserByUname(String username) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        String sql = "select * from user where u_name = '" + username + "';";
        rs = st.executeQuery(sql);
        User user = new User();
        if(rs.next()) {
            user.setUid(rs.getInt("u_id"));
            user.setUname(rs.getString("u_name"));
            user.setUpassword(rs.getString("u_password"));
            user.setUemail(rs.getString("u_email"));
            user.setUsex(rs.getString("u_sex"));
            user.setUstatus(rs.getInt("u_status"));
            user.setUcode(rs.getString("u_code"));
            user.setUrole(rs.getInt("u_role"));
        } else{
            JdbcUtils.closeResource(conn, st, rs);
            return null;
        }
        JdbcUtils.closeResource(conn, st, rs);
        return user;
    }

    @Override
    public int insertUser(User user) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        String sql = "insert into user(u_name, u_password, u_email, u_sex, u_status, u_code, u_role) values" +
                "('" + user.getUname() + "','" + user.getUpassword() + "','" + user.getUemail() + "','" +
                user.getUsex() + "'," + user.getUstatus() + ",'" + user.getUcode() + "'," + user.getUrole() +
                ");";
        System.out.println(sql);
        int row = st.executeUpdate(sql);
        JdbcUtils.closeResource(conn, st, rs);
        return row;
    }

    @Override
    public User selectUserByUcode(String code) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        String sql = "select * from user where u_code = '" + code + "';";
        rs = st.executeQuery(sql);
        User user = new User();
        if(rs.next()) {
            user.setUid(rs.getInt("u_id"));
            user.setUname(rs.getString("u_name"));
            user.setUpassword(rs.getString("u_password"));
            user.setUemail(rs.getString("u_email"));
            user.setUsex(rs.getString("u_sex"));
            user.setUstatus(rs.getInt("u_status"));
            user.setUcode(rs.getString("u_code"));
            user.setUrole(rs.getInt("u_role"));
        } else{
            JdbcUtils.closeResource(conn, st, rs);
            return null;
        }
        JdbcUtils.closeResource(conn, st, rs);
        return user;
    }

    @Override
    public int updateUstatusByUid(int uid) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        String sql = "update user set u_status = 1 where u_id = " + uid + ';';
        System.out.println(sql);
        int row = st.executeUpdate(sql);
        JdbcUtils.closeResource(conn, st, rs);
        return row;
    }
}
