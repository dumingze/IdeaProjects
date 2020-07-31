package com.dmz.zrw;

import java.io.*;

public class Work {
   /* 1.复制目录，要求：
    a. 复制目录及其所有子目录，保证在复制的目标目录中，目录结构和原目录相同
    b. 同时，对于原目录及其子目录，只将原目录中的指定类型的.java文件，
    复制到目标目录中，对应的相同目录中*/
   static int floorNumber = 0;
   //用来标记复制到的地址
   static String strCopyTo="/Users/dumingze/Desktop/SecondLevel/";



    public static void main(String[] args) throws IOException {
        File file = new File("/Users/dumingze/Desktop/MyfirstLevel");
        // System.out.println(file.getName());
        recursionFileCatalogue(file);


    }

    public static void copyFile(String oldFile, String newFils) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        inputStream = new BufferedInputStream(new FileInputStream(oldFile));
        outputStream = new BufferedOutputStream(new FileOutputStream(newFils));
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, length);
        }
        inputStream.close();
        outputStream.close();

    }

    public static void recursionFileCatalogue(File file) throws IOException {
        floorNumber++;
        String currentDirectory=strCopyTo;


        System.out.println("当前第" + floorNumber + "层递归");
        File[] files = file.listFiles();
        // System.out.println(Arrays.toString(files));
        if (files!= null) {
            for (File smallfile1 : files) {
                if (smallfile1.isFile()) {
                    if (smallfile1.getName().endsWith(".java")) {
                        System.out.println("当前java文件" + smallfile1.getName());
                        String inputFile = smallfile1.getPath();
                        ///Users/dumingze/Desktop/SecondLevel要提前创建好，不然，outputStream.write()方法没有文件能创建文件却不能带着文件夹一起创建文件。
                        String copyToFlie = strCopyTo+ smallfile1.getName();
                        System.out.println("复制到的地址"+copyToFlie);
                        System.out.println("-----------------------------------");
                        copyFile(inputFile, copyToFlie);
                    }
                } else {
                    //存放当前的目录
                    strCopyTo=currentDirectory+smallfile1.getName()+"/";
                    File partFile=new File(strCopyTo);
                    if (!partFile.exists()){
                        partFile.mkdirs();
                    }
                    recursionFileCatalogue(smallfile1);
                }
            }
        }

    }

}
