package com.dmz.zrw;

import com.dmz.zrw.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Enumeration;

@WebServlet("/submitServlet")
public class submitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        Class userClass= User.class;
        User user=new User();


        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()){
            //每次迭代出来的key值是不同的
            String key = names.nextElement();
            String keyUp=key.toUpperCase();

            String substring1 = keyUp.substring(0,1);

            String substring2= keyUp.substring(1,keyUp.length());

            String spillMethod="set"+substring1+substring2.toLowerCase();

            Method getMethod=null;
            try {
                if ("hobby".equals(key)) {
                getMethod=userClass
                            .getDeclaredMethod(spillMethod, String[].class);

                    getMethod.setAccessible(true);
                    String[] values = request.getParameterValues(key);
                    System.out.println("hobby "+ values);
                    try {
                        getMethod.invoke(user,new Object[]{values});
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }

                else { getMethod=userClass.getDeclaredMethod(spillMethod,String.class);
                    getMethod.setAccessible(true);
                    String[] values = request.getParameterValues(key);
                    // System.out.println(key + " :" + values[0]);
                    try {
                        getMethod.invoke(user,values[0]);

                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

    }


        System.out.println(user.toString());
    }
}
