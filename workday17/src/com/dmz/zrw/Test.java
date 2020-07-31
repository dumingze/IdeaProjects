package com.dmz.zrw;

public class Test {
    static int count=0;
    public static void main(String[] args) {
        String bigString="woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun";
        String smallString="java";
        System.out.println(countSmallStringInBigString(bigString, smallString, 0));

    }

    public static int countSmallStringInBigString(String bigString,String smallString,int index){
//int indexOf(String str,int fromIndex)
// 指定，从当前字符串对象的指定位置开始，查找首次出现的指定字符串的位置(如果没找到返回-1)

        index=bigString.indexOf(smallString,index);
        if (index ==-1){
            return 0;

        }

        return countSmallStringInBigString(bigString, smallString,index+1) + 1;
    }

}
