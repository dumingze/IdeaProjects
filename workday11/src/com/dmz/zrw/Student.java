package com.dmz.zrw;

public class Student {
    static int i=10;

    private Student(){

    }

    public  static  Student creatStudent(){
      if(i>0){
          i--;
          Student student=new Student();
          System.out.println("创建第"+(10-i)+"个Student对象");
          return student;
      }
      else {
          System.out.println("无法创建Student对象了");
          return null;}

    }
}
