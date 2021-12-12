package com.shop.myshop.controller;

import com.shop.myshop.entity.Journal;
import com.shop.myshop.service.JournalService;
import com.shop.myshop.service.impl.JournalServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/journal")
public class JournalController extends BaseServlet {

    public String show(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        JournalService journalService = new JournalServiceImpl();
        List<Journal> journalList = journalService.findAll();
        request.setAttribute("journalList", journalList);
        return "forward:/journalList.jsp";
    }
}
