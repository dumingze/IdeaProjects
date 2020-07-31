package com.dmz.zrw;

import java.lang.reflect.Method;

public class RunTimeAnnotationProcessor {

    public  static boolean isOverRunTime(TestTimeLimit testTimeLimit) throws NoSuchMethodException, InterruptedException {
        // 1. 拿到目标方法的运行的时间上限
        Class testTimeLimitClass = TestTimeLimit.class;
        //注解中要求的时间
        long annotationTime;
        //实际运行时间
        long realTime;
        //标记是否超出注解中要求的时间
        boolean flag=false;
        // 利用Class对象，获取目标方法Method对象
        Method method=testTimeLimitClass.getDeclaredMethod("run");
        method.setAccessible(true);

        // 2. 从Method对象上，判断方法上有没有目标类型的注解，如果有，获取该注解实例(利用isAnnotationPresent方法)
        // 从注解实例上，获取方运行的时间上限值(getAnnotation方法获取)
        if (method.isAnnotationPresent(RunTimeLimit.class)){
            RunTimeLimit runTimeLimit = method.getAnnotation(RunTimeLimit.class);
            annotationTime=runTimeLimit.value();


            // 3. 运行目标方法，计算方法的实际运行时间
            long starTime = System.currentTimeMillis();
            // 运行目标方法（java语言知识调用方法，利用反射也可以）
            testTimeLimit.run();

            long endTime = System.currentTimeMillis();

            //4.判断，方法的实际运行时间，是否超出注解规定的上限
            realTime=endTime-starTime;
            if (realTime>annotationTime){

                flag=true;

            }

        }
        return flag;




    }
}
