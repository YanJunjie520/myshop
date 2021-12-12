package com.shop.myshop.service;

import java.sql.SQLException;

public interface TypeService {

    /**
     * 根据typename寻找对应的tid
     * @return tid
     */
    int findtid(String typename) throws SQLException;
}
