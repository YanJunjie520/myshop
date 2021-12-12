package com.shop.myshop.dao;

import com.shop.myshop.entity.Cart;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public interface CartDao {
    Cart hasCart(int uid, String pid) throws SQLException;

    void updateCart(Cart cart) throws SQLException;

    void insertCart(Cart cart) throws SQLException;

    List<Cart> selectCartByUid(int uid) throws SQLException;

    void deleteCartByCid(String cid) throws SQLException;

    void updateByCid(String cid, String cnum, BigDecimal ccount) throws SQLException;

    void clearCartByUid(String uid) throws SQLException;
}
