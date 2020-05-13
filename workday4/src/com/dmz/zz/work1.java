package com.dmz.zz;

import java.util.Scanner;

public class work1 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入星期几");
        int x=scanner.nextInt();
        switch (x){
            case 1:
                System.out.println("星期一");break;
            case 2:
                System.out.println("星期二");break;
            case 3:
                System.out.println("星期三");break;
            case 4:
                System.out.println("星期四");break;
            case 5:
                System.out.println("星期五");break;
            case 6:
                System.out.println("星期六");break;
           default:
               System.out.println("星期天");

        }
    }
}
