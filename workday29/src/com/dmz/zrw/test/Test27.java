package com.dmz.zrw.test;

public class Test27 {
    public static void main(String[]args){
        int[]x={0,1,2,3};
        for(int i=0;i<3;i+=2){
            try{
                System.out.println(x[i+2]/x[i]+x[i+1]);
            }catch(ArithmeticException e){
                System.out.println("errorl");
            }catch(Exception e){
                System.out.println("error2");
            }
        }
        }
}
