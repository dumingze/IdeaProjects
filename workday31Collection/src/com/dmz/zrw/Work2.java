package com.dmz.zrw;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Work2 {
 /*   2. 用Collection存储自定义对象(Student)，并遍历。删除名字是"张三"的学生。*/

    public static void main(String[] args) {
        Collection<Student> collection=new ArrayList<Student>();
        for (int i = 0; i <3 ; i++) {
            collection.add(new Student("dmz",22));
            collection.add(new Student("dmz",22));
            collection.add(new Student("zrw",23));


        }

        System.out.println("删除前：");
        System.out.println(collection);

//1. 用迭代器对集合遍历的时候，不要使用集合的API对集合进行修改,
//   Exception in thread "main" java.util.ConcurrentModificationException
/*        for (Student student:collection){//应该是foreach的底层是iteartor吧
            if (student.getName()=="dmz"){
                collection.remove(student);
            }

        }*/

        System.out.println("删除后：");

        Iterator<Student> iterator=collection.iterator();
        while (iterator.hasNext()){
            Student student=iterator.next();
            if (student.getName()=="dmz"){
                iterator.remove();
            }
        }

        System.out.println(collection);
    }
}
