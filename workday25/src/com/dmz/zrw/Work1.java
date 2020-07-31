package com.dmz.zrw;

public class Work1 {
/*2. 创建2个线程，打印从0到99这100个数字，要求线程交叉顺序打印。(要求利用线程间通信api实现)

    比如：

    线程1: 0
    线程2: 1
    线程1: 2
    线程2: 3
    线程1: 4
    线程2: 5*/

int number=0;

    public static void main(String[] args) {
        Work1 work1=new Work1();

        Thread1 smallthread1=new Thread1(work1);
        Thread2 smallthread2=new Thread2(work1);
        Thread thread1 =new Thread(smallthread1, "线程1");
        thread1.start();
        Thread thread2 =new Thread(smallthread2, "线程2");
        thread2.start();

    }


}
class  Thread1 implements Runnable{

    Work1 work1;


    public Thread1(Work1 work1) {
        this.work1 = work1;
    }

    @Override
    public void run() {

        while (true){
            synchronized (work1){
                if (work1.number<=100){
                System.out.println(Thread.currentThread().getName()+"： "+work1.number++);
                try {
                    work1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                    System.out.println("_____");
                work1.notify();


            }}

        }
    }
}

class  Thread2 implements Runnable{

    Work1 work1;


    public Thread2(Work1 work1) {
        this.work1 = work1;
    }

    @Override
    public void run() {

        while (true){
            synchronized (work1){
              //  System.out.println("Test");
                if (work1.number<=100){
                    System.out.println("Test");
                System.out.println(Thread.currentThread().getName()+"： "+work1.number++);
                work1.notify();
                try {
                    work1.wait();
                    System.out.println("11");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }



            }}

        }
    }
}

