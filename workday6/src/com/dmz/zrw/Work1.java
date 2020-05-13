package com.dmz.zrw;

import java.util.Arrays;

/*1.给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，
        并返回他们的数组下标，假设每种输入只会对应一个答案
        (因为是两个数，所以下标值，有两个，所以该方法返回一个int[]，里面包含两个整数对应的数组下标)*/
public class Work1 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int[] resultArray = returnSum(array, 3);
        System.out.println("下标为" + Arrays.toString(resultArray));
    }

    public static int[] returnSum(int[] a, int target) {
        int[] result = {-1, -1};
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}

