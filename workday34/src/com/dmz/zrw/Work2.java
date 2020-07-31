package com.dmz.zrw;

import java.util.ArrayList;
import java.util.ListIterator;

public class Work2 {
   /* . 用 List 存储一些字符串，去除里面重复的字符串，只保留一个*/

    public static void main(String[] args) {
        ArrayList arrayList=new ArrayList();
        myAdd(arrayList,"dmz");
        myAdd(arrayList,"dmz");
        myAdd(arrayList,"dmz");
        myAdd(arrayList,"zrw");
        System.out.println(arrayList);

    }

    public  static void myAdd(ArrayList arrayList,String s){
        //if (arrayList.isEmpty()){arrayList.add(s);}
       for ( ListIterator listIterator = arrayList.listIterator();listIterator.hasNext();){
          // String currentString =(String) listIterator.next();
           if (!arrayList.contains(s)){
               listIterator.add(s);
           }

       }



    }
}
