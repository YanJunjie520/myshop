package com.shop.myshop.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 对应数据库的日志项
 */
public class Journal implements Serializable {
    private static final long serialVersionUID = 1L;

    private int jid;         //日志项的唯一标识
    private Product product;    //商品的实体
    private User user;         //用户的实体
    private Date jtime;       //日志日期

    @Override
    public String toString() {
        return "Journal{" +
                "jid=" + jid +
                ", jtime=" + jtime +
                '}';
    }

    public int getJid() {
        return jid;
    }

    public void setJid(int jid) {
        this.jid = jid;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getJtime() {
        return jtime;
    }

    public void setJtime(Date jtime) {
        this.jtime = jtime;
    }
}
