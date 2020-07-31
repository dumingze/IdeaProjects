package com.dmz.zrw;

public class Work1 {
/*    1. 自定义注解，该注解用来描述，方法运行所需的时间上限(用long类型的数据表示时间，单位为ms)，
    然后，自定义注解处理器，运行加了运行时间上限注解的方法，判断方法的运行时间，
    是否超出了注解中规定的时间上限，如果超过，则返回true，未超过返回false*/


    public static void main(String[] args) throws NoSuchMethodException, InterruptedException {
        System.out.println("是否超出了注解中要求的时间");
        System.out.println(RunTimeAnnotationProcessor.isOverRunTime(new TestTimeLimit()));



    }
}
class TestTimeLimit {

    //该方法，的执行时间不得超过200ms
    //用注解来描述

    // 该注解表示一个方法运行的时间上限，时间单位是ms
    @RunTimeLimit(200)
    public void run() throws InterruptedException {
        // 利用sleep调整，方法的执行时间(粗粒度的调整)
        Thread.sleep(500);
    }

}
