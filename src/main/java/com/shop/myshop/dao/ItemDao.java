package com.shop.myshop.dao;

import com.shop.myshop.entity.Item;

import java.sql.SQLException;
import java.util.List;

public interface ItemDao {
    void insertItems(List<Item> itemList) throws SQLException;

    List<Item> selectItemsByOid(String oid) throws SQLException;
}
