package com.shop.myshop.dao.impl;

import com.shop.myshop.dao.CartDao;
import com.shop.myshop.entity.Cart;
import com.shop.myshop.entity.Product;
import com.shop.myshop.entity.Type;
import com.shop.myshop.utils.JdbcUtils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {
    @Override
    public Cart hasCart(int uid, String pid) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        String sql = "select * from product p join cart c on p.p_id = c.p_id where c.u_id = " + uid
                + " and c.p_id = " + pid + ';';
        rs = st.executeQuery(sql);
        if(rs.next()) {
            Product product = new Product();
            Cart cart = new Cart();
            product.setPid(rs.getInt("p.p_id"));
            Type type = new Type();
            type.setTid(rs.getInt("t_id"));
            product.setType(type);
            product.setPname(rs.getString("p.p_name"));
            product.setPtime(rs.getDate("p.p_time"));
            product.setPimage(rs.getString("p.p_image"));
            product.setPprice(rs.getBigDecimal("p.p_price"));
            product.setPstate(rs.getInt("p.p_state"));
            product.setPinfo(rs.getString("p.p_info"));
            cart.setProduct(product);
            cart.setCid(rs.getInt("c.c_id"));
            cart.setUid(rs.getInt("c.u_id"));
            cart.setCnum(rs.getInt("c.c_num"));
            cart.setCcount(rs.getBigDecimal("c.c_count"));
            JdbcUtils.closeResource(conn, st, rs);
            return cart;
        }else {
            JdbcUtils.closeResource(conn, st, rs);
            return null;
        }
    }

    @Override
    public void updateCart(Cart cart) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        String sql = "update cart set c_num = " + cart.getCnum() + " , c_count = " + cart.getCcount() + " where c_id = "
                + cart.getCid() + ';';
        System.out.println(sql);
        st.executeUpdate(sql);
        JdbcUtils.closeResource(conn, st, rs);
    }

    @Override
    public void insertCart(Cart cart) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        String sql = "insert into cart(p_id,u_id,c_count,c_num) values(" + cart.getProduct().getPid() + ','
                + cart.getUid() + ',' + cart.getCcount() + ',' + cart.getCnum() + ");";
        System.out.println(sql);
        st.executeUpdate(sql);
        JdbcUtils.closeResource(conn, st, rs);
    }

    @Override
    public List<Cart> selectCartByUid(int uid) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        String sql = "select * from product p join cart c on p.p_id = c.p_id where c.u_id = " + uid + ';';
        rs = st.executeQuery(sql);
        List<Cart> listCart = new ArrayList<>();
        while(rs.next()) {
            Product product = new Product();
            Cart cart = new Cart();
            product.setPid(rs.getInt("p.p_id"));
            Type type = new Type();
            type.setTid(rs.getInt("t_id"));
            product.setType(type);
            product.setPname(rs.getString("p.p_name"));
            product.setPtime(rs.getDate("p.p_time"));
            product.setPimage(rs.getString("p.p_image"));
            product.setPprice(rs.getBigDecimal("p.p_price"));
            product.setPstate(rs.getInt("p.p_state"));
            product.setPinfo(rs.getString("p.p_info"));
            cart.setProduct(product);
            cart.setCid(rs.getInt("c.c_id"));
            cart.setUid(rs.getInt("c.u_id"));
            cart.setCnum(rs.getInt("c.c_num"));
            cart.setCcount(rs.getBigDecimal("c.c_count"));
            listCart.add(cart);
        }
        JdbcUtils.closeResource(conn, st, rs);
        return listCart;
    }

    @Override
    public void deleteCartByCid(String cid) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        String sql = "delete from cart where c_id = " + cid + ';';
        System.out.println(sql);
        st.executeUpdate(sql);
        JdbcUtils.closeResource(conn, st, rs);
    }

    @Override
    public void updateByCid(String cid, String cnum, BigDecimal ccount) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        String sql = "update cart set c_num = " + cnum + " , c_count = " + ccount + " where c_id = " + cid +';';
        System.out.println(sql);
        st.executeUpdate(sql);
        JdbcUtils.closeResource(conn, st, rs);
    }

    @Override
    public void clearCartByUid(String uid) throws SQLException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = JdbcUtils.getConnection();
        st = conn.createStatement();
        String sql = "delete from cart where u_id = " + uid + ';';
        System.out.println(sql);
        st.executeUpdate(sql);
        JdbcUtils.closeResource(conn, st, rs);
    }
}
