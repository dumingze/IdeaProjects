package com.dmz.zrw;

import java.awt.*;
import java.util.ArrayList;
import java.util.ListIterator;

public class Test {
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
/*        System.out.println(objects.size());
        ArrayList<Object> object2=null;
        System.out.println(object2.size());*/


objects.add("1");
        objects.add("2");
        objects.add("3");

        ListIterator<Object> listIterator = objects.listIterator();
        listIterator.add("dmz");
        listIterator.add("zrw");
        System.out.println(objects);



    }
}
