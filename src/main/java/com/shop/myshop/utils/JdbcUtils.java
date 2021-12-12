package com.shop.myshop.utils;

import java.sql.*;

public class JdbcUtils {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/shopping";
    private static String user = "root";
    private static String password = "520BABAmama";

    static {
        try {
            //注册驱动
            Class.forName(driver);
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获得连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() {
        //获得连接
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 释放资源
     * @param conn
     * @param st
     * @param rs
     */
    public static void closeResource(Connection conn, Statement st, ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
