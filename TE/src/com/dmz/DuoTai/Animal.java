package com.dmz.DuoTai;

public class Animal {

    public String name;
    public void shout(){
        System.out.println("动物叫");
    }
    public Animal() {
        System.out.println("默认调用父类无参的构造方法");
        this.name = "动物";
    }

    public Animal(String name) {
        System.out.println("一参额构造方法");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
