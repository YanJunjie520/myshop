package com.shop.myshop.dao.impl;

import com.shop.myshop.dao.TypeDao;
import com.shop.myshop.entity.User;
import com.shop.myshop.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TypeDaoImpl implements TypeDao {
    @Override
    public int findTidByTname(String typename) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        String sql = "select t_id from type where t_name = '" + typename + "';";
        rs = st.executeQuery(sql);
        int tid = 0;
        if(rs.next()) {
            tid = rs.getInt("t_id");
            JdbcUtils.closeResource(conn, st, rs);
            return tid;
        } else{
            JdbcUtils.closeResource(conn, st, rs);
            return tid;
        }
    }
}
