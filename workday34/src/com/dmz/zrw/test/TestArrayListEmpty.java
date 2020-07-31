package com.dmz.zrw.test;

import java.util.ArrayList;
import java.util.ListIterator;

public class TestArrayListEmpty {

    public static void main(String[] args) {
        ArrayList arrayList=new ArrayList();

        System.out.println(arrayList.contains("nihao"));


        ListIterator listIterator = arrayList.listIterator();
        System.out.println(listIterator.hasNext());


        for (int i = 0; i >5 ; i++) {
            System.out.println("1111111");

        }
    }



}
