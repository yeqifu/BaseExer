package com.yeqifu.abstractexer.exer02;

import java.util.Scanner;

/**
 * @Author: 落亦-
 * @Date: 2020/2/11 19:49
 */
public class PayrollSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入当月的月份：");
        int month = scanner.nextInt();
        MyDate myDate01=new MyDate(1999,2,14);
        SalariedEmployee salariedEmployee = new SalariedEmployee("LUOYI",001,myDate01,5000);
        HourlyEmployee hourlyEmployee = new HourlyEmployee("JIUCHENG",002,new MyDate(1999,5,15),30,240);
        Employee[] employees = new Employee[2];
        employees[0]=salariedEmployee;
        employees[1]=hourlyEmployee;
        for (int i = 0;i<employees.length;i++){
            System.out.println(employees[i]);
            double salary = employees[i].earnings();
            if (month==employees[i].getBirthday().getMonth()){
                System.out.println("生日快乐，奖励100元");
                salary = salary+100;
            }

            System.out.println("月工资为："+salary);
        }
    }
}
