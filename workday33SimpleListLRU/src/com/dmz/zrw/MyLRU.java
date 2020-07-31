package com.dmz.zrw;

public class MyLRU {



    static int length=0;
    static  Node firstNode=null;

  /*  2. 用链表实现一个LRU缓存 (大小为100)，要求实现添加一个数据的方法。(自己定义节点类，存储的数据类型为int)。*/
    public static void main(String[] args) {

      for (int i = 0; i <100 ; i++) {

            lru(new Node(i+1));
        }


        lru(new Node(521));
        lru(new Node(522));
        lru(new Node(50));


        printList(firstNode);
        System.out.println("链表长度为  "+length);



    }

    public static void lru(Node node){

        //代替 firstNode
        Node currentNode=firstNode;
        //代表currentNode的前一个节点
        Node priNode=currentNode;

        boolean flag=false;//表示目前链表内是否含有当前添加的元素

        if (node!=null){

            // 判断数据是否存在，存在查找到的该处删除该节点，并在链表头处添加
            while (currentNode!=null){
                if (node.value==currentNode.value){
                    //删除当前节点
                     priNode.next=currentNode.next;
                     //头插入该节点

                    if (currentNode != firstNode) {
                        currentNode.next=firstNode;
                        firstNode=currentNode;

                    }


                    flag=true;
                    break;
                }
                //向下遍历
                priNode=currentNode;
                currentNode=currentNode.next;

            }



            //如果当前链表内没有该元素，且链表没满，直接在链表头添加
            if ((flag==false)&&length<100){
                node.next=firstNode;
                firstNode=node;
                length++;


            }

            //如果当前链表中没有该元素，但是链表满了，则删除最后一个元素，再用头插法
            //if ((flag==false)&&length>=100)
            else if ((flag==false)&&length>=100){
                currentNode=firstNode;
                priNode=currentNode;

                //找到尾节点
                while (currentNode.next!=null){
                    priNode=currentNode;
                    currentNode=currentNode.next;}

                //删除尾巴节点

                priNode.next=null;
                //头插入
                node.next=firstNode;
                firstNode=node;
            }
        }


    }



    static void printList(Node node){

        while (node!=null){

            System.out.println(node);
            node=node.next;

        }
    }

}
