package com.dmz.Test;

public class Person {
    private String name="测试";
    private int high;

    public Person(String name, int high) {
        this.name = name;
        this.high = high;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    protected void thisNmae(){
        System.out.println(name);
    }

    public Person() {
    }
}
