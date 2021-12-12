package com.shop.myshop.dao;

import java.sql.SQLException;

public interface TypeDao {

    int findTidByTname(String typename) throws SQLException;
}
