package com.dmz;

public class Work1 {
    public static void main(String[] args) {
        double x = ShowComputer.compute(new Compute() {
                                            @Override
                                            public double compute(double a, double b) {
                                                return a + b;
                                            }
                                        }, 1, 2

        );

        System.out.println("实现加法" + x);


        double y = ShowComputer.compute(new Compute() {
                                            @Override
                                            public double compute(double a, double b) {
                                                return a * b;
                                            }
                                        }, 1, 2

        );

        System.out.println("实现乘法" + y);

    }
}

interface Compute {
    double compute(double a, double b);
}

class ShowComputer {
    static double compute(Compute com, double a, double b) {
        return com.compute(a, b);
    }
}