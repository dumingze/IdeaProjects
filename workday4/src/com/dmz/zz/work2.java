package com.dmz.zz;

import java.util.Scanner;
public class work2 {
    public static void main(String [] args) {
        System.out.println("请出入一串数字");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        char[] a = string.toCharArray();
        //判断是不是回文字符串的标志位
        boolean ishuiwen=true;
        scanner.close();
        for(int i=0;i<=(a.length)/2;i++){
            if (a[i]!=a[a.length-1-i]){
                System.out.println("不是回文字符串");
                ishuiwen=false;
                break;
            }
        }
        if (ishuiwen){
            System.out.println(string+"是回文字符串");
        }
    }
}
