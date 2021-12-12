package com.shop.myshop.service;

import com.shop.myshop.entity.Address;

import java.sql.SQLException;
import java.util.List;

public interface AddressService {
    List<Address> findAddressByUid(int uid) throws SQLException;

    void addAddress(Address address) throws SQLException;

    void deleteAddress(String aid) throws SQLException;

    void setAddressToDefault(int uid, String aid) throws SQLException;

    Address findAddressByAid(String aid) throws SQLException;

    void modifyAddress(String aid, String aname, String aphone, String adetail) throws SQLException;
}
