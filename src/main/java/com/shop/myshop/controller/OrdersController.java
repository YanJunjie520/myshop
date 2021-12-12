package com.shop.myshop.controller;

import com.shop.myshop.entity.*;
import com.shop.myshop.service.AddressService;
import com.shop.myshop.service.CartSevice;
import com.shop.myshop.service.OrdersService;
import com.shop.myshop.service.ProductService;
import com.shop.myshop.service.impl.AddressServiceImpl;
import com.shop.myshop.service.impl.CartServiceImpl;
import com.shop.myshop.service.impl.OrdersServiceImpl;
import com.shop.myshop.service.impl.ProductServiceImpl;
import com.shop.myshop.utils.EmailUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/orders")
public class OrdersController extends BaseServlet{

    public String preview(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String uid = request.getParameter("uid");
        AddressService addressService = new AddressServiceImpl();
        List<Address> addressList = addressService.findAddressByUid(Integer.parseInt(uid));
        CartSevice cartSevice = new CartServiceImpl();
        List<Cart> cartList = cartSevice.findAll(Integer.parseInt(uid));
        request.setAttribute("addressList", addressList);
        request.setAttribute("cartList", cartList);
        return "forward:/order.jsp";
    }

    public String create(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String uid = request.getParameter("uid");
        String sum = request.getParameter("sum");
        String aid = request.getParameter("aid");
        OrdersService ordersService = new OrdersServiceImpl();
        ordersService.createOrder(aid, uid, sum);
        return "forward:/orders?method=show";
    }

    public String show(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("loginUser");
        if(user == null) {
            session.setAttribute("msg", "请先登录，再查看订单！");
            return "redirect:/myshop/login.jsp";
        }
        OrdersService ordersService = new OrdersServiceImpl();
        List<Orders> ordersList = ordersService.findOrdersByUid(user.getUid());
        request.setAttribute("ordersList", ordersList);
        return "forward:/orderList.jsp";
    }

    public String detail(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String oid = request.getParameter("oid");
        OrdersService ordersService = new OrdersServiceImpl();
        Orders orders = ordersService.findOrdersByOid(oid);
        request.setAttribute("orders", orders);
        return "forward:/orderDetail.jsp";
    }

    public String pay(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("loginUser");
        String oid = request.getParameter("oid");
        OrdersService ordersService = new OrdersServiceImpl();
        ordersService.updataOstate(oid);
        EmailUtils.sendPayEmail(user);
        return "forward:/paySuccess.jsp";
    }

    public String statistics(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        OrdersService ordersService = new OrdersServiceImpl();
        List<Orders> ordersList = ordersService.findAll();
        request.setAttribute("ordersList", ordersList);
        return "forward:/statistics.jsp";
    }
}
