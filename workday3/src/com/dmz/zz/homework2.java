package com.dmz.zz;

public class homework2 {

    public static void main(String[]args){
        choose(1,2,1);
    }
    public static void choose(int x,int y,int z){
        if ((x^y)==0){
            System.out.println(z+"是不一样");
        }
        else {
            if ((x^z)==0){System.out.println(y+"是不一样");}
            else {System.out.println(x+"是不一样");}
        }
    }
}
