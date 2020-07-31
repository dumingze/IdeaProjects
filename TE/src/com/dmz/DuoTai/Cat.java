package com.dmz.DuoTai;

public class Cat extends Animal {

    String name;

    public Cat(String name) {
        //默认调用父类中无参的构造方法
        this.name = name;
    }

    public Cat(String name, String name1) {
        super(name);//这种的话，会调用父类一参的构造方法，不会执行父类中无参的构造方法
        this.name = name1;
    }

    public static void main(String[] args) {
        Cat cat=new Cat("动物","猫咪");
        System.out.println(cat.name);
        cat.testSuper();

    }

    public void testSuper(){
        System.out.println(super.name);
        super.shout();
    }



}
