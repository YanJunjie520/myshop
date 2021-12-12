package com.shop.myshop.service.impl;

import com.shop.myshop.dao.CartDao;
import com.shop.myshop.dao.ItemDao;
import com.shop.myshop.dao.OrdersDao;
import com.shop.myshop.dao.ProductDao;
import com.shop.myshop.dao.impl.CartDaoImpl;
import com.shop.myshop.dao.impl.ItemDaoImpl;
import com.shop.myshop.dao.impl.OrdersDaoImpl;
import com.shop.myshop.dao.impl.ProductDaoImpl;
import com.shop.myshop.entity.*;
import com.shop.myshop.service.OrdersService;
import com.shop.myshop.utils.RandomUtils;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class OrdersServiceImpl implements OrdersService {
    @Override
    public void createOrder(String aid, String uid, String sum) throws SQLException {
        //1、创建一个订单对象进行保存
        Orders orders = new Orders();
        BigDecimal bsum = new BigDecimal(sum);
        String orderId = RandomUtils.createOrderId();
        orders.setOid(orderId);
        orders.setAddress(new Address());
        orders.getAddress().setAid(Integer.parseInt(aid));
        orders.setUid(Integer.parseInt(uid));
        orders.setOtime(new Date());
        orders.setOcount(bsum);
        orders.setOstate(0);
        //2、保存订单
        OrdersDao ordersDao = new OrdersDaoImpl();
        ordersDao.insertOrders(orders);
        //3、将购物车转成订单项
        CartDao cartDao = new CartDaoImpl();
        List<Cart> cartList = cartDao.selectCartByUid(Integer.parseInt(uid));
        List<Item> itemList = new ArrayList<>();
        for(Cart cart : cartList) {
            Item item = new Item();
            item.setProduct(cart.getProduct());
            item.setOid(orderId);
            item.setIcount(cart.getCcount());
            item.setInum(cart.getCnum());
            itemList.add(item);
        }
        //4、保存订单对应的订单项
        ItemDao itemDao = new ItemDaoImpl();
        itemDao.insertItems(itemList);
        //5、清空购物车
        cartDao.clearCartByUid(uid);
    }

    @Override
    public List<Orders> findOrdersByUid(int uid) throws SQLException {
        OrdersDao ordersDao = new OrdersDaoImpl();
        return ordersDao.selectOrdersByUid(uid);
    }

    @Override
    public Orders findOrdersByOid(String oid) throws SQLException {
        OrdersDao ordersDao = new OrdersDaoImpl();
        //1、oid查询订单和订单地址信息
        //订单和地址
        Orders orders = ordersDao.selectOrdersByOid(oid);
        //2、oid对应的订单项和商品信息
        ItemDao itemDao = new ItemDaoImpl();
        List<Item> itemList = itemDao.selectItemsByOid(oid);
        //3、订单项集合设置给订单对象
        orders.setItemList(itemList);
        return orders;
    }

    @Override
    public void updataOstate(String oid) throws SQLException {
        OrdersDao ordersDao = new OrdersDaoImpl();
        ordersDao.updateOstateByOid(oid);
    }

    @Override
    public List<Orders> findAll() throws SQLException {
        OrdersDao ordersDao = new OrdersDaoImpl();
        return ordersDao.selectAllOrders();
    }
}
