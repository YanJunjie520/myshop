package com.shop.myshop.controller;

import com.shop.myshop.service.TypeService;
import com.shop.myshop.service.impl.TypeServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@WebServlet("/type")
public class TypeController extends BaseServlet {

    public String jump(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String typename = request.getParameter("typename");
        TypeService typeService = new TypeServiceImpl();
        int typeid = typeService.findtid(typename);
        if(typeid == 0) {
            System.out.println("没有对应种类的商品");
            return "forward:/index.jsp";
        }
        else {
            return "forward:/product?method=show&tid="+typeid;
        }
    }
}
