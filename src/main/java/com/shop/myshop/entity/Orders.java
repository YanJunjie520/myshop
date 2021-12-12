package com.shop.myshop.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 对应数据库的订单表
 */
public class Orders implements Serializable {
    private static final long serialVersionUID = 1L;

    private String oid;          //订单的唯一标识符
    private int uid;           //用户的唯一标识符
    private Address address;      //地址实体
    private BigDecimal ocount;    //订单总金额
    private Date otime;       //订单的日期
    private int ostate;      //订单的状态   0未付款   1已付款未发货   2已发货待收货   3已收货待评价   4已评价   5退款
    private List<Item> itemList;

    @Override
    public String toString() {
        return "Orders{" +
                "oid='" + oid + '\'' +
                ", uid=" + uid +
                ", ocount=" + ocount +
                ", otime=" + otime +
                ", ostate=" + ostate +
                '}';
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public BigDecimal getOcount() {
        return ocount;
    }

    public void setOcount(BigDecimal ocount) {
        this.ocount = ocount;
    }

    public Date getOtime() {
        return otime;
    }

    public void setOtime(Date otime) {
        this.otime = otime;
    }

    public int getOstate() {
        return ostate;
    }

    public void setOstate(int ostate) {
        this.ostate = ostate;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
