package com.shop.myshop.controller;

import com.shop.myshop.entity.Product;
import com.shop.myshop.service.JournalService;
import com.shop.myshop.service.ProductService;
import com.shop.myshop.service.TypeService;
import com.shop.myshop.service.impl.JournalServiceImpl;
import com.shop.myshop.service.impl.ProductServiceImpl;
import com.shop.myshop.service.impl.TypeServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/product")
public class ProductController extends BaseServlet{

    public String show(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String tid = request.getParameter("tid");
        ProductService productService = new ProductServiceImpl();
        List<Product> listProduct = productService.findProduct(tid);
        if(listProduct.isEmpty()) {
            System.out.println("该种类没有商品");
            return "forward:/index.jsp";
        }
        else {
            request.setAttribute("listProduct", listProduct);
            return "forward:/goodsList.jsp";
        }
    }

    public String detail(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String pid = request.getParameter("pid");
        String uid = request.getParameter("uid");
        JournalService journalService = new JournalServiceImpl();
        journalService.addJournal(pid, uid);
        ProductService productService = new ProductServiceImpl();
        Product product = productService.findProductByPid(pid);
        request.setAttribute("product", product);
        return "forward:/goodsDetail.jsp";
    }

    public String search(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String pname = request.getParameter("sear");
        ProductService productService = new ProductServiceImpl();
        List<Product> productList = productService.findProductByPname(pname);
        if(productList.isEmpty()) {
            System.out.println("没有该商品.......");
            return "forward:/index.jsp";
        }
        else {
            request.setAttribute("listProduct", productList);
            return "forward:/goodsList.jsp";
        }
    }

    public String manage(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ProductService productService = new ProductServiceImpl();
        List<Product> productList = productService.findAll();
        if(productList.isEmpty()) {
            System.out.println("没有任何商品.......");
            return "forward:/index.jsp";
        }
        else {
            request.setAttribute("productList", productList);
            return "forward:/catalogue.jsp";
        }
    }

    public String delete(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String pid = request.getParameter("pid");
        ProductService productService = new ProductServiceImpl();
        productService.deleteProduct(pid);
        return "forward:/product?method=manage";
    }

    public String modify(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String pid = request.getParameter("pid");
        ProductService productService = new ProductServiceImpl();
        Product product = productService.findProductByPid(pid);
        request.setAttribute("product", product);
        return "forward:/catalogue_modify.jsp";
    }

    public String modifyProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String tname = request.getParameter("tname");
        TypeService typeService = new TypeServiceImpl();
        int tid = typeService.findtid(tname);
        if(tid == 0) {
            System.out.println("没有这个类别.......");
            return "forward:/product?method=manage";
        }
        String pid = request.getParameter("pid");
        String pname = request.getParameter("pname");
        String ptime = request.getParameter("ptime");
        String pimage = request.getParameter("pimage");
        String pprice = request.getParameter("pprice");
        String pstate = request.getParameter("pstate");
        String pinfo = request.getParameter("pinfo");
        ProductService productService = new ProductServiceImpl();
        productService.modifyProduct(pid, tid, pname, ptime, pimage, pprice, pstate, pinfo);
        return "forward:/product?method=manage";
    }

    public String add(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String tname = request.getParameter("tname");
        TypeService typeService = new TypeServiceImpl();
        int tid = typeService.findtid(tname);
        if(tid == 0) {
            System.out.println("没有这个类别.......");
            return "forward:/product?method=manage";
        }
        String pname = request.getParameter("pname");
        String pimage = request.getParameter("pimage");
        String pprice = request.getParameter("pprice");
        String pinfo = request.getParameter("pinfo");
        ProductService productService = new ProductServiceImpl();
        productService.addProduct(tid, pname, pimage, pprice, pinfo);
        return "forward:/product?method=manage";
    }
}
