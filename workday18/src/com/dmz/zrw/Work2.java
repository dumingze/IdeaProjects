package com.dmz.zrw;

public class Work2 {
    public static void main(String[] args) {
        //只会显示其中的A异常，因为执行functionA后，就会转到catch，并不会继续执行try块内的代码。
        try {
            functionA(10);
            functionB(10);
            functionC(10);
            System.out.println("输出吗");
        } catch (AException e) {
            e.printStackTrace();
        }catch (BException e) {
            e.printStackTrace();
        }catch (IllegalArgumentException e) {

        }

        System.out.println("-----------------------------------");

        try {
            functionB(10);
        }
        catch (BException e){
            e.printStackTrace();
        }

        System.out.println("-----------------------------------");
        try {
            functionC(10);
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
        }


    }
    public  static void functionA (int i) throws AException{
        if (i==10){
            throw new AException("AException");
        }
    }
    public  static void functionB(int i){
        if (i==10){
            throw new BException("BException");
        }
    }
    public  static void functionC(int i){
        if (i==10){
            throw new IllegalArgumentException("CException");
        }
    }
}
class AException extends Exception{
    public AException(String message) {
        super(message);
    }
}
class BException extends RuntimeException{
    public BException(String message) {
        super(message);
    }
}
