package com.dmz.zrw;

import javax.sound.midi.Soundbank;

public class StackDemon {
    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>();


        for (int i = 0; i <11 ; i++) {
            myStack.push("du");

        }
        myStack.push("杜");
        myStack.push("名");
        myStack.push("泽");

        System.out.println(myStack);
        System.out.println(myStack.peek());
        myStack.poll();
        System.out.println(myStack);
        System.out.println(myStack.peek());

    }
}
