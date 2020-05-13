package com.dmz.zz;

public class homework1 {
    public static void main(String[] args){
        int a=0x00000001;//＋1
        int b=0xffffffff;//-1
        System.out.println(jueduizhi(a));
        System.out.println(jueduizhi(b));
    }
    //先说负数：负数在计算机里以补码的形式存在，负数的补码与其绝对值的关系为：
    //负数的补码－1，再取反，就是其绝对值。
    //对一个负数来说，－1操作通过＋1111.........1111实现
    //取反操作通过^1111.......11实现
    //而11........1111通过   >> 31得到

    //对一个正数来，>> 31为000000.......0000
    //该正数＋000000000后，再^000000......00000仍为其本身
    public static int jueduizhi(int x){
        x= (x + (x >> 31)) ^ (x >> 31) ;
        return x;
    }
}
