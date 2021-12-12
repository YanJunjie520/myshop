package com.shop.myshop.service.impl;

import com.shop.myshop.dao.AddressDao;
import com.shop.myshop.dao.impl.AddressDaoImpl;
import com.shop.myshop.entity.Address;
import com.shop.myshop.service.AddressService;

import java.sql.SQLException;
import java.util.List;

public class AddressServiceImpl implements AddressService {
    @Override
    public List<Address> findAddressByUid(int uid) throws SQLException {
        AddressDao addressDao = new AddressDaoImpl();
        return addressDao.selectAddressByUid(uid);
    }

    @Override
    public void addAddress(Address address) throws SQLException {
        AddressDao addressDao = new AddressDaoImpl();
        addressDao.insertAddress(address);
    }

    @Override
    public void deleteAddress(String aid) throws SQLException {
        AddressDao addressDao = new AddressDaoImpl();
        addressDao.deleteAddressByAid(aid);
    }

    @Override
    public void setAddressToDefault(int uid, String aid) throws SQLException {
        AddressDao addressDao = new AddressDaoImpl();
        //1、将aid的astate改为1   默认地址    将非aid的astate改为0    非默认地址
        addressDao.updateAddressToDefault(uid, aid);
    }

    @Override
    public Address findAddressByAid(String aid) throws SQLException {
        AddressDao addressDao = new AddressDaoImpl();
        return addressDao.selectAddressByAid(aid);
    }

    @Override
    public void modifyAddress(String aid, String aname, String aphone, String adetail) throws SQLException {
        AddressDao addressDao = new AddressDaoImpl();
        addressDao.updateAddressByAid(aid, aname, aphone, adetail);
    }
}
