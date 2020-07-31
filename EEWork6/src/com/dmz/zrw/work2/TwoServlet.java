package com.dmz.zrw.work2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TwoServlet")
public class TwoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        String name = (String) request.getSession().getAttribute("name");
        response.getWriter().print("getSession:"+name);

    /*    response.getWriter().print("-----------------------------------");
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                if("name".equals(cookie.getName())){
                    response.getWriter().println("cookie" + cookie.getValue());
                }
            }
        }*/


    }
}
