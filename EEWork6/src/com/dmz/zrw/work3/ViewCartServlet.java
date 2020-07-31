package com.dmz.zrw.work3;



import com.dmz.zrw.work3.bean.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewCart")
public class ViewCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //直接从session里面取出数据即可
        HttpSession session = request.getSession();
        // 存的是商品的id值  商品信息显示出来
        List<String> cart = (List<String>) session.getAttribute("cart");
        List<Product> products = (List<Product>) getServletContext().getAttribute("products");
        if(cart == null){
            response.getWriter().println("当前购物车为空，先去选购吧....");
            response.setHeader("refresh","1;url=" + request.getContextPath() + "/index");
            return;
        }
        for (String s : cart) {
            for (Product product : products) {
                if(Integer.parseInt(s) == product.getId()){
                    response.getWriter().println(product);
                }
            }
        }
    }
}
