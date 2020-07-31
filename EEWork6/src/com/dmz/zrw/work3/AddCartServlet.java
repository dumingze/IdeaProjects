package com.dmz.zrw.work3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addCart")
public class AddCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //加入购物车的是哪个商品
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        try {
            Integer.parseInt(id);
        }catch (Exception e){
            response.getWriter().println("输入的参数不合法！！！！");
            return;
        }
        HttpSession session = request.getSession();
        // 为什么不能set----每次都会把前面的覆盖
        //session.setAttribute();
        //要先get，然后再set   1,2,1 String     1 2 3 1 List     1 2 3 Set
        List<String> cart = (List<String>) session.getAttribute("cart");
        if(cart == null){
            cart = new ArrayList<>();
        }
        cart.add(id);
        session.setAttribute("cart", cart);
        response.getWriter().println("添加购物车成功，返回首页继续选购吧.....");
        String index = response.encodeURL(request.getContextPath() + "/index");
        response.setHeader("refresh","1;url=" + index);
    }
}
