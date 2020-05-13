package com.dmz.zz;

public class homework3 {
    public static void main(String[] args){
        boolean b=isthenumber(10);
        System.out.println(b);
        System.out.println(isthenumber(8));
    }
    //若为2的整数次幂，则，X & X －1 为0
    public static boolean isthenumber(int x){
        if (x<0){return false;}
        else{
            if((x&x-1)==0)
                return true;
        }
        return false;
    }
}
