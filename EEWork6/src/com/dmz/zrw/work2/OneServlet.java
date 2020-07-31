package com.dmz.zrw.work2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/OneServlet")
public class OneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        HttpSession session = request.getSession();
        session.setAttribute("name","杜明泽");
        String id = session.getId();


        Cookie cookie1=new Cookie("JSESSIONID",id);
        cookie1.setMaxAge(300);
        response.addCookie(cookie1);

       /* Cookie cookie = new Cookie("name", "杜明泽");
        cookie.setMaxAge(300);
        response.addCookie(cookie);*/

    }
}
