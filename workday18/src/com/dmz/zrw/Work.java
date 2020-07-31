package com.dmz.zrw;

public class Work {

    /**final，finally 和 finalize的区别
     * final:修饰类：被final修饰的类不能被其他类继承
     *       修饰方法：被final修饰的方法不能被覆盖
     *       修饰成员变量：对象创建完毕之前前被赋值，且仅能被赋值一次，
     *                   3种方式：1.定义是赋值2.在构造代码块里赋值
     *                   3.在构造方法里赋值4.如果非静态，就不能在静态代码块中赋值了
     *       修饰局部变量：使用之前必须被赋值，且仅能被赋值一次
     *
     * finally:
     *        1.finally代码块的特点:必执行
     *        1)finally代码块中的代码一定会执行
     *          a. 在try-catch-finally代码块中，不管是否发生了异常，finally代码块中的代码都会执行
     *          b. 即使在finally代码块执行之前，先执行了return语句，finally仍旧会被执行
     *        2) 特殊情况：在执行到finally之前jvm退出了(比如System.exit(0))
     *
     *        finally的作用：因为它必执行
     *        用于释放资源，在IO流操作和数据库操作中会见到
     *
     *        2.如果catch里面有return语句，请问finally的代码还会执行吗? 会执行
     *         如果会，请问是在return前还是return后。  finally 既不在return之前，
     *         也不在return语句只有，而是在return语句执行的中间
     *
     * finalize:
     *          * protected void finalize() 实际开发中，不会使用这个方法
     *           a.当垃圾回收器确定不存在对该对象的更多引用时(当没有引用指向该对象的时候，此时对象其实已经变成了垃圾)
     *          b.由对象的垃圾回收器调用此方法(这个方法的调用者是垃圾回收器)
     *
     */
}
