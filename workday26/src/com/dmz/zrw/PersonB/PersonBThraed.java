package com.dmz.zrw.PersonB;

import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class PersonBThraed {
    public static boolean isSenderOffline = false;
    public static Object closeLock = new Object();

    public static void main(String[] args) throws SocketException, UnknownHostException {
        DatagramSocket datagramSocket=new DatagramSocket(10001);
        SendTask sendTask=new SendTask(datagramSocket,"127.0.0.1",10002);
        Thread threadSend=new Thread(sendTask);
        threadSend.start();
        ReceiveTask receiveTask=new ReceiveTask(datagramSocket);
        Thread threadReceive=new Thread(receiveTask);
        threadReceive.start();



    }
}
