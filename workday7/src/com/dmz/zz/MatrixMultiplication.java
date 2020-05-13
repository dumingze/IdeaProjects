package com.dmz.zz;

import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] array1 = new int[3][2];
        int[][] array2 = new int[2][3];
        int[][] resultArray = new int[3][3];
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个3x2的矩阵");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println("请输入下一个数字");
                array1[i][j] = scanner.nextInt();
            }
        }
        displayArray(array1);
        System.out.println("请输入一个2x3的矩阵");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("请输入下一个数字");
                array2[i][j] = scanner.nextInt();
            }
        }
        displayArray(array2);

        //这里，k为第一个矩阵的列数，也是第二个矩阵的行数
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                for (int k=0;k<2;k++){
                    resultArray[i][j]=resultArray[i][j]+(array1[i][k]*array2[k][j]);
                }
            }
        }
        System.out.println("结果矩阵为");
        displayArray(resultArray);

    }

    public static void displayArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

}
