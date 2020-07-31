package com.dmz.zrw;

import com.dmz.zrw.Bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Bservlet")
public class Bservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        User userInfo = (User) request.getAttribute("userInfo");
        System.out.println("Bservlet"+userInfo.toString());
        System.out.println(request.getParameter("username").equals(userInfo.getUsername()));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
