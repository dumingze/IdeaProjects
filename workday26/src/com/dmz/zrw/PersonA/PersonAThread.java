package com.dmz.zrw.PersonA;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class PersonAThread {

    public static boolean isSenderOffline = false;

    public static Object closeLock = new Object();


    public static void main(String[] args) throws SocketException, UnknownHostException {
        DatagramSocket datagramSocket= new DatagramSocket(10002);
        SendTask sendTask=new SendTask(datagramSocket,"127.0.0.1",10001);
        Thread threadSend=new Thread(sendTask);
        threadSend.start();
        ReceiveTask receiveTask=new ReceiveTask(datagramSocket);
        Thread threadReceive=new Thread(receiveTask);
        threadReceive.start();
    }
}
