package com.dmz.zz;

public class ThreeDimensionalArray {
    //三维矩阵呢，这个概念是建立在二维矩阵之上的，说白了，添加了一个层的概念在里面
    //a[0][][]表示第一层，a[1][][]表示第二层，a[2][][]表示第三层，
    public static void main(String[] args) {

        int threeDimensionArray[][][] = {{{1, 2, 3}, {4, 5, 6}}, {{7, 8, 9}, {10, 11, 12}}};
/*      两层，每一层有两行，每行有三个元素
        第一层int threeDimensionArray[0][*][*] 是一个二维数组如下
        int threeDimensionArray[0][0][*] ：{1,2,3}
        int threeDimensionArray[0][1][*] ：{4,5,6}*/

        display3DArray(threeDimensionArray);
    }

    public static void display3DArray(int[][][] a) {
        //输出第3层
        for (int i = 0; i < a.length; i++) {
            System.out.println("下一层");

            //每一层输出两行
            for (int j = 0; j < a[i].length; j++) {

                //每一行输出3列
                for (int k = 0; k < a[i][j].length; k++) {
                    System.out.print(a[i][j][k] + " ");
                }
                System.out.println();

            }


        }
    }
}
