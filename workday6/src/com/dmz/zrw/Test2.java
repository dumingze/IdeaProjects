package com.dmz.zrw;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args){
        int[]array={1,2,3,4,5};
        System.out.println(Arrays.toString(array));


        changArray(array);
        System.out.println(Arrays.toString(array));
    }

    public static void changArray(int[] array){

     array[2]=33;
    }
}
