package com.dmz.zrw;

import java.io.File;
import java.io.IOException;

public class CreatFile {
    public static void main(String[] args) throws IOException {
        File b1=new File("/Users/dumingze/Pictures/firstLevel/b1.java");
        b1.createNewFile();
        File b2=new File("/Users/dumingze/Pictures/firstLevel/secondLevel/b2.java");
        b2.createNewFile();
        File b3=new File("/Users/dumingze/Pictures/firstLevel/secondLevel/dir1/b3.java");
        b3.createNewFile();



    }
}
