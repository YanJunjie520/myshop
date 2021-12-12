package com.shop.myshop.entity;

import java.io.Serializable;

/**
 * 对应数据库的用户表
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private int uid;       //用户的唯一标识符
    private String uname;       //用户的名字
    private String upassword;     //用户的登陆密码
    private String usex;        //用户的性别
    private int ustatus;      //用户的激活状态   0为未激活  1为已激活
    private String ucode;        //用户的激活码
    private String uemail;       //用户的邮箱
    private int urole;        //用户的角色   0为用户  1为管理员

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
                ", usex='" + usex + '\'' +
                ", ustatus=" + ustatus +
                ", ucode='" + ucode + '\'' +
                ", uemail='" + uemail + '\'' +
                ", urole=" + urole +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public int getUstatus() {
        return ustatus;
    }

    public void setUstatus(int ustatus) {
        this.ustatus = ustatus;
    }

    public String getUcode() {
        return ucode;
    }

    public void setUcode(String ucode) {
        this.ucode = ucode;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public int getUrole() {
        return urole;
    }

    public void setUrole(int urole) {
        this.urole = urole;
    }
}
