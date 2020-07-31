package com.dmz.zrw;

import java.io.*;
import java.util.Arrays;

public class Work2 {
    /* 2.  在一个磁盘的文件里保存26个英文小写字母（乱序），将他们读入内存中，进行排序，
     把排好顺序的数再重新追加写到磁盘的该文件中。*/
    public static void main(String[] args) throws IOException {
        //读取文件
        BufferedReader bufferedReader = new BufferedReader(new FileReader("test.txt"));
        String sLong = new String();
        String sShort;
        //这里，用下字符串，不用字符数组了
        while ((sShort = bufferedReader.readLine()) != null) {
            sLong = sLong + sShort;
        }
        System.out.println("排序前" + sLong);
        //读取结果放入字符串数组中
        char[] chars = sLong.toCharArray();
        Arrays.sort(chars);
        System.out.print("排序后");
        for (char c : chars) {
            System.out.print(c);
        }
        //重新写入文件
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt",true));
        bufferedWriter.newLine();
        bufferedWriter.write(chars);

        bufferedReader.close();
        bufferedWriter.close();
    }
}
