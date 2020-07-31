package com.dmz.zrw;

import java.io.*;

public class Work1 {
/*    1.  从磁盘上读取一个文本文件（如某个java源代码），分别统计出文件中英文字母、空格、数字字符的个数。
            (注意文本文件中的数字指的是数字字符！！！)*/
     public static void main(String[] args) throws IOException {
         // 获取当前用户目录的路径
         //String wordingDir = System.getProperty("user.dir");
         //System.out.println(wordingDir);

         int coutEnglish=0;
         int countSPace=0;
         int coutNumber=0;
         BufferedReader bufferedReader=new BufferedReader(new FileReader("zz.java"));
         char[] chars=new char[1024];
         int length;
         while ((length=bufferedReader.read(chars))!=-1){
             for (int i = 0; i <length ; i++) {
                 if (chars[i]>='A'&chars[i]<='Z'){
                     coutEnglish++;
                 }
                 if (chars[i]>='a'&chars[i]<='z'){
                     coutEnglish++;
                 }
                 if (chars[i]>='0'&chars[i]<='9'){
                     coutNumber++;
                 }
                 if (chars[i]==' '){
                     countSPace++;

                 }

             }

         }
         bufferedReader.close();
         System.out.println("coutEnglish "+coutEnglish);
         System.out.println("outNumber "+coutNumber);
         System.out.println("countSPace "+countSPace);
}
}
