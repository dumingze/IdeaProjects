package com.dmz.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) throws IOException {

       /* char[] chars=new char[1];
        chars[0]='a';
        int[] ints=new int[128];
        ints[chars[0]]=1;
       for (int i=90;i<ints.length;i++){
            System.out.println(ints[i]);
        }

        int[] ints1=new int[20];
        System.out.println(ints[3]);
*/

      //  System.out.println("a"+"   aaa");
       // Test1 test1=new Test1();
        //test1.test22222();
        /*int x=0xfffff;
        System.out.println(x);*/

        FileInputStream fis = new FileInputStream("a.txt");



        //你好 的第一个字节的八位二进制位：11100100，jvm读取后，当成补码。
        byte  readByte;//int 00000000000000000000,11100100（补码）->原码 228
                      //byte 11100100(补码) -> 原码 -28
        /*
        其实  “你好”这个中文，按字节读取的到是，11100100，这个是补码。
        然后，int直接按整数00000000，00000000，00000000，11100100，228去查找utf-8里面对应的码值ä。
        而 byte ,先求11100100的原码是-28，查找-28对应的码值表里的字符￤
        */
/*        readByte =  (byte) fis.read() ;
        System.out.println(readByte);
        char c = (char) readByte;
        System.out.print(c);*/

        String s="啊杜";
        byte[]bytes=s.getBytes("utf-16");
        System.out.println(Arrays.toString(bytes));




        fis.close();

    }


}
