package com.dmz.zrw;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/WorkServlet2")
public class WorkServlet2 extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("init");
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("service调用");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
