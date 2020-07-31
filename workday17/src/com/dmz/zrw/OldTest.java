package com.dmz.zrw;

public class OldTest {

    //方式一，静态变量存储在方法区中，利用静态变量的话，不会因为方法的栈帧释放或者分配而影响值
    static int count = 0;

    public static void main(String[] args) {
        String bigString = "woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun";
        String smallString = "java";
        //方式二
        int x = countSmallStringInBigString(bigString, smallString, 0);
        System.out.println(count);
        System.out.println(x);

    }

    public static int countSmallStringInBigString(String bigString, String smallString, int index) {
//int indexOf(String str,int fromIndex)
// 指定，从当前字符串对象的指定位置开始，查找首次出现的指定字符串的位置(如果没找到返回-1)

        index = bigString.indexOf(smallString, index);
        if (index == -1) {
            return 0;

        }
        count++;
        return countSmallStringInBigString(bigString, smallString, index + 1) + 1;
    }


}
