package com.dmz.zrw;

import com.dmz.bean.User;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/view")
public class ViewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        User user = (User) getServletContext().getAttribute("userinfo");
        System.out.println(user.getHobby());
        response.getWriter().println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>");
        response.getWriter().println("<div>" + user.getUsername() + "</div>");
        response.getWriter().println("<div>" + user.getPassword() + "</div>");
        response.getWriter().println("<div>" + user.getGender() + "</div>");
        response.getWriter().println("<div>" + Arrays.toString(user.getHobby()) + "</div>");
        response.getWriter().println("<div>" + user.getDescription() + "</div>");

        response.getWriter().println("<img src='" +request.getContextPath() + "/" + user.getHeadimage() + "'>");

        System.out.println(request.getServletContext().getRealPath(""));
        response.getWriter().println("</body>\n" +
                "</html>");



}
}
