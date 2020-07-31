package com.dmz.zrw;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress=InetAddress.getByName("dumingze.local");
        System.out.println(inetAddress.getHostAddress());
    }
}
