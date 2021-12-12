package com.shop.myshop.controller;

import com.shop.myshop.entity.Cart;
import com.shop.myshop.entity.User;
import com.shop.myshop.service.CartSevice;
import com.shop.myshop.service.impl.CartServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/cart")
public class CartController extends BaseServlet {

    public String create(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        //1、判断是否已经登录
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginUser");
        if(user == null) {
            session.setAttribute("msg", "请先登录，再添加购物车！");
            return "forward:/login.jsp";
        }
        //商品的id（pid）和用户的id（uid）
        int uid = user.getUid();
        String pid = request.getParameter("pid");
        CartSevice cartSevice = new CartServiceImpl();
        cartSevice.createCart(uid, pid);
        return "forward:/cartSuccess.jsp";
    }

    public String show(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        //1、判断是否已经登录
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginUser");
        if(user == null) {
            session.setAttribute("msg", "查看购物车前需要先登录！");
            return "forward:/login.jsp";
        }

        //2、获取参数
        int uid = user.getUid();

        CartSevice cartSevice = new CartServiceImpl();
        List<Cart> listCart = cartSevice.findAll(uid);
        request.setAttribute("listCart", listCart);
        return "forward:/cart.jsp";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String cid = request.getParameter("cid");
        CartSevice cartSevice = new CartServiceImpl();
        cartSevice.deleteCartByCid(cid);
        return "forward:/cart?method=show";
    }

    public String update(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String cid = request.getParameter("cid");
        String cnum = request.getParameter("cnum");
        String price = request.getParameter("price");
        CartSevice cartSevice = new CartServiceImpl();
        cartSevice.updateCartByCid(cid, cnum, price);
        return "forward:/cart?method=show";
    }

    public String clear(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String uid = request.getParameter("uid");
        CartSevice cartSevice = new CartServiceImpl();
        cartSevice.clearCart(uid);
        return "forward:/cart?method=show";
    }
}
