package com.dmz.zrw;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Work2 {
  /*  2.  完成如下方法，要求该方法能调用，指定配置文件中，指定类中指定的普通成员方法(无参方法)*/
    public static void main(String[] args) throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {

        callTargetMethod("config.properties");
    }

    /**
     *
     * @param configFilePath  表示配置文件的路径
     */

    public static void  callTargetMethod(String configFilePath) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        //1. 读取配置文件信息，将去读取到我们的Properties对象中

        //2. 从Properties对象中，获取指定类的全类名和指定的方法名
        String className = getValue(configFilePath,"className");
        String methodName =getValue(configFilePath,"methodName");

        //3. 通过全类名，获取全类名所指定的类的，类型信息(通过访问其对应Class)
        Class targetClass =  Class.forName(className);

        //4. 利用反射，targetClass中获取，目标方法(Method对象)
        Method method=targetClass.getDeclaredMethod("testPrivateMethod");
        method.setAccessible(true);

        //5. 利用反射，创建目标对象  Constructor对象.newInstance()
        Constructor constructor=targetClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Test test=(Test) constructor.newInstance();
        //6. Method对象.invoke(目标对象)
        method.invoke(test);

    }

    public static String getValue(String configFilePath,String propertyName) throws IOException {

        FileInputStream fis = new FileInputStream(configFilePath);
        Properties properties = new Properties();
        properties.load(fis);
        String propertyValue = properties.getProperty(propertyName);
        return propertyValue;

    }



}
class Test{

    public Test() {
    }

    private void testPrivateMethod(){
        System.out.println("测试成功");
    }
}
