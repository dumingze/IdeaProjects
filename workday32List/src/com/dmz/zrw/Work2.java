package com.dmz.zrw;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class Work2 {
   /* 2. 实现List的嵌套遍历(外层List中的元素是List对象)。*/

    public static void main(String[] args) {



        List list1 = new ArrayList();
        list1.add("1");
        list1.add("2");
        list1.add("3");

        List list2 = new ArrayList();
        list2.add("10");
        list2.add("20");
        list2.add("30");




        List listSum=new ArrayList();
        listSum.add(0,list1);
        listSum.add(1,list2);
        System.out.println(listSum);


        for ( ListIterator myListIterator = listSum.listIterator();myListIterator.hasNext();){
            List l = (List) myListIterator.next();
            for ( ListIterator mySmallListIterator = l.listIterator();mySmallListIterator.hasNext();){

                String s=(String) mySmallListIterator.next();

                System.out.print(s+" ");

            }
            System.out.println();
        }



    }
}
