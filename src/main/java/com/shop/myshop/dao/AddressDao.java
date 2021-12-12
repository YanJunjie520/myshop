package com.shop.myshop.dao;

import com.shop.myshop.entity.Address;

import java.sql.SQLException;
import java.util.List;

public interface AddressDao {
    List<Address> selectAddressByUid(int uid) throws SQLException;

    void insertAddress(Address address) throws SQLException;

    void deleteAddressByAid(String aid) throws SQLException;

    void updateAstateByAddress(Address address) throws SQLException;

    void updateAddressToDefault(int uid, String aid) throws SQLException;

    Address selectAddressByAid(String aid) throws SQLException;

    void updateAddressByAid(String aid, String aname, String aphone, String adetail) throws SQLException;
}
