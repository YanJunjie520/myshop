package com.shop.myshop.service;

import com.shop.myshop.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {

    List<Product> findProduct(String typeid) throws SQLException;

    Product findProductByPid(String pid) throws SQLException;

    List<Product> findProductByPname(String pname) throws SQLException;

    List<Product> findAll() throws SQLException;

    void deleteProduct(String pid) throws SQLException;

    void modifyProduct(String pid, int tid, String pname, String ptime, String pimage, String pprice, String pstate, String pinfo) throws SQLException;

    void addProduct(int tid, String pname, String pimage, String pprice, String pinfo) throws SQLException;
}
