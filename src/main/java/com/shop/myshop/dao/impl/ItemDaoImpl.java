package com.shop.myshop.dao.impl;

import com.shop.myshop.dao.ItemDao;
import com.shop.myshop.entity.Cart;
import com.shop.myshop.entity.Item;
import com.shop.myshop.entity.Product;
import com.shop.myshop.entity.Type;
import com.shop.myshop.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao {
    @Override
    public void insertItems(List<Item> itemList) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        for(Item item : itemList) {
            String sql = "insert into item(p_id,o_id,i_count,i_num) values(" + item.getProduct().getPid() + ",'"
                    + item.getOid() + "'," + item.getIcount() + ',' + item.getInum() + ");";
            System.out.println(sql);
            st.executeUpdate(sql);
        }
        JdbcUtils.closeResource(conn, st, rs);
    }

    @Override
    public List<Item> selectItemsByOid(String oid) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = null;
        String sql = "select * from product p join item i on p.p_id = i.p_id where i.o_id = '" + oid + "';";
        rs = st.executeQuery(sql);
        List<Item> itemList = new ArrayList<>();
        while(rs.next()) {
            Product product = new Product();
            Item item = new Item();
            product.setPid(rs.getInt("p.p_id"));
            Type type = new Type();
            type.setTid(rs.getInt("t_id"));
            product.setType(type);
            product.setPname(rs.getString("p.p_name"));
            product.setPtime(rs.getDate("p.p_time"));
            product.setPimage(rs.getString("p.p_image"));
            product.setPprice(rs.getBigDecimal("p.p_price"));
            product.setPstate(rs.getInt("p.p_state"));
            product.setPinfo(rs.getString("p.p_info"));
            item.setProduct(product);
            item.setIid(rs.getInt("i.i_id"));
            item.setOid(oid);
            item.setIcount(rs.getBigDecimal("i.i_count"));
            item.setInum(rs.getInt("i.i_num"));
            itemList.add(item);
        }
        JdbcUtils.closeResource(conn, st, rs);
        return itemList;
    }
}
