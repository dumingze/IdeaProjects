package com.dmz.Test;

public class Student extends Person {

    private int studentId;
    private  String name;


    public void study(){
        System.out.println(getName()+"正在学习");
        System.out.println(name+"正在学习");
    }

    public Student(String name, int high, int studentId) {
        this.studentId = studentId;
       this.name=name;

    }

    public Student() {

    }

    public static void main(String[] args) {
        Student student=new Student("杜明泽",180,1);
        student.study();

    }

}
