package com.shop.myshop.controller;

import com.shop.myshop.entity.Address;
import com.shop.myshop.entity.User;
import com.shop.myshop.service.AddressService;
import com.shop.myshop.service.impl.AddressServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/address")
public class AddressController extends BaseServlet{

    public String show(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("loginUser");
        if(user == null) {
            request.setAttribute("msg", "请先登录！");
            return "redirect:/myshop/login.jsp";
        }

        int uid = user.getUid();
        AddressService addressService = new AddressServiceImpl();
        List<Address> listAddress = addressService.findAddressByUid(uid);
        request.setAttribute("listAddress", listAddress);
        return "forward:/self_info.jsp";
    }

    public String add(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("loginUser");
        String aname = request.getParameter("aname");
        String aphone = request.getParameter("aphone");
        String adetail = request.getParameter("adetail");
        Address address = new Address();
        address.setUid(user.getUid());
        address.setAname(aname);
        address.setAphone(aphone);
        address.setAdetail(adetail);
        AddressService addressService = new AddressServiceImpl();
        addressService.addAddress(address);
        return "forward:/address?method=show";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String aid = request.getParameter("aid");
        AddressService addressService = new AddressServiceImpl();
        addressService.deleteAddress(aid);
        return "forward:/address?method=show";
    }

    public String setDefault(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("loginUser");
        String aid = request.getParameter("aid");
        AddressService addressService = new AddressServiceImpl();
        addressService.setAddressToDefault(user.getUid(), aid);
        return "forward:/address?method=show";
    }

    public String modify(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String aid = request.getParameter("aid");
        AddressService addressService = new AddressServiceImpl();
        Address address = addressService.findAddressByAid(aid);
        request.setAttribute("addr", address);
        return "forward:/self_info_modify.jsp";
    }

    public String modifyAddress(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String aid = request.getParameter("aid");
        String aname = request.getParameter("aname");
        String aphone = request.getParameter("aphone");
        String adetail = request.getParameter("adetail");
        AddressService addressService = new AddressServiceImpl();
        addressService.modifyAddress(aid, aname, aphone, adetail);
        return "forward:/address?method=show";
    }
}
