package com.dmz.extra;

public class Extra2 {
    Obj2 obj2=new Obj2();

    public Extra2() {
        System.out.println("obj3");
    }

    public static void main(String[] args) {
        Extra2 extra2=new Extra2();
    }
}
class Obj2{
    public Obj2() {
        System.out.println("obj2");
    }
}
class Obj1{
    Obj2 obj2=new Obj2();
    public Obj1() {
        System.out.println("obj1");
    }
}
