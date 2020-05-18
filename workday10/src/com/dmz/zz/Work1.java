package com.dmz.zz;

public class Work1 {
    public static void main(String[] args) {
        Student[] students = new Student[5];
        double sum = 0;
        double average = 0;
        double min = 0;
        double max = 0;
        Student student1 = new Student(1, "一", "男", 20, 60);
        Student student2 = new Student(2, "二", "男", 20, 70);
        Student student3 = new Student(3, "三", "男", 20, 80);
        Student student4 = new Student(4, "四", "男", 20, 90);
        Student student5 = new Student(5, "五", "男", 20, 100);
        students[0] = student1;
        students[1] = student2;
        students[2] = student3;
        students[3] = student4;
        students[4] = student5;

        for (int i = 0; i < students.length; i++) {
            min = students[0].java;
            max = students[0].java;
            if (students[i].java > max) {
                max = students[i].java;

            }
            if (students[i].java < min) {
                min = students[i].java;

            }
            sum = sum + students[i].java;

        }
        average = sum / 5.0;

        System.out.println("最低分：" + min);
        System.out.println("最高分：" + max);
        System.out.println("平均分：" + average);

    }
}
