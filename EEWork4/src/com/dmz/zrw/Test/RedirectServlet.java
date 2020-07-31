package com.dmz.zrw.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setStatus(302);
//        //地址的写法：3种写法均可以，给浏览器看的
//        response.setHeader("Location","http://www.cskaoyan.com");

        //response还给我们提供了一个简化版的API
        response.sendRedirect("1.html");
    }
}
