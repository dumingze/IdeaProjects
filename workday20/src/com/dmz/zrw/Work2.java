package com.dmz.zrw;


import java.io.*;


public class Work2 {
   /* 2. 递归查找指定目录中(包括子目录中)，所有的.java文件，
    并且，把所有这些找到的java文件，复制到一个指定的目录下，
    目录结构同昨天，递归删除那道题的firstLevel(目录手动创建即可，不用使用代码创建)*/

    // ！！！！！！！！！！！！！！outputStream.write()方法没有文件能创建文件却不能带着文件夹一起创建文件。

    static int floorNumber = 0;

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
        System.out.println("当前第" + floorNumber + "层递归");
        File[] files = file.listFiles();
        // System.out.println(Arrays.toString(files));
        if (files!= null) {
            for (File smallfile1 : files) {
                if (smallfile1.isFile()) {
                    if (smallfile1.getName().endsWith(".java")) {
                        System.out.println("java文件" + smallfile1.getName());
                        String inputFile = smallfile1.getPath();

                        ///Users/dumingze/Desktop/SecondLevel要提前创建好，不然，
                        // outputStream.write()方法没有文件能创建文件却不能带着文件夹一起创建文件。
                        String copyToFlie = "/Users/dumingze/Desktop/SecondLevel/" + smallfile1.getName();
                        copyFile(inputFile, copyToFlie);
                    }
                } else {
                    recursionFileCatalogue(smallfile1);
                }
            }
        }

    }


}