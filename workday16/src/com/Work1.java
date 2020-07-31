package com;

public class Work1
{
    public static void main(String[] args) throws CloneNotSupportedException {
        FirstLevel firstLevel=new FirstLevel(1,1,new SecondLevel(1,1,new ThirdLevel(1,1)));
        System.out.println("原对象(复制对象修改之前)"+firstLevel);
        FirstLevel cloneFirstLevel=firstLevel.clone();
        System.out.println("复制对象(复制对象修改之前)"+cloneFirstLevel);

        cloneFirstLevel.second.secondDoubleValue=233333;
        cloneFirstLevel.second.secondIntValue=23333333;
        System.out.println("原对象(复制对象修改之后)"+firstLevel);
        System.out.println("复制对象(复制对象修改之后)"+cloneFirstLevel);



    }
}
class FirstLevel implements Cloneable {
    int firstIntValue;
    double firstDoubleValue;
    SecondLevel second;

    public FirstLevel(int firstIntValue, double firstDoubleValue,
                      SecondLevel second) {
        this.firstIntValue = firstIntValue;
        this.firstDoubleValue = firstDoubleValue;
        this.second = second;
    }
    @Override
    protected FirstLevel clone() throws CloneNotSupportedException {
        //利用Object的Clone方法，
        FirstLevel first = (FirstLevel) super.clone();

        //修改 first对象中引用类型成员变量，比如 second 成员变量引用，指向被复制的那个FirstLevel对象的second对象的拷贝，

        first.second=second.clone();
        return first;
    }

    @Override
    public String toString() {
        return "FirstLevel{" +
                "firstIntValue=" + firstIntValue +
                ", firstDoubleValue=" + firstDoubleValue +
                ", second=" + second +
                '}';
    }
}

class SecondLevel implements Cloneable{
    int secondIntValue;
    double secondDoubleValue;
    ThirdLevel third;

    public SecondLevel(int secondIntValue, double secondDoubleValue,
                       ThirdLevel third) {
        this.secondIntValue = secondIntValue;
        this.secondDoubleValue = secondDoubleValue;
        this.third = third;
    }

    @Override
    protected SecondLevel clone() throws CloneNotSupportedException {
        SecondLevel secondLevel = (SecondLevel) super.clone();

        //修改SecondLevel这个对象中，引用类型的成员变量的值，让他指向，复制之后的成员变量所指向对象地址
        secondLevel.third=third.clone();
        return secondLevel;
    }

    @Override
    public String toString() {
        return "SecondLevel{" +
                "secondIntValue=" + secondIntValue +
                ", secondDoubleValue=" + secondDoubleValue +
                ", third=" + third +
                '}';
    }
}

class ThirdLevel implements Cloneable{
    int thirdIntValue;
    double thirdDouleValue;

    public ThirdLevel(int thirdIntValue, double thirdDouleValue) {
        this.thirdIntValue = thirdIntValue;
        this.thirdDouleValue = thirdDouleValue;
    }

    @Override
    protected ThirdLevel clone() throws CloneNotSupportedException {
        ThirdLevel thirdLevel=(ThirdLevel) super.clone();
        return thirdLevel;
    }

    @Override
    public String toString() {
        return "ThirdLevel{" +
                "thirdIntValue=" + thirdIntValue +
                ", thirdDouleValue=" + thirdDouleValue +
                '}';
    }
}