package com.dmz.zrw.test2;

import java.util.Arrays;

public class MaxArray {

    public static void main(String[] args) {
/*        编程题：输入一个整型数组，数组里面有正数也有负数，数组中连续的一个或多个整数组成子数组，
        每个子数组都有一个和。求所有子数组的和的最大值。
        例如，输入的数字为：1，-2,3,10，-4,7,2，-5，则和最大的子数组为3,10，-4,7,2和为18*/
        int[] ints = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        MaxArrayFromArray(ints);

    }

    public static int MaxArrayFromArray(int[] ints) {
        int maxNumber = ints[0];
        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            if (sum >= 0) {
                sum += ints[i];
            } else {
                sum = ints[i];
            }
            if (sum > maxNumber) {
                maxNumber = sum;
            }
        }
        System.out.println(maxNumber);

        return maxNumber;
    }
}
