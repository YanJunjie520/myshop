package com.shop.myshop.service.impl;

import com.shop.myshop.dao.CartDao;
import com.shop.myshop.dao.ProductDao;
import com.shop.myshop.dao.impl.CartDaoImpl;
import com.shop.myshop.dao.impl.ProductDaoImpl;
import com.shop.myshop.entity.Cart;
import com.shop.myshop.entity.Product;
import com.shop.myshop.service.CartSevice;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

public class CartServiceImpl implements CartSevice {
    @Override
    public void createCart(int uid, String pid) throws SQLException {
        //1、判断商品是否已经在购物车中
        CartDao cartDao = new CartDaoImpl();
        Cart cart = cartDao.hasCart(uid, pid);
        //2、存在则修改数量和小计
        if (cart != null) {
            cart.setCnum(cart.getCnum() + 1);
            cartDao.updateCart(cart);
        }
        //3、不存在则添加商品到购物车
        else {
            //（1）先根据商品id查询商品
            ProductDao productDao = new ProductDaoImpl();
            Product product = productDao.selectProductByPid(pid);
            cart = new Cart();
            cart.setUid(uid);
            cart.setProduct(product);
            cart.setCnum(1);
            cartDao.insertCart(cart);
        }
    }

    @Override
    public List<Cart> findAll(int uid) throws SQLException {
        CartDao cartDao = new CartDaoImpl();
        return cartDao.selectCartByUid(uid);
    }

    @Override
    public void deleteCartByCid(String cid) throws SQLException {
        CartDao cartDao = new CartDaoImpl();
        cartDao.deleteCartByCid(cid);
    }

    @Override
    public void updateCartByCid(String cid, String cnum, String price) throws SQLException {
        BigDecimal cnumBig = new BigDecimal(cnum);
        BigDecimal priceBig = new BigDecimal(price);

        BigDecimal ccount = priceBig.multiply(cnumBig);

        CartDao cartDao = new CartDaoImpl();
        cartDao.updateByCid(cid, cnum, ccount);
    }

    @Override
    public void clearCart(String uid) throws SQLException {
        CartDao cartDao = new CartDaoImpl();
        cartDao.clearCartByUid(uid);
    }
}
