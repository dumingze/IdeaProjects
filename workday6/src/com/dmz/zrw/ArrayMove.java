package com.dmz.zrw;

import java.util.Arrays;

public class ArrayMove {
    public static void main(String[] args){
        int[]array={1,2,3,4,5};
        moveKPosition(array,2);
        System.out.println(Arrays.toString(array));
    }
    public static void moveKPosition(int[]a,int k){
        int[] b=a.clone();
        for (int i=0;i<b.length;i++){
            a[i]=b[(i-k+b.length)%b.length];
        }
    }
}
