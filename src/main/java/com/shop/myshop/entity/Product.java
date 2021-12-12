package com.shop.myshop.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 对应数据库的商品表
 */
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    private int pid;      //商品的唯一标识符
    private Type type;      //类别实体
    private String pname;       //商品名称
    private Date ptime;       //商品的上架时间
    private String pimage;      //商品的图片名称
    private BigDecimal pprice;     //商品的价格
    private int pstate;       //商品的热门指数
    private String pinfo;         //商品的描述

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", ptime=" + ptime +
                ", pimage='" + pimage + '\'' +
                ", pprice=" + pprice +
                ", pstate=" + pstate +
                ", pinfo='" + pinfo + '\'' +
                '}';
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Date getPtime() {
        return ptime;
    }

    public void setPtime(Date ptime) {
        this.ptime = ptime;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public BigDecimal getPprice() {
        return pprice;
    }

    public void setPprice(BigDecimal pprice) {
        this.pprice = pprice;
    }

    public int getPstate() {
        return pstate;
    }

    public void setPstate(int pstate) {
        this.pstate = pstate;
    }

    public String getPinfo() {
        return pinfo;
    }

    public void setPinfo(String pinfo) {
        this.pinfo = pinfo;
    }
}
