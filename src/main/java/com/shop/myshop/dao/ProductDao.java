package com.shop.myshop.dao;

import com.shop.myshop.entity.Product;
import com.shop.myshop.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {

    List<Product> selectProductByTid(String typeid) throws SQLException;

    Product selectProductByPid(String pid) throws SQLException;

    List<Product> selectProductByPname(String pname) throws SQLException;

    List<Product> selectAllProduct() throws SQLException;

    void deleteProductByPid(String pid) throws SQLException;

    void updateProductByPid(String pid, int tid, String pname, String ptime, String pimage, String pprice, String pstate, String pinfo) throws SQLException;

    void insertProduct(int tid, String pname, String pimage, String pprice, String pinfo) throws SQLException;
}
