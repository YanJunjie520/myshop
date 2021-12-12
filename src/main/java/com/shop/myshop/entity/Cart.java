package com.shop.myshop.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 数据库对应的购物车表
 */
public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;

    private int cid;          //购物车的唯一标识符
    private int uid;          //用户的唯一标识符
    private Product product;
    private int cnum = 0;         //购物车商品数量
    private BigDecimal ccount;    //购物车小计

    @Override
    public String toString() {
        return "Cart{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", product=" + product +
                ", cnum=" + cnum +
                ", ccount=" + ccount +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCnum() {
        return cnum;
    }

    public void setCnum(int cnum) {
        this.cnum = cnum;
    }

    public BigDecimal getCcount() {
        BigDecimal pprice = product.getPprice();
        BigDecimal bigDecimal = new BigDecimal(cnum);
        ccount = pprice.multiply(bigDecimal);
        return ccount;
    }

    public void setCcount(BigDecimal ccount) {
        this.ccount = ccount;
    }
}
