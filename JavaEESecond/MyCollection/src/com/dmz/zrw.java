package com.dmz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class zrw {
    public static void main(String[] args) {
        Collection collection=new ArrayList();
        collection.add("1");
        collection.add("2");
        collection.add("3");
        System.out.println(collection);

        Iterator iterator = collection.iterator();
       // iterator.remove();Exception in thread "main" java.lang.IllegalStateException

        iterator.next();
        iterator.next();
        iterator.remove();
        System.out.println(collection);

        //iterator.remove(); 删除一次后，光标回退？再进行删除，光标移动不假，但是会报错嗷




    }
}
