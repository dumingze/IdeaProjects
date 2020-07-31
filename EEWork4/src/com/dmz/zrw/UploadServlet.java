package com.dmz.zrw;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //判断当前请求内是否有multipart/form-data数据

        System.out.println(getServletContext().getRealPath(""));

        response.setContentType("text/html;charset=utf-8");
        boolean multipartContent = ServletFileUpload.isMultipartContent(request);
        if(!multipartContent){
            response.getWriter().println("当前请求不包含文件上传功能，无法使用");
            return;
        }
        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Configure a repository (to ensure a secure temp location is used)
        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        //设置一个缓存仓库，如果文件很大，那么就边缓存边上传
        factory.setRepository(repository);
        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        //设置上传的文件名中文乱码问题
        upload.setHeaderEncoding("utf-8");
        // bytes
        //upload.setFileSizeMax(1024);

        // Parse the request
        try {
            List<FileItem> items = upload.parseRequest(request);
            Iterator<FileItem> iterator = items.iterator();
            while (iterator.hasNext()){
                FileItem fileItem = iterator.next();
                if(fileItem.isFormField()){
                    //是一个常规的form表单数据
                    processFormField(fileItem);
                }else {
                    //上传的文件
                    processUploadedFile(fileItem);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    private void processUploadedFile(FileItem fileItem) {
        String fieldName = fileItem.getFieldName();//getFieldName对应标签里的name
        String fileName = fileItem.getName();//获取文件的名字
        System.out.println("field:" + fieldName);//就是标签的name属性
        System.out.println("上传文件名称:" + fileName);//你上传的文件的名称
        String uploadPath = getServletContext().getRealPath("upload/");
        File file = new File(uploadPath  + fileName);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        try {
            fileItem.write(file);//write 这个方法是这个第三方库提供的
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 普通的form表单数据，name属性以及对应的值
     * @param fileItem
     */
    private void processFormField(FileItem fileItem) {
        String fieldName = fileItem.getFieldName();//getFieldName对应标签里的name
        String value = null;
        try {
            value = fileItem.getString("utf-8");//getString 获取的是标签对应的value 也就是值 （utf-8）设置字符集
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(fieldName + ":" + value);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
