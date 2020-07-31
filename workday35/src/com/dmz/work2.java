package com.dmz;

public class work2 {

}
 class LRU<E> {
    private static final int DEFAULT_CAPACITY = 100;
    private int capacity;
    private int size;
    private Node head = new Node(null); //Dummy node
    private Node end = new Node(null); //Dummy node

    public LRU() {
        head.next = end;
        end.prev = head;
        capacity = DEFAULT_CAPACITY;
    }

    public LRU(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity=" + capacity);
        }
        head.next = end;
        end.prev = head;
        this.capacity = capacity;
    }

    private class Node {
        E value;
        Node prev;
        Node next;

        public Node(E value) {
            this.value = value;
        }

        public Node(E value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public void add(E element) {
        Node node = head.next;
        while (node != end) {
            if (node.value == element) break;
            node = node.next;
        }
        // 存在
        if (node != end) {
            // 删除node
            node.prev.next = node.next;
            node.next.prev = node.prev;
            // 在头部添加
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        } else {
            Node x = new Node(element, head, head.next);
            // 不存在，且容量未满
            if (size < capacity) {
                head.next.prev = x;
                head.next = x;
                size++;
            } else {
                // 不存在，且容量满了
                // 删除最后一个元素
                end.prev = end.prev.prev;
                end.prev.next = end;
                // 在头部添加
                head.next.prev = x;
                head.next = x;
            }
        }
    }
}