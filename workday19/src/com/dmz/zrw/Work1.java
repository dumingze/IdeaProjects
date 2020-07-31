package com.dmz.zrw;

import java.io.File;
import java.util.Arrays;

public class Work1 {
    public static void main(String[] args) {
        File dir=new File("/Users/dumingze/Pictures/firstLevel");
        File[] files = dir.listFiles();
        delectDir(files);
        //彻底删除的话，还需要dir.delect();这里为了看结果就不删除了

    }

    public static void delectDir(File[] files){
        File[] smallfiles;
        if (files!=null){
            for (File file:files){
                if (file.isFile()){
                    System.out.println("删除"+file.getName());
                    file.delete();

                }
                if (file.isDirectory()){
                    smallfiles=file.listFiles();
                    delectDir(smallfiles);
                    System.out.println("删除"+file.getName());
                    file.delete();
                }



            }
        }
    }
}
