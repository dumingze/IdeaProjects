package com.dmz.zrw;

public class Work2 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println();

                System.out.println("Runnable匿名子类的run方法");
            }
        }) {
            @Override
            public void run() {
                System.out.println("Thread匿名子类的run方法");
            }
        }.start();



        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        }).start();


        new Thread(){
            @Override
            public void run() {
                System.out.println("你好");
            }
        }.start();
    }
}
