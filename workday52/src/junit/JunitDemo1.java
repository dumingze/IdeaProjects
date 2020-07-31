package junit;

import org.junit.Assert;
import org.junit.Test;

/*
单元测试的要求：
    a.必须是公共的方法
    b.返回值类型必须是void
    c.参数列表必须为空
 */
public class JunitDemo1 {
    @Test
    public void test() {
        System.out.println("Junit");
    }

    @Test
    public void test1() {
        System.out.println("Junit");
    }

    @Test
    public void test2() {
        int a = 10;
        int b = 20;
        Assert.assertNotEquals(a, b); // 断言失败会抛出AssertionError
        //Assert.assertEquals(a,b);
    }

    @Test
    public void mytest(){
        System.out.println("1111");
    }
}
