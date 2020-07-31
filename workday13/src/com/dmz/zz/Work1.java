package com.dmz.zz;

public class Work1 {
    public static void main(String[] args) {
       Rectangle rectangle=new Rectangle(1,1);
       rectangle.draw();
    }
}
abstract class Graph{
    private int area;
    private int length;
    abstract protected void draw();

    public Graph(int area, int length) {
        this.area = area;
        this.length = length;
    }

    public Graph() {
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
class Rectangle extends Graph{
    public Rectangle(int area, int length) {
        super(area, length);
    }

    @Override
    protected void draw() {
        System.out.println("矩形的周长为"+super.getArea()+" 矩形的面积为"+super.getLength());
    }
}

class Roundness extends Graph{
    public Roundness(int area, int length) {
        super(area, length);
    }

    @Override
    protected void draw() {
        System.out.println("圆形的周长为"+super.getArea()+"圆形的面积为"+super.getLength());
    }
}
class Triangle extends Graph{
    public Triangle(int area, int length) {
        super(area, length);
    }

    @Override
    protected void draw() {
        System.out.println("三角形的周长为"+super.getArea()+"三角形的面积为"+super.getLength());
    }
}
