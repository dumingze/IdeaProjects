package com.dmz.zrw.test;

public class Bground extends Thread{

    public static void main(String[] args){
        Bground bground=new Bground();
        bground.run();
    }
    public void start(){
        for (int i = 0; i < 10; i++) {
            System.out.println("B ground.start()"+i);
        }
    }
}
