package com.dmz.zrw;

import java.util.Arrays;

public class Work3 {

/*3. 给定一个数组nums和一个值 val，你需要原地移除所有数值等于val的元素，将不等于val的元素放在数组的最前面，并返回去重后元素的个数。
    注意：
    原地的意思是空间复杂度为O(1)，也就是在原数组上进行修改。
    元素的顺序可以改变。
    你不需要考虑数组中超出新长度后面的元素。*/

    public static void main(String[] args) {
        int[]nums=new int[]{2,1,3,1,4};
        System.out.println("修改前:");
        System.out.println(Arrays.toString(nums));
        System.out.println("修改后:");
        int key=removeValFromArray(nums,1);
        for (int i = 0; i <nums.length-key ; i++) {
            System.out.print(nums[i]+" ");

        }
        System.out.println();
        System.out.println("去重后元素个数为"+(nums.length-key));
    }

    public static int removeValFromArray(int[] nums,int val){
        //key是返回的新数组需要截断的元素个数
        int key=0;

        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]==val){
                key++;
                for (int j = i; j <nums.length-1 ; j++) {
                       nums[j]=nums[j+1];
                }



            }

        }
       return key;
    }
}
