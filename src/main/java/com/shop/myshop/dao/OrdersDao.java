package com.shop.myshop.dao;

import com.shop.myshop.entity.Item;
import com.shop.myshop.entity.Orders;

import java.sql.SQLException;
import java.util.List;

public interface OrdersDao {
    void insertOrders(Orders orders) throws SQLException;

    List<Orders> selectOrdersByUid(int uid) throws SQLException;

    Orders selectOrdersByOid(String oid) throws SQLException;

    void updateOstateByOid(String oid) throws SQLException;

    List<Orders> selectAllOrders() throws SQLException;
}
