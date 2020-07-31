package com.dmz.zrw;

import java.util.Scanner;

public class Work1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String string=scanner.nextLine();
        boolean bool=isPlalindrome(string);
        System.out.println(bool);
    }
    public static boolean isPlalindrome(String s){
        char[] chars=s.toCharArray();
        for (int i = 0; i <chars.length/2 ; i++) {
            if (chars[i]!=chars[chars.length-1-i]){
                return false;
            }

        }
        return true;
    }
}
