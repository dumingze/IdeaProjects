package com.dmz.other;

public class Work3 {
    public static void main(String[] args) {
        Person person=new Person();
        function(person);
        person=new SouthPerson();
        function(person);
        person=new NorthPerson();
        function(person);


    }
    public static void function(Person person){
        person.eat();
    }
}
