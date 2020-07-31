package com.dmz.zrw;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/")
public class DefaultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


       // response.setHeader("content-type","text/html;charset=utf-8");
        String path=request.getServletPath();
       System.out.println("getServletPath"+path);

/*        String realPath1 = getServletContext().getRealPath("");
        System.out.println("realPath1"+realPath1);*/
        String realPath = getServletContext().getRealPath(path);
        //判断是否请求了会含有中文的资源
        if (realPath.contains(".html")||realPath.contains(".jsp")){
            response.setHeader("content-type","text/html;charset=utf-8");
        }
         System.out.println("getRealPath"+realPath);
        File file=new File(realPath);
        System.out.println(realPath);
        System.out.println("文件是否存在"+file.exists());
        if (!file.exists()){
            response.setStatus(404);
            response.getWriter().println("<h1 style='color:red'>File Not Found</h1>");
        }

        FileInputStream inputStream = new FileInputStream(file);
        //还需要有一个outputStream
        ServletOutputStream outputStream = response.getOutputStream();
        //和下面的我们熟悉的FileOutputStream是兄弟关系
        //FileOutputStream
        int length = 0;
        byte[] bytes = new byte[1024];
        while ((length = inputStream.read(bytes)) != -1){
            outputStream.write(bytes, 0, length);
        }
        outputStream.flush();
        //关闭流信息
        //其中servletOutputStream可以不关，响应结束之前tomcat会帮我们关闭
        inputStream.close();
    }
}
