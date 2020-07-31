package com.dmz.DuoTai;

public class Test {

    public static void main(String[] args) {
        Student student=new Student();
        System.out.println(student.stuid);

    }


}
class Person{
    String name;
    int age;
    int hight;

    public Person() {
        System.out.println("父类中无参构造方法");
    }

    public Person(String name, int i, int hight) {
        this.name = name;
        this.age = i;
        this.hight = hight;
    }

    public void eat(){
        System.out.println("人会吃饭");
    }
}
class Student extends Person{
    int stuid;



    public void study(){
        System.out.println("学生学习");
    }

}