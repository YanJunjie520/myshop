package com.shop.myshop.dao.impl;

import com.shop.myshop.dao.OrdersDao;
import com.shop.myshop.entity.*;
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

public class OrdersDaoImpl implements OrdersDao {

    @Override
    public void insertOrders(Orders orders) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        Date date = orders.getOtime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //设置日期格式
        String dateTime = df.format(date);  // Formats a Date into a date/time string.
        String sql = "insert into orders(o_id,u_id,a_id,o_count,o_time,o_state) values('" + orders.getOid() + "'," +
                orders.getUid() + ',' + orders.getAddress().getAid() + ',' + orders.getOcount() + ",'" + dateTime + "'," +
                orders.getOstate() + ");";
        System.out.println(sql);
        st.executeUpdate(sql);
        JdbcUtils.closeResource(conn, st, rs);
    }

    @Override
    public List<Orders> selectOrdersByUid(int uid) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        String sql = "select * from address a join orders o on a.a_id = o.a_id where o.u_id = " + uid + ';';
        rs = st.executeQuery(sql);
        List<Orders> ordersList = new ArrayList<>();
        while (rs.next()) {
            Address address = new Address();
            Orders orders = new Orders();
            address.setAid(rs.getInt("a.a_id"));
            address.setUid(rs.getInt("a.u_id"));
            address.setAname(rs.getString("a.a_name"));
            address.setAphone(rs.getString("a.a_phone"));
            address.setAdetail(rs.getString("a.a_detail"));
            address.setAstate(rs.getInt("a.a_state"));
            orders.setAddress(address);
            orders.setOid(rs.getString("o.o_id"));
            orders.setUid(rs.getInt("o.u_id"));
            orders.setOcount(rs.getBigDecimal("o.o_count"));
            String strTime = rs.getString("o.o_time");
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dateTime = null;
            try {
                dateTime = sdf1.parse(strTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            orders.setOtime(dateTime);
            orders.setOstate(rs.getInt("o.o_state"));
            ordersList.add(orders);
        }
        JdbcUtils.closeResource(conn, st, rs);
        return ordersList;
    }

    @Override
    public Orders selectOrdersByOid(String oid) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        String sql = "select * from address a join orders o on a.a_id = o.a_id where o.o_id = '" + oid + "';";
        rs = st.executeQuery(sql);
        if (rs.next()) {
            Orders orders = new Orders();
            Address address = new Address();
            address.setAid(rs.getInt("a.a_id"));
            address.setUid(rs.getInt("a.u_id"));
            address.setAname(rs.getString("a.a_name"));
            address.setAphone(rs.getString("a.a_phone"));
            address.setAdetail(rs.getString("a.a_detail"));
            address.setAstate(rs.getInt("a.a_state"));
            orders.setAddress(address);
            orders.setOid(rs.getString("o.o_id"));
            orders.setUid(rs.getInt("o.u_id"));
            orders.setOcount(rs.getBigDecimal("o.o_count"));
            String strTime = rs.getString("o.o_time");
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dateTime = null;
            try {
                dateTime = sdf1.parse(strTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            orders.setOtime(dateTime);
            orders.setOstate(rs.getInt("o.o_state"));
            JdbcUtils.closeResource(conn, st, rs);
            return orders;
        }
        else {
            JdbcUtils.closeResource(conn, st, rs);
            return null;
        }
    }

    @Override
    public void updateOstateByOid(String oid) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        String sql = "update orders set o_state = 1 where o_id = '" + oid + "';";
        System.out.println(sql);
        st.executeUpdate(sql);
        JdbcUtils.closeResource(conn, st, rs);
    }

    @Override
    public List<Orders> selectAllOrders() throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        String sql = "select * from orders o, item i, product p where o.o_id = i.o_id and i.p_id = p.p_id;";
        rs = st.executeQuery(sql);
        List<Orders> ordersList = new ArrayList<>();
        while(rs.next()) {
            Product product = new Product();
            Item item = new Item();
            Orders orders = new Orders();
            product.setPname(rs.getString("p.p_name"));
            item.setInum(rs.getInt("i.i_num"));
            item.setIcount(rs.getBigDecimal("i.i_count"));
            item.setProduct(product);
            orders.setOid(rs.getString("o.o_id"));
            orders.setOstate(rs.getInt("o.o_state"));
            String strTime = rs.getString("o.o_time");
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dateTime = null;
            try {
                dateTime = sdf1.parse(strTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            orders.setOtime(dateTime);
            int index = -1;
            boolean exist = false;
            for(Orders order: ordersList) {
                index++;
                if(order.getOid().equals(orders.getOid())) {
                    exist = true;
                    break;
                }
            }
            if(exist) {
                ordersList.get(index).getItemList().add(item);
            }
            else {
                orders.setItemList(new ArrayList<>());
                orders.getItemList().add(item);
                ordersList.add(orders);
            }
        }
        JdbcUtils.closeResource(conn, st, rs);
        return ordersList;
    }

}
