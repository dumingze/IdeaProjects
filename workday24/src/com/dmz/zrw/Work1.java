package com.dmz.zrw;


public class Work1 {
    /*1. 用多线程代码来模拟，迅雷用3个线程下载100M资源的的过程。
        每个线程每次，一次下载1兆(M)资源，直到下载完毕，即剩余的待下载资源大小为0
        (用一个整数表示资源大小，每次个线程每次下载多少兆(M), 剩余待下载资源就减少多少兆(M)，
        模拟我们售票的代码实现，考虑多线程的数据安全问题)*/
    public static void main(String[] args) {
        DownloadForXunLei downloadForXunLei = new DownloadForXunLei();

        Thread thread1 = new Thread(downloadForXunLei);
        thread1.setName("下载线程1");
        Thread thread2 = new Thread(downloadForXunLei);
        thread2.setName("下载线程2");
        Thread thread3 = new Thread(downloadForXunLei);
        thread3.setName("下载线程3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class DownloadForXunLei implements Runnable {
    private Object object = new Object();
    int downloadResouse = 100;

    @Override
    public void run() {
        while (downloadResouse > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (object) {

                if (downloadResouse > 0) {
                    System.out.println(Thread.currentThread().getName()+" 下载1兆 "+" 资源剩余:"  + " " +  --downloadResouse);
                }
            }
        }
    }
}
