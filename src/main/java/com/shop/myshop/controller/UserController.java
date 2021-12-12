package com.shop.myshop.controller;

import com.shop.myshop.entity.User;
import com.shop.myshop.service.UserService;
import com.shop.myshop.service.impl.UserServiceImpl;
import com.shop.myshop.utils.RandomUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;

/**
 * 用户模块的controller
 */
@WebServlet("/user")
public class UserController extends BaseServlet{

    public String check(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        //1、获取用户名
        String username = request.getParameter("username");

        if(username == null) {
            return "1";    //不能注册
        }
        //2、调用业务逻辑判断用户名是否存在
        UserService userService = new UserServiceImpl();
        boolean b = userService.checkedUser(username);

        //3、响应字符串   1存在  0不存在
        if(b) {
            //用户存在
            return "1";
        }
        return "0";
    }

    public String register(HttpServletRequest request, HttpServletResponse response) {
        String password = request.getParameter("password");
        String psw = request.getParameter("psw");
        if(!password.equals(psw)) {
            request.setAttribute("msg", "两次密码输入不相同，请重新输入！");
            return "forward:/register.jsp";
        }
        User user = new User();
        user.setUname(request.getParameter("username"));
        user.setUpassword(request.getParameter("password"));
        user.setUemail(request.getParameter("email"));
        user.setUsex(request.getParameter("sex"));
        //2、完善用户信息
        //已经赋值：  用户名 密码 邮箱 性别
        //未赋值：   激活状态 账号类型 激活码
        user.setUstatus(0);     //未激活状态0   已激活1
        user.setUrole(0);      //普通客户0     管理员1
        user.setUcode(RandomUtils.createActive());
        //3、调用用户的业务逻辑进行注册
        UserService userService = new UserServiceImpl();
        try {
            userService.registerUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            return "forward:/register.jsp";
        }

        //4、响应
        return "forward:/registerSuccess.html";
    }

    /**
     * 激活方法
     * @param request
     * @param response
     * @return
     */
    public String activate(HttpServletRequest request,HttpServletResponse response) throws SQLException {
        //1、获取激活码
        String code = request.getParameter("c");
        //2、调用激活的业务逻辑
        UserService userService = new UserServiceImpl();
        int i = userService.activateUser(code);
        //3、响应（激活失败（ucode没有找到）  激活成功    已经激活了）
        if(i == 0) {
            request.setAttribute("msg", "激活失败！");
            request.setAttribute("url", "index.jsp");
            request.setAttribute("gg", "重新激活");
        }else if(i == 1) {
            request.setAttribute("msg", "激活成功，请登录！");
            request.setAttribute("url", "login.jsp");
            request.setAttribute("gg", "现在登录");
        }else {
            request.setAttribute("msg", "已经激活，请直接登录！");
            request.setAttribute("url", "login.jsp");
            request.setAttribute("gg", "现在登录");
        }
        return "forward:/activate.jsp";
    }

    /**
     * 1、前端提交账号密码
     * 2、对比账号密码
     *    失败：回到登陆页面，进行提示
     *    成功：未激活  回到登陆页面并进行提示
     *         已激活  程序的首页  将用户放入session共享域
     */

    public String login(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        //1、获取请求参数（用户名，密码）
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //2、调用业务逻辑判断账号密码
        UserService userService = new UserServiceImpl();
        User user = userService.login(username, password);
        //3、响应
        //user 等于null证明账号或者密码错误
        //user 不为null 但是user还没激活

        if(user == null) {
            request.setAttribute("msg", "账号或者密码错误！");
            return "forward:/login.jsp";
        }

        if(user.getUstatus() == 0) {
            request.setAttribute("msg", "账号未激活！");
            return "forward:/login.jsp";
        }

        HttpSession session = request.getSession();
        session.setAttribute("loginUser", user);
        return "redirect:/myshop/index.jsp";
    }

    /**
     * 注销登录，并跳转到登录页面！
     * @param request
     * @param response
     * @return
     */
    public String logOut(HttpServletRequest request, HttpServletResponse response) {
        //1、清空session中的用户数据
        HttpSession session = request.getSession();
        session.removeAttribute("loginUser");

        //2、转发到登录页面
        request.setAttribute("msg", "注销登录成功！");
        return "forward:/login.jsp";
    }
}
