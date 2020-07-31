package com.dmz.zrw;

import java.util.Arrays;

public class Work3 {


 /*   3. 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

    注意：

    最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

    你可以假设除了整数 0 之外，这个整数不会以零开头。

    示例1：

    输入：[1, 2, 3]

    输出：[1, 2, 4]

    示例2：

    输入：[9, 9, 9]

    输出：[1, 0, 0, 0]*/


    public static void main(String[] args) {

        int[] array1=new int[]{9,9,9};
        array1=arrayAddOne(array1,1);
        System.out.println(Arrays.toString(array1));

    }

    public static int[] arrayAddOne(int[] ints,int sumNumber){
        int jinwei=0;
        //这里，只有最后一位可以加数
        if (ints[ints.length-1]+sumNumber>=10){
            jinwei=1;
        }
        ints[ints.length-1]=(ints[ints.length-1]+sumNumber)%10;

        for (int i = ints.length-2; i>=0 ; i--) {

            int temp=ints[i];
            ints[i]=(ints[i]+jinwei)%10;
            //判断进位是否需要+1
            if ((temp+jinwei)>=10){
                jinwei=1;
            }else {
                jinwei=0;
            }



            if (i==0&&jinwei==1){

                int[] newIntArray=new int[ints.length+1];
                newIntArray[0]=1;

                for (int j = 1; j < ints.length+1; j++) {
                    newIntArray[j]=ints[j-1];
                }
                ints=newIntArray;

            }

        }



        return ints;

    }
}
