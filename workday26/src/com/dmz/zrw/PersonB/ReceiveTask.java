package com.dmz.zrw.PersonB;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class ReceiveTask implements Runnable {
    private DatagramSocket datagramSocket;

    public ReceiveTask(DatagramSocket datagramSocket) {
        this.datagramSocket = datagramSocket;
    }

    @Override
    public void run() {
     while (true){
         byte[] bytes=new byte[1024];
         DatagramPacket datagramPacket=new DatagramPacket(bytes,0,bytes.length);
         try {
             datagramSocket.receive(datagramPacket);
             String s=getData(datagramPacket);
             if (s.equals("886")){
                 break;
             }


         } catch (IOException e) {
             e.printStackTrace();
         }
     }
        while (true){

            synchronized (PersonBThraed.closeLock){
                if (PersonBThraed.isSenderOffline){
                    break;
                }
                else {
                    try {
                        PersonBThraed.closeLock.wait(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        datagramSocket.close();

    }
    private String getData(DatagramPacket datagramPacket){
        byte[] bytes=datagramPacket.getData();
        //System.out.println("1111"+ Arrays.toString(bytes));
        //注意：new String(bytes,0,datagramPacket.getLength());这里一定要是datagramPacket.getLength()，表示
        //接收数据的时候，本次接收到的数据的字节个数
        String s=new String(bytes,0,datagramPacket.getLength());
        System.out.println("接收到了来自" + datagramPacket.getAddress()
                + "--" + datagramPacket.getPort() + "数据：" + s);
        return s;

    }
}
