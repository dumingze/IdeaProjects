package com.dmz.TestExtent;

public class BaseSon extends Base {

    String  name;

    public BaseSon() {

        super.hight=2;
     this.hight=1;



    }

    public static void main(String[] args) {
        BaseSon baseSon=new BaseSon();
        System.out.println(baseSon.hight);
    }
}
