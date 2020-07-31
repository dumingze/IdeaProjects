package com.dmz.zrw;

public class MyStack<E> {

    private Object[] elements;
    private int size;
    private int stackTop;
    private static final int DEFAULT_CAPACITY=10;
    private static final int MAX_CAPACITY = Integer.MAX_VALUE - 8;

    public MyStack(){
        elements=new Object[DEFAULT_CAPACITY];
    }

    public MyStack(int capacity){
        elements=new Object[capacity];
    }


    public void push(E e) {
        if (size == elements.length) {
            // 计算新数组的容量
            int newLength = calculateCapacity();
            System.out.println("newLength"+newLength);
            // 扩容
            grow(newLength);
        }
        elements[size++]=e;
        stackTop=size-1;

    }

    private int calculateCapacity() {
        if (elements.length == MAX_CAPACITY) {
            throw new RuntimeException();
        }
        int newLength = elements.length + (elements.length >> 1);
        if (newLength < 0 || newLength > MAX_CAPACITY) {
            newLength = MAX_CAPACITY;
        }
        return newLength;
    }

    private void grow(int newLength) {
        Object[] newTable = new Object[newLength];
        // 复制元素
        for (int i = 0; i < size; i++) {
            newTable[i] = elements[i];
        }
        elements = newTable;

    }

    public E poll(){
        if (isEmpty()){
            throw new RuntimeException();
        }
        else {
            size--;
            return (E) elements[stackTop--];
        }
    }

    public E peek(){
        if (isEmpty()){
            throw new RuntimeException();
        }
        else {
            return (E)elements[stackTop];
        }

    }
    public boolean isEmpty(){
        return (size==0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]).append(", ");
        }
        if (size != 0) sb.delete(sb.length() - 2, sb.length());
        return sb.append("]").toString();
    }
}
