package com.dmz.zrw;


import java.io.File;
import java.util.Arrays;

public class Test {
   /* 2. 递归查找指定目录中(包括子目录中)，所有的.java文件，
    并且，把所有这些找到的java文件，复制到一个指定的目录下，
    目录结构同昨天，递归删除那道题的firstLevel(目录手动创建即可，不用使用代码创建)*/

    static int floorNumber=1;
    public static void main(String[] args) {
        File file=new File("/Users/dumingze/Desktop/MyfirstLevel");
        //System.out.println(file.getName());
        recursionFileCatalogue(file);


    }
    public static void recursionFileCatalogue(File file){
        floorNumber++;
        File[] files=file.listFiles();
        System.out.println("1");
        System.out.println("files    "+Arrays.toString(files));

        if (file!=null){
            System.out.println(file.getName());
            for (File smallfile:files){
                //输出当前文件夹的所有文件和目录
                //System.out.println(smallfile.getName());
                if (smallfile.getName().endsWith(".java")){
                    System.out.println("遍历得到"+smallfile.getName());

                }
                else {
                    recursionFileCatalogue(smallfile);
                }
            }
        }
        System.out.println("退出当前遍历第"+floorNumber+"层递归");
    }
}