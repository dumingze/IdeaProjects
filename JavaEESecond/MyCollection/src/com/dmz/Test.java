package com.dmz;

public class Test {
    int i;//成员变量不赋值也没事，int当0使用就好了
    boolean flag=true;
    String string;
    public static void main(String[] args) {

        Test test=new Test();
        test.say();
    }

    void say(){
        i++;
        System.out.println(i);
        System.out.println(string);
        if (flag){
            System.out.println("111111");
        }
    }

}

