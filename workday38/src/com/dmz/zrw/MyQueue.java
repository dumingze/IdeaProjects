package com.dmz.zrw;

public class MyQueue<E> {

    //使用两个空节点，分别指向 head 和tail,实际上的队列链表在 head 和tail之间
    private Node head;
    private Node tail;
    private int size;




    public MyQueue(){
        head = new Node(null);
        tail = new Node(head, null, null);
        head.next = tail;
    }

    public int getSize() {

        return size;
    }

    private static class Node {
        Node prev;
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
        }

        Node(Node prev, Object value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }



    public void enqueue(E e){
        //使用尾插法
        Node node=new Node(tail.prev,e,tail);
        tail.prev.next=node;
        tail.prev=node;
        size++;

    }

    public E dequeue(){
        //在头上删除
        size--;
        Node node=head.next;
        head.next=head.next.next;
        head.next.prev=head;
        return (E) node.value;


    }

    public E peek(){
        return (E) head.next.value;
    }

    public void clean(){
        head.next=tail;
        tail.prev=head;
    }

    public boolean isEmpty(){

        return head.next==tail;
    }

    public String toString() {
        if (isEmpty()){
            throw new RuntimeException("链表为空");
        }
        StringBuilder sb = new StringBuilder("[");
        Node x = head.next;
        while (x != tail) {
            sb.append(x.value).append(", ");
            x = x.next;
        }
        if (size != 0) sb.delete(sb.length() - 2, sb.length());
        return sb.append("]").toString();
    }
}
