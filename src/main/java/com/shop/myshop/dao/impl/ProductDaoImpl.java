package com.shop.myshop.dao.impl;

import com.shop.myshop.dao.ProductDao;
import com.shop.myshop.entity.Product;
import com.shop.myshop.entity.Type;
import com.shop.myshop.entity.User;
import com.shop.myshop.utils.JdbcUtils;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public List<Product> selectProductByTid(String typeid) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        String sql = "select * from product where t_id = " + typeid + ';';
        rs = st.executeQuery(sql);
        List<Product> listProduct = new ArrayList<>();
        while(rs.next()) {
            Product product = new Product();
            product.setPid(rs.getInt("p_id"));
            Type type = new Type();
            type.setTid(rs.getInt("t_id"));
            product.setType(type);
            product.setPname(rs.getString("p_name"));
            product.setPtime(rs.getDate("p_time"));
            product.setPimage(rs.getString("p_image"));
            product.setPprice(rs.getBigDecimal("p_price"));
            product.setPstate(rs.getInt("p_state"));
            product.setPinfo(rs.getString("p_info"));
            listProduct.add(product);
        }
        JdbcUtils.closeResource(conn, st, rs);
        return listProduct;
    }

    @Override
    public Product selectProductByPid(String pid) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        String sql = "select * from type t join product p where t.t_id = p.t_id and p.p_id = " + pid + ';';
        rs = st.executeQuery(sql);
        if(rs.next()) {
            Product product = new Product();
            Type type = new Type();
            type.setTid(rs.getInt("t.t_id"));
            type.setTname(rs.getString("t.t_name"));
            type.setTinfo(rs.getString("t.t_info"));
            product.setType(type);
            product.setPid(rs.getInt("p.p_id"));
            product.setPname(rs.getString("p.p_name"));
            product.setPtime(rs.getDate("p.p_time"));
            product.setPimage(rs.getString("p.p_image"));
            product.setPprice(rs.getBigDecimal("p.p_price"));
            product.setPstate(rs.getInt("p.p_state"));
            product.setPinfo(rs.getString("p.p_info"));
            JdbcUtils.closeResource(conn, st, rs);
            return product;
        }else {
            JdbcUtils.closeResource(conn, st, rs);
            return null;
        }
    }

    @Override
    public List<Product> selectProductByPname(String pname) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        String sql = "select * from product where p_name = '" + pname + "';";
        rs = st.executeQuery(sql);
        List<Product> productList = new ArrayList<>();
        while(rs.next()) {
            Product product = new Product();
            product.setPid(rs.getInt("p_id"));
            Type type = new Type();
            type.setTid(rs.getInt("t_id"));
            product.setType(type);
            product.setPname(rs.getString("p_name"));
            product.setPtime(rs.getDate("p_time"));
            product.setPimage(rs.getString("p_image"));
            product.setPprice(rs.getBigDecimal("p_price"));
            product.setPstate(rs.getInt("p_state"));
            product.setPinfo(rs.getString("p_info"));
            productList.add(product);
        }
        JdbcUtils.closeResource(conn, st, rs);
        return productList;
    }

    @Override
    public List<Product> selectAllProduct() throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        String sql = "select * from type t join product p where t.t_id = p.t_id;";
        rs = st.executeQuery(sql);
        List<Product> productList = new ArrayList<>();
        while(rs.next()) {
            Product product = new Product();
            Type type = new Type();
            type.setTid(rs.getInt("t.t_id"));
            type.setTname(rs.getString("t.t_name"));
            type.setTinfo(rs.getString("t.t_info"));
            product.setType(type);
            product.setPid(rs.getInt("p_id"));
            product.setPname(rs.getString("p_name"));
            product.setPtime(rs.getDate("p_time"));
            product.setPimage(rs.getString("p_image"));
            product.setPprice(rs.getBigDecimal("p_price"));
            product.setPstate(rs.getInt("p_state"));
            product.setPinfo(rs.getString("p_info"));
            productList.add(product);
        }
        JdbcUtils.closeResource(conn, st, rs);
        return productList;
    }

    @Override
    public void deleteProductByPid(String pid) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        String sql = "delete from product where p_id = " + pid + ';';
        System.out.println(sql);
        st.executeUpdate(sql);
        JdbcUtils.closeResource(conn, st, rs);
    }

    @Override
    public void updateProductByPid(String pid, int tid, String pname, String ptime, String pimage, String pprice, String pstate, String pinfo) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        String sql = "update product set t_id = " + tid + ", p_name = '" + pname + "', p_time = '" + ptime + "', p_image = '" +
                pimage + "', p_price = " + pprice + ", p_state = " + pstate + ", p_info = '" + pinfo + "' where p_id = " + pid;
        System.out.println(sql);
        st.executeUpdate(sql);
        JdbcUtils.closeResource(conn, st, rs);
    }

    @Override
    public void insertProduct(int tid, String pname, String pimage, String pprice, String pinfo) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String ptime = format.format(date);
        String sql = "insert into product(t_id,p_name,p_time,p_image,p_price,p_state,p_info) values(" + tid + ",'"
                + pname + "','" + ptime + "','" + pimage + "'," + pprice + ",0,'" + pinfo + "');";
        System.out.println(sql);
        st.executeUpdate(sql);
        JdbcUtils.closeResource(conn, st, rs);
    }
}
