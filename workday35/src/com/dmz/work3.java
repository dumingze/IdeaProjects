package com.dmz;

import java.util.Deque;
import java.util.LinkedList;

public class work3 {
/*    3. 合并两个有序的链表, 合并后的链表也是有序的。
    举例：
    输入：1 --> 2 --> 5 --> null
            2 --> 4 --> 7 --> null
    输出：1 --> 2 --> 2 --> 4 --> 5 --> 7 --> null*/

    public static void main(String[] args) {
        //构建两个链表

        LinkedList<Integer> linkedList1=new LinkedList<>();
        linkedList1.add(1);
        linkedList1.add(2);
        linkedList1.add(5);
        //System.out.println(linkedList1.get(2));


        LinkedList<Integer> linkedList2=new LinkedList<>();
        linkedList2.add(2);
        linkedList2.add(4);
        linkedList2.add(7);
        linkedList2.add(10);
        //System.out.println(linkedList2);

        Deque deque=combine(linkedList1,linkedList2);
        System.out.println(deque);




    }

    public static Deque combine(LinkedList<Integer> linkedList1,LinkedList<Integer> linkedList2){
        Deque deque=new LinkedList();
        int length=linkedList1.size()<=linkedList2.size()?linkedList1.size():linkedList2.size();
        int m=0;//存储linkedList1的下标
        int n=0;//存储linkedList2的下标

        //循环length次
       while (m<length&&n<length){


                if (linkedList1.get(m)<linkedList2.get(n)){
                    deque.offer(linkedList1.get(m));
                    m=m+1;
                }
                else {
                    deque.offer(linkedList2.get(n));
                    n=n+1;
                }


        }
       if (n<linkedList2.size()){
           for (;n<linkedList2.size();n++){
               deque.offer(linkedList2.get(n));
           }
       }

       if (m<linkedList1.size()){

           for (;m<linkedList1.size();m++){
               deque.offer(linkedList1.get(m));
           }
       }

       return deque;
    }
}
