package com.shop.myshop.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String md = req.getParameter("method");

        if(md == null || md.equals("")) {
            md = "index";
        }

        //1、获取类的class对象
        Class clazz = this.getClass();
        //2、获取方法
        /**
         * 参数1：方法名
         * 参数2：方法参数的类型
         */
        try {
            Method method = clazz.getMethod(md, HttpServletRequest.class, HttpServletResponse.class);
            //3、执行方法
            /**
             * 参数1：要执行方法的对象
             * 参数2：执行方法要传入的参数
             * 返回值：执行方法的返回值。 如果方法返回void，则返回值为null
             */

            Object result = method.invoke(this, req, resp);

            if (result != null) {
                //转发、重定向、返回字符
                String str = (String)result;

                if(str.startsWith("forward:")) {
                    //转发
                    //forward:/xxx/xxx
                    String path = str.substring(str.indexOf(":") + 1);
                    req.getRequestDispatcher(path).forward(req,resp);
                }else if(str.startsWith("redirect:")) {
                    //重定向
                    String path = str.substring(str.indexOf(":") + 1);
                    resp.sendRedirect(path);
                }else {
                    resp.getWriter().println(str);
                }
            }
        } catch (Exception e) {
            //没有反射方法
            e.printStackTrace();
        }
    }

    public String index(HttpServletRequest req, HttpServletResponse resp) {
        return "forward:/index.jsp";
    }
}
