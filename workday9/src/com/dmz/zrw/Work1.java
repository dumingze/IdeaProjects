package com.dmz.zrw;

public class Work1 {
    public static void main(String[] args){

      Student  stu1=new Student("张三",18,true, 1);
      Student  stu2=new Student("李四",23,false, 2);
      stu1.print();
      stu2.print();
      MyStudent mt=new MyStudent();
      mt.print();

    }

}
 class Student {
    String name;
    int age;
    boolean isMale;
    int sno;

    public Student() {

    }

    public Student(String name) {
        this.name=name;

    }

    public Student(String name, int sno) {
        this.name = name;
        this.sno = sno;
    }

    public Student(String name, int age, boolean isMale) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
    }

    public Student(String name, int age, boolean isMale, int sno) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
        this.sno = sno;
    }

     public void print() {

         System.out.println(name + "---" + age + "---" + (isMale ? "男" : "女") + "---" + sno);
     }
}

class MyStudent {
    String name;
    int age;
    boolean isMale;
    int sno;

    public MyStudent() {
        //麻花疼---100---男---1000
        this.name="麻花疼";
        this.age=100;
        this.isMale=true;
        this.sno=1000;

    }

    public MyStudent(String name) {
        this.name=name;

    }

    public MyStudent(String name, int sno) {
        this.name = name;
        this.sno = sno;
    }

    public MyStudent(String name, int age, boolean isMale) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
    }

    public MyStudent(String name, int age, boolean isMale, int sno) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
        this.sno = sno;
    }

    public void print() {

        System.out.println(name + "---" + age + "---" + (isMale ? "男" : "女") + "---" + sno);
    }
}
