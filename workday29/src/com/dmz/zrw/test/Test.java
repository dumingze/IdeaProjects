package com.dmz.zrw.test;

public class Test {
    public static void main(String[] args) {
        System.out.println("11111");
        Father father = new Son(1000);
    }
}
class Father {
    int i = 10;
    public Father() {
        System.out.println(getI());
    }
    public int getI() {
        return i;
    }
}
class Son extends Father {
    int i = 100;
    public Son(int i) {
        this.i = i;
    }
    public int getI() {
        return i;
    }
}