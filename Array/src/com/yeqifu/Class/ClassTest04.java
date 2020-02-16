package com.yeqifu.Class;

import java.util.Random;

/**
 * 4. 对象数组题目： 定义类Student，包含三个属性：学号number(int)，年级state(int)，成绩 score(int)。
 * 创建20个学生对象，学号为1到20，年级和成绩都由随机数确定。
 * 问题一：打印出3年级(state值为3）的学生信息。
 * 问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息
 * @Author: 落亦-
 * @Date: 2020/1/2 8:27
 */
public class ClassTest04 {

    public static void main(String[] args) {

        Students[] students = new Students[20];

        for (int i = 0; i < students.length; i++) {
            //给数组元素赋值
            students[i] = new Students();
            //给Students对象的属性赋值
            students[i].number = i+1;

            Random random = new Random();

            students[i].state = random.nextInt(3)+1;
            students[i].score = random.nextInt(101);
        }

        ClassTest04 classTest04 = new ClassTest04();
        classTest04.print(students);

        System.out.println("============================");

        classTest04.printState(students,3);

        System.out.println("============================");

        classTest04.maopaoSort(students);

        classTest04.print(students);
    }

    /**
     * 遍历Students[]数组
     * @param students  Students[]数组对象
     */
    public void print(Students[] students){

        for (int i = 0; i < students.length; i++) {
            System.out.println("学号为："+students[i].number+",班级为："+students[i].state+",分数为："+students[i].score);
        }
    }

    /**
     * 输出年级等于state的所有学生
     * @param students  学生对象
     * @param state     年级
     */
    public void printState(Students[] students,int state){
        for (int j = 0; j < students.length; j++) {
            if (state==students[j].state){
                System.out.println("学号为："+students[j].number+",班级为："+students[j].state+",分数为："+students[j].score);
            }
        }
    }

    /**
     * 对Students[]进行冒泡排序
     * @param students  需要进行冒泡排序的数组
     */
    public void maopaoSort(Students[] students){
        for (int j = 0; j < students.length-1; j++) {
            for (int k = 0; k < students.length-1-j; k++) {
                if (students[k].score>students[k+1].score){

                    //交换的是学生，不是成绩
                    Students temp;
                    temp = students[k];
                    students[k] = students[k+1];
                    students[k+1] = temp;
                }
            }
        }
    }

}

class Students{

    int number;
    int state;
    int score;

}