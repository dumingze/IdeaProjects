package com.dmz.extra;

public class Extra1 {

    public static void main(String[] args) {
        Sub sub = new Sub();
    }
}

class Base {
    static {
        System.out.println("base static");
    }

    {
        System.out.println("base的构造代码块");
    }

    public Base() {
        System.out.println("base的构造函数");
    }
}

class Sub extends Base {
    static {
        System.out.println("sub static");
    }

    {
        System.out.println("sub的构造代码块");
    }

    public Sub() {
        System.out.println("sub的构造函数");
    }
}
