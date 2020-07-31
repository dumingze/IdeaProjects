package com.dmz.zrw;

import java.util.Objects;

public class Student {
    private String name;
    private  int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void say(){
        System.out.println("我是一个学生");
    }

    @Override
    public boolean equals(Object o) {
        //同一个对象肯定相等
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        //不是同一个对象，则判断属性值相同
        return age == student.age &&
                Objects.equals(name, student.name);//这里，String直接判断的是常量池的地址？
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
