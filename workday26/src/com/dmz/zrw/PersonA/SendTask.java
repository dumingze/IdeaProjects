package com.dmz.zrw.PersonA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class SendTask  implements Runnable{

    private DatagramSocket datagramSocket;
    private InetAddress targetIp;
    private int targetPort;

    public SendTask(DatagramSocket datagramSocket, String targetIp, int targetPort) throws UnknownHostException {
        this.datagramSocket = datagramSocket;
        this.targetIp = InetAddress.getByName(targetIp);
        this.targetPort = targetPort;
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String data;
        while (true){
            try {
                if (((data=bufferedReader.readLine())!=null)){
                    sendData(data);
                    if (data.equals("886")){
                        synchronized (PersonAThread.closeLock){
                            PersonAThread.isSenderOffline=true;
                        }
                        break;
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }



    }

    private void sendData(String data) throws IOException {
        byte[] bytes=data.getBytes();
        DatagramPacket datagramPacket=new DatagramPacket(bytes,0,bytes.length,targetIp,targetPort);
        datagramSocket.send(datagramPacket);


    }
}
