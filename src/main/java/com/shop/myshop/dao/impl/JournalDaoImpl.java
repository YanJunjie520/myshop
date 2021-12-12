package com.shop.myshop.dao.impl;

import com.shop.myshop.dao.JournalDao;
import com.shop.myshop.entity.Journal;
import com.shop.myshop.entity.Product;
import com.shop.myshop.entity.User;
import com.shop.myshop.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JournalDaoImpl implements JournalDao {

    @Override
    public void insertJournal(String pid, String uid) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //设置日期格式
        String dateTime = df.format(date);  // Formats a Date into a date/time string.
        String sql = "insert into journal(p_id,u_id,j_time) values(" + pid + ',' + uid + ",'" + dateTime + "');";
        System.out.println(sql);
        st.executeUpdate(sql);
        JdbcUtils.closeResource(conn, st, rs);
    }

    @Override
    public List<Journal> selectAllJournal() throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        String sql = "select * from journal j, user u, product p where j.u_id = u.u_id and j.p_id = p.p_id order by j.u_id asc; ";
        rs = st.executeQuery(sql);
        List<Journal> journalList = new ArrayList<>();
        while(rs.next()) {
            User user = new User();
            Product product = new Product();
            Journal journal = new Journal();
            user.setUid(rs.getInt("j.u_id"));
            user.setUname(rs.getString("u.u_name"));
            product.setPid(rs.getInt("j.p_id"));
            product.setPname(rs.getString("p.p_name"));
            journal.setJid(rs.getInt("j_id"));
            journal.setUser(user);
            journal.setProduct(product);
            String strTime = rs.getString("j_time");
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dateTime = null;
            try {
                dateTime = sdf1.parse(strTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            journal.setJtime(dateTime);
            journalList.add(journal);
        }
        JdbcUtils.closeResource(conn, st, rs);
        return journalList;
    }
}
