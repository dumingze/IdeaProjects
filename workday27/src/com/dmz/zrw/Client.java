package com.dmz.zrw;

import java.io.*;
import java.net.Socket;
import java.util.Properties;

public class Client {

    public static void main(String[] args) throws IOException {

        String picturePath = getPicturePath();
        System.out.println("picturePath: " + picturePath);

        FileInputStream fileInputStream = new FileInputStream(picturePath);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        Socket socket = new Socket("127.0.0.1", 10002);
        OutputStream out = socket.getOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out);

        byte[] buffer = new byte[1024];
        int lenth;
        while ((lenth = bufferedInputStream.read(buffer)) != -1) {
            bufferedOutputStream.write(buffer, 0, lenth);
        }

        bufferedOutputStream.flush();
        socket.shutdownOutput();

        byte[] byteBuffer= new byte[1024];
        InputStream inputStream = socket.getInputStream();
        // 因为Socket的InputStream中的read方法是一个阻塞方法，当如果没有接收到数据，就会阻塞
        lenth= inputStream.read(byteBuffer);
        System.out.println(new String(byteBuffer, 0, lenth));
        socket.close();
        bufferedInputStream.close();
    }

    public static String getPicturePath() throws IOException {

        FileInputStream fis = new FileInputStream("config.properties");
        Properties properties = new Properties();
        properties.load(fis);
        String picturePath = properties.getProperty("picturePath");
        return picturePath;

    }
}
