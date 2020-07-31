package com.dmz.zrw;

import java.lang.reflect.Field;

public class Work1 {



    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Student student=new Student("dumingze");
        System.out.println(student);
        setAll(student,"name","zrw");
        System.out.println(student);

    }


    /**
     *
     * @param targetObj  要修改成员变量值的目标对象
     * @param fieldName  对象中要修改的成员变量的名字
     * @param newValue   要修改成员变量值的新值
     */
    public static void setAll(Object targetObj, String fieldName, Object newValue) throws NoSuchFieldException, IllegalAccessException {

        Class objClass = targetObj.getClass();
        Field field = objClass.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(targetObj,newValue);


    }

}
class  Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
