package com.shop.myshop.service;

import com.shop.myshop.entity.Orders;

import java.sql.SQLException;
import java.util.List;

public interface OrdersService {
    void createOrder(String aid, String uid, String sum) throws SQLException;

    List<Orders> findOrdersByUid(int uid) throws SQLException;

    Orders findOrdersByOid(String oid) throws SQLException;

    void updataOstate(String oid) throws SQLException;

    List<Orders> findAll() throws SQLException;
}
