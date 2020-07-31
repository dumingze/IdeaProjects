package com.dmz.Test2;

public class Test2 {
    public static void main(String[] args) {

        Sonclass sonclass=new Sonclass("1111");
        sonclass.showName();
        System.out.println(sonclass.getName());//父类的getName,父类的name
    }
}
class Sonclass extends Fatherclass{
    public Sonclass(String name) {
        super(name);
    }
    public void showName(){
        System.out.println(getName());//父类的name
    }
}