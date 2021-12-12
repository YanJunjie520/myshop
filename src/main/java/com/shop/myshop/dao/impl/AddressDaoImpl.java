package com.shop.myshop.dao.impl;

import com.shop.myshop.dao.AddressDao;
import com.shop.myshop.entity.Address;
import com.shop.myshop.entity.Cart;
import com.shop.myshop.entity.Product;
import com.shop.myshop.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressDaoImpl implements AddressDao {

    @Override
    public List<Address> selectAddressByUid(int uid) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        String sql = "select * from address where u_id = " + uid + " order by a_state desc;";
        rs = st.executeQuery(sql);
        List<Address> listAddress = new ArrayList<>();
        while(rs.next()) {
            Address address = new Address();
            address.setAid(rs.getInt("a_id"));
            address.setUid(uid);
            address.setAname(rs.getString("a_name"));
            address.setAphone(rs.getString("a_phone"));
            address.setAdetail(rs.getString("a_detail"));
            address.setAstate(rs.getInt("a_state"));
            listAddress.add(address);
        }
        JdbcUtils.closeResource(conn, st, rs);
        return listAddress;
    }

    @Override
    public void insertAddress(Address address) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        String sql = "insert into address(u_id,a_name,a_phone,a_detail,a_state) values(" + address.getUid() + ",'"
                + address.getAname() + "','" + address.getAphone() + "','" + address.getAdetail() + "'," +
                address.getAstate() + ");";
        System.out.println(sql);
        st.executeUpdate(sql);
        JdbcUtils.closeResource(conn, st, rs);
    }

    @Override
    public void deleteAddressByAid(String aid) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        String sql = "delete from address where a_id = " + aid + ';';
        System.out.println(sql);
        st.executeUpdate(sql);
        JdbcUtils.closeResource(conn, st, rs);
    }

    @Override
    public void updateAstateByAddress(Address address) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        String sql = "update address set a_state = " + address.getAstate() + " where a_id = " + address.getAid() +';';
        System.out.println(sql);
        st.executeUpdate(sql);
        JdbcUtils.closeResource(conn, st, rs);
    }

    @Override
    public void updateAddressToDefault(int uid, String aid) throws SQLException {
        List<Address> list = selectAddressByUid(uid);
        boolean modify;
        for (Address value : list) {
            modify = false;
            if (value.getAstate() == 1) {
                value.setAstate(0);
                modify = true;
            }
            if (value.getAid() == Integer.parseInt(aid)) {
                value.setAstate(1);
                modify = true;
            }
            if (modify) {
                updateAstateByAddress(value);
            }
        }
    }

    @Override
    public Address selectAddressByAid(String aid) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        String sql = "select * from address where a_id = " + aid + ';';
        rs = st.executeQuery(sql);
        if(rs.next()) {
            Address address = new Address();
            address.setAid(rs.getInt("a_id"));
            address.setUid(rs.getInt("u_id"));
            address.setAname(rs.getString("a_name"));
            address.setAphone(rs.getString("a_phone"));
            address.setAdetail(rs.getString("a_detail"));
            address.setAstate(rs.getInt("a_state"));
            JdbcUtils.closeResource(conn, st, rs);
            return address;
        }else {
            JdbcUtils.closeResource(conn, st, rs);
            return null;
        }
    }

    @Override
    public void updateAddressByAid(String aid, String aname, String aphone, String adetail) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        String sql = "update address set a_name = '" + aname + "' , a_phone = '" + aphone + "' , a_detail = '" +
                adetail + "' where a_id = " + aid +';';
        System.out.println(sql);
        st.executeUpdate(sql);
        JdbcUtils.closeResource(conn, st, rs);
    }
}
