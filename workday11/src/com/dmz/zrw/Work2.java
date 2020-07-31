package com.dmz.zrw;

public class Work2 {
    public static void main(String[] args) {

    }
}
class Human{
    String  name;
    int age;

    public void eat(){};
    public void sleep(){};
}
class MyStudent extends Human{

    public void study(){

    }

}

class Teacher extends Human{
    int teacherId;


    public void teach() {

    }
}

class Soldier extends Human{
    int armyId;
    public void  train(){}
}
