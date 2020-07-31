package com.dmz.zrw.test;

public class AnimalFarm {
    public static void main(String[] args){
        final String pig = "length: 10";
        final String dog = "length: " + pig.length();
        System.out.println(pig);
        System.out.println(dog);
        System.out. println("Animals are equal: " + pig == dog);

        System.out.println("--------");
        String str1 = "hello";
        String str2 = "he" + new String("llo");
        System.err.println(str1 == str2);
    }
}
