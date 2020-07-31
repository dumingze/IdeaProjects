package com.dmz.zrw;

public class QueueDemon {
    public static void main(String[] args) {
        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.enqueue("杜");
        myQueue.enqueue("明");
        myQueue.enqueue("泽");
        System.out.println(myQueue);
        myQueue.dequeue();
        System.out.println(myQueue);
        myQueue.clean();
        System.out.println(myQueue);

    }
}
