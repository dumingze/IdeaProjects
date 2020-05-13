package com.dmz.zrw;

import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        int[]array={1,2,3,4,5};
        System.out.println(Arrays.toString(array));

        //预期输出是：0，0，33，0，0  为什么呢
        changArray(array);
        System.out.println(Arrays.toString(array));
    }

    public static void changArray(int[] array){
        int[]b=new int[array.length];
        b[2]=33;
        array=b;//array在这个方法里不是的重新指向b了吗
    }
}
