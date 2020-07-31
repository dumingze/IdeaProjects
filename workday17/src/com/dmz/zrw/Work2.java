package com.dmz.zrw;

public class Work2 {

    public static void main(String[] args) {
        int count = 0;
        String bigString = "woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun";
        String smallString = "java";
        count = countSmallStringInBigString(bigString, smallString, 0);
        System.out.println(count);
    }

    public static int countSmallStringInBigString(String bigString, String smallString, int index) {
//int indexOf(String str,int fromIndex)
// 指定，从当前字符串对象的指定位置开始，查找首次出现的指定字符串的位置(如果没找到返回-1)
        int count = 0;
        index = bigString.indexOf(smallString, index);
        while (index != -1) {
            count++;
            index=bigString.indexOf(smallString, index + 1);

        }
        return count;
    }

}
