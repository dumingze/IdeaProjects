package com.dmz.zrw;

import java.util.Arrays;

public class Work3 {
    public static void main(String[] args) {
        String s="cbabcdddd";
        String maxPlalindrome=maxPlalindrome(s);
        System.out.println(maxPlalindrome);

    }
    public static String maxPlalindrome(String string){
        char[] chars=string.toCharArray();
        int i;
        int j;
        String maxPlalindrome="";
        for ( i = 0; i <chars.length ; i++) {
            for ( j= i+1; j <chars.length ; j++) {
                String tempSting=string.substring(i,j+1);
                if (Work1.isPlalindrome(tempSting)){
                    if (tempSting.length()>maxPlalindrome.length()){
                    maxPlalindrome=tempSting;
                }
            }
        }
    }
        return maxPlalindrome;
    }

}
