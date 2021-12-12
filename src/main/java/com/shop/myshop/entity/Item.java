package com.shop.myshop.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 对应数据库的订单项
 */
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    private int iid;       //订单项的唯一标识符
    private String oid;        //订单的唯一标识符
    private Product product;      //商品实体
    private BigDecimal icount;          //订单项的金额
    private int inum;            //订单项的数量

    @Override
    public String toString() {
        return "Item{" +
                "iid=" + iid +
                ", oid='" + oid + '\'' +
                ", icount=" + icount +
                ", inum=" + inum +
                '}';
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getIcount() {
        return icount;
    }

    public void setIcount(BigDecimal icount) {
        this.icount = icount;
    }

    public int getInum() {
        return inum;
    }

    public void setInum(int inum) {
        this.inum = inum;
    }
}
