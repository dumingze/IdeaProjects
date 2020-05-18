package com.dmz.zz;

public class Student {
    int id;
    String name;
    String gender;
    int age;
    double java;

    public Student(int id, String name, String gender, int age, double java) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.java = java;
    }
    public void print(){
        System.out.println( "id："+this.id+" 名字："+this.name+" 性别:"+ this.gender+" 年龄："+ this.age +" java成绩"+this.java);
    }
}
