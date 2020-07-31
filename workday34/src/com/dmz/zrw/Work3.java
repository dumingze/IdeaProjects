package com.dmz.zrw;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class Work3 {
     static ArrayList arrayList=new ArrayList();

    /*3. 生成20个 1-20 的随机整数，把其中不重复的整数存入 List 集合中（相同的整数只存一个）。*/

    public static void main(String[] args) {

        for (int i = 0; i <20 ; i++) {
            myAdd((Integer) new Random().nextInt(20));

        }
        System.out.println(arrayList);
        System.out.println("链表大小为"+arrayList.size());

    }

    public  static void myAdd(Integer s){
        if (arrayList.isEmpty()){arrayList.add(s);}
        for (ListIterator listIterator = arrayList.listIterator(); listIterator.hasNext();){
            Integer currentInterage =(Integer) listIterator.next();
            if (!arrayList.contains(s)){
                listIterator.add(s);
            }

        }
    }
}
