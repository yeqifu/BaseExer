package com.yeqifu.wrapper.exer01;

import java.util.Scanner;
import java.util.Vector;

/**
 * 问题：利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输入结束），找出最高分，并输出学生成绩等级。
 * 若与最高分相差10分内：A等
 *            20分内：B等
 *            30分内：C等
 *            其它：D等
 * @Author: 落亦-
 * @Date: 2020/1/16 10:11
 */
public class Score {
    public static void main(String[] args) {
        System.out.println("请输入学生的成绩，输入负数代表输入结束：");
        Vector v = new Vector();
        boolean flag = true;
        while (flag){
            Scanner scanner = new Scanner(System.in);
            int s = scanner.nextInt();
            if (s<0){
                flag = false;
            }else {
                v.addElement(s);
            }
        }

        Object one = v.elementAt(0);
        int max = (int) one;
        for (int i = 1; i < v.size(); i++) {
            if ((int)v.elementAt(i)>max){
                max = (int) v.elementAt(i);
            }
        }
        System.out.println("最高分为："+max);

        for (int i = 0; i < v.size(); i++) {
            if (max-(int)v.elementAt(i)<10){
                System.out.println("student"+i+"score is "+(int)v.elementAt(i)+"grade is A");
            }else if (max-(int)v.elementAt(i)<20){
                System.out.println("student"+i+"score is "+(int)v.elementAt(i)+"grade is B");
            }else if (max-(int)v.elementAt(i)<30){
                System.out.println("student"+i+"score is "+(int)v.elementAt(i)+"grade is C");
            }else {
                System.out.println("student"+i+"score is "+(int)v.elementAt(i)+"grade is D");
            }

        }


    }
}
