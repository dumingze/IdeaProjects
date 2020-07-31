package com.dmz.zrw.work3;



import com.dmz.zrw.work3.bean.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //如何区分我点击的不同商品呢？
        //   localhost/detail?id=1/2/3/4
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        //使用队列维护一个长度为10 的队列，先进先出,因为移动比较多，这里选择的是链表
        //实现LRU算法
        LinkedList<String> showlist= (LinkedList<String>) request.getSession().getAttribute("showlist");

        if (showlist==null){
            showlist=new LinkedList<>();
        }
/*
        if (showlist.size()<5&&!showlist.contains(id)){
            showlist.offer(id);
       */
/*     System.out.println(showlist);
            System.out.println(showlist.size());*//*

        }
        else {
            showlist.poll();
        }
*/
        if(showlist.contains(id)){
            showlist.remove(id);
            showlist.offer(id);
        }
        else {
            showlist.offer(id);
        }

        if (showlist.size()>5){
            showlist.poll();
        }

        request.getSession().setAttribute("showlist",showlist);

        try {
            //判断id值是否合法，前端请求，任意伪造的
            Integer.parseInt(id);
        }catch (Exception e){
            response.getWriter().println("输入的参数不合法！！！！");
            return;
        }
        List<Product> products = (List<Product>) getServletContext().getAttribute("products");
        response.getWriter().println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>");
        for (Product product : products) {
            if(Integer.parseInt(id) == product.getId()){
                response.getWriter().println(product);
            }
        }
        String addCart = response.encodeURL(request.getContextPath() + "/addCart?id=" + id);
        String viewCart = response.encodeURL(request.getContextPath() + "/viewCart");
        String index = response.encodeURL(request.getContextPath() + "/index");

        response.getWriter().println("<div><a href='" + addCart + "'>加入购物车</a></div>");
        response.getWriter().println("<div><a href='"  + viewCart + "'>查看购物车</a></div>");
        response.getWriter().println("<div><a href='" + index + "'>返回首页</a></div>");

        //对历史的浏览记录进行展示
        response.getWriter().print("<div>历史浏览商品，最多展示5条,且不会重复展示</div>");
        List<Product> productList = (List<Product>) getServletContext().getAttribute("products");
        LinkedList<String> simpleShowList = (LinkedList<String>) request.getSession().getAttribute("showlist");
/*        for (String str_productid :simpleShowList) {
            for (Product show_product:productList){
                if (Integer.parseInt(str_productid) == show_product.getId()){
                    response.getWriter().println("<div>--------------------------</div>");
                    response.getWriter().println(show_product);
                    System.out.println(show_product);
                    response.getWriter().println("<div>--------------------------</div>");
                    response.getWriter().println("<div><a href='" + request.getContextPath() + "/record'>查看浏览记录</a ></div>");
                }
            }
        }*/

// 从后往前展示
        for (int i = simpleShowList.size(); i >0 ; i--) {
            for (Product show_product:productList){
                if (Integer.parseInt(simpleShowList.get(i-1)) == show_product.getId()){
                    response.getWriter().println("<div>--------------------------</div>");
                    response.getWriter().println(show_product);
                    System.out.println(show_product);
                    response.getWriter().println("<div>--------------------------</div>");

                }
            }

        }

        response.getWriter().println("</body>\n" +
                "</html>");
    }
}
