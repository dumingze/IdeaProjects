package com.dmz.zrw;

import java.util.ListIterator;

public class Linkedlist<E> {
    Node<E> first;//永远指向当前链表的头
    Node<E> last;//永远指向当前链表的尾巴
    int modCount = 0;
    int size=0;

    public Linkedlist() {
    }

    /**
     * 头插入
     * @param e
     */
    private void linkFirst(E e) {
        final Node<E> f = first;//f指向当前节点的头
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
        modCount++;
    }

    /**
     * 尾插入
     * @param e
     */
    void linkLast(E e) {
        final Node<E> l = last;//l指向当前链表的尾巴
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }

    /**
     * 将元素c插入到succ之前
     * @param e
     * @param succ
     */
    void linkBefore(E e, Node<E> succ) {
        // assert succ != null;
        final Node<E> pred = succ.prev;
        final Node<E> newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
        modCount++;
    }
//---------------------------------------------------------------------------------------------------------------
    /**
     * 将f作为头结点，移除并返回
     * @param f
     * @return
     */
    private E unlinkFirst(Node<E> f) {
        // assert f == first && f != null;
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        modCount++;
        return element;
    }

    /**
     * 将l作为尾结点，移除并返回
     * @param l
     * @return
     */
    private E unlinkLast(Node<E> l) {
        // assert l == last && l != null;
        final E element = l.item;
        final Node<E> prev = l.prev;
        l.item = null;
        l.prev = null; // help GC
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        modCount++;
        return element;
    }

    /**
     * 移除中间元素x
     * @param x
     * @return
     */
    E unlink(Node<E> x) {
        // assert x != null;
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        modCount++;
        return element;
    }
//---------------------------------------------------------------------------------------------------------------

    /**
     * 获取第一个元素
     * @return
     */
    public E getFirst() {
    final Node<E> f = first;
    if (f == null)
        throw new RuntimeException();
    return f.item;
}

    /**
     * 获取最后一个元素
     * @return
     */
    public E getLast() {
        final Node<E> l = last;
        if (l == null)
            throw new RuntimeException();
        return l.item;
    }
    //------------------------------------------------------------------------------------------------------

    /**
     * 移除元素o
     * @param o
     * @return
     */
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 清空链表，将所有元素的next都置为null
     */
    public void clear() {

        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;//保存x的下一个元素
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
        modCount++;
    }

    //-----------------------------------------------------------------------------------------------------

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new RuntimeException();
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }
    /**
     * 获取链表中，第index个元素
     * @param index
     * @return
     */
    Node<E> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    /**
     * 在index前，添加element
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        checkPositionIndex(index);

        if (index == size)
            linkLast(element);
        else
            linkBefore(element, node(index));
    }

    public E remove(int index) {
        //checkElementIndex(index);
        return unlink(node(index));}

    public ListIterator<E> listIterator(int index) {
        checkPositionIndex(index);
        return new ListItr(index);
    }


        private class ListItr  implements ListIterator<E> {
            private Node<E> lastReturned;
            private Node<E> next;
            private int nextIndex;
            private int expectedModCount = modCount;

            ListItr(int index) {
                // assert isPositionIndex(index);
                next = (index == size) ? null : node(index);
                nextIndex = index;
            }

            public boolean hasNext() {
                return nextIndex < size;
            }

            public E next() {
                checkForComodification();
                if (!hasNext())
                    throw new RuntimeException();

                lastReturned = next;
                next = next.next;
                nextIndex++;
                return lastReturned.item;
            }

            public boolean hasPrevious() {
                return nextIndex > 0;
            }

            public E previous() {
                checkForComodification();
                if (!hasPrevious())
                    throw new RuntimeException();

                lastReturned = next = (next == null) ? last : next.prev;
                nextIndex--;
                return lastReturned.item;
            }

            public int nextIndex() {
                return nextIndex;
            }

            public int previousIndex() {
                return nextIndex - 1;
            }

            public void remove() {
                checkForComodification();
                if (lastReturned == null)
                    throw new IllegalStateException();

                Node<E> lastNext = lastReturned.next;
                unlink(lastReturned);
                if (next == lastReturned)
                    next = lastNext;
                else
                    nextIndex--;
                lastReturned = null;
                expectedModCount++;
            }

            public void set(E e) {
                if (lastReturned == null)
                    throw new IllegalStateException();
                checkForComodification();
                lastReturned.item = e;
            }

            public void add(E e) {
                checkForComodification();
                lastReturned = null;
                if (next == null)
                    linkLast(e);
                else
                    linkBefore(e, next);
                nextIndex++;
                expectedModCount++;
            }


            final void checkForComodification() {
                if (modCount != expectedModCount)
                    throw new RuntimeException();
            }

        }



    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}

