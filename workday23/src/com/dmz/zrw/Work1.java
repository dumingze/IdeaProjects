package com.dmz.zrw;

import java.util.Scanner;

public class Work1 {
    /*1. 自己利用线程的第一种实现方式，实现如下功能(多线程引例)：

            a. 程序不停地在屏幕上输出一句问候的语句(比如“你好”)
            (时间间隔一定要大些比如3s(或大于3s)，因为在控制台窗口，输入和输出不能同时发生，
    我们只能在两次输出“你好”的间隙，从键盘输入数据，才能保证键盘输入被正确接收)

    b.同时，当我通过键盘输入固定响应的时候，程序停止向屏幕输出问候的语句*/

    static boolean flag=true;
    public static void main(String[] args) {
        outPutNiHao();
        stopOutput();

    }

    public static void outPutNiHao(){
        new Thread(){
            @Override
            public void run() {

                while (flag){
                    System.out.println("你好");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public static void stopOutput(){
        new Thread(){
            @Override
            public void run() {
                while (true){
                    Scanner scanner=new Scanner(System.in);
                    String s=scanner.nextLine();
                    if (s.equals("你好")){
                        flag=false;
                        scanner.close();
                        break;
                    }
                }

            }
        }.start();
    }

}
