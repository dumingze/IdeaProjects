package com.dmz.zrw;


import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(10002);
        Socket socket = serverSocket.accept();


        FileOutputStream fileOutputStream = new FileOutputStream("together.jpg");

        InputStream in = socket.getInputStream();
        BufferedInputStream br = new BufferedInputStream(in);

        byte[] buffer = new byte[1024];
        int length;

        // 实际上调用的是，socket中的，inputStream的read（）方法。
        // Socket中的输入流，的read方法，它是阻塞方法，所以服务器端的这个读取发送端数据的循环，不会自动终止
        while ((length = br.read(buffer)) !=  -1) {
            fileOutputStream.write(buffer, 0, length);
        }

        OutputStream outputStream = socket.getOutputStream();
        InetAddress sendIp = socket.getInetAddress();
        int port = socket.getPort();
        String response = "来自" + sendIp + "--" + port + "的文件，上传完毕";
        outputStream.write(response.getBytes());

        socket.close();
        serverSocket.close();
        fileOutputStream.close();


    }
}
