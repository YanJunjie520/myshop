package com.shop.myshop.service;

import com.shop.myshop.entity.Cart;

import java.sql.SQLException;
import java.util.List;

public interface CartSevice {
    void createCart(int uid, String pid) throws SQLException;

    List<Cart> findAll(int uid) throws SQLException;

    void deleteCartByCid(String cid) throws SQLException;

    void updateCartByCid(String cid, String cnum, String price) throws SQLException;

    void clearCart(String uid) throws SQLException;
}
