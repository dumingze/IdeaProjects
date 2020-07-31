package com.dmz.zrw;

import com.dmz.bean.User;
import com.dmz.utils.FileUploadUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/submitServlet")
public class SubmitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        Map<String, Object> usermap = FileUploadUtils.parseRequest(request);
        User user = new User();
        try {
            BeanUtils.populate(user,usermap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        getServletContext().setAttribute("userinfo",user);
        response.getWriter().print("跳转到数据展示页面");
        response.setHeader("refresh","2;url="+request.getContextPath()+"/view");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}
