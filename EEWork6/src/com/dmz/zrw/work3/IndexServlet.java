package com.dmz.zrw.work3;



import com.dmz.zrw.work3.bean.Product;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@WebServlet(value = "/index",loadOnStartup = 1)
public class IndexServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        //初始化一些数据参数  商品信息
        List<Product> products = new LinkedList<>();
        products.add(new Product(1,"P10"));
        products.add(new Product(2, "P20"));
        products.add(new Product(3, "P30"));
        products.add(new Product(4, "P40"));
        products.add(new Product(5,"P50"));
        products.add(new Product(6,"P60"));
        products.add(new Product(7,"P70"));
        products.add(new Product(8,"P80"));
        products.add(new Product(9,"P90"));
        products.add(new Product(10,"P100"));

        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("products", products);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //JDBC----数据库查询拿到数据
        List<Product> products = (List<Product>) getServletContext().getAttribute("products");
        for (Product product : products) {
            String detail = response.encodeURL(request.getContextPath() + "/detail?id=" + product.getId());
            response.getWriter().println("<div><a href='" + detail + "'>" + product.getName() + "</a></div>");
        }
    }
}
