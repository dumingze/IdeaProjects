package com.dmz.another;

import com.dmz.test.FatherClass;

public class anotherTest extends FatherClass {

    public static void main(String[] args){
        int x;



        anotherTest anotherTest=new anotherTest();
        System.out.println(anotherTest.age);

    }
    public void say111(){
        System.out.println(age);
    }



    @Override
    public void say() {
        super.say();
    }
}
