package com.yeqifu.Class;

/**
 * @Author: 落亦-
 * @Date: 2020/1/1 9:34
 */
public class ClassTest01 {

    public static void main(String[] args) {
        Student student = new Student();
        student.say("luoyi",20,"Java开发工程师","看有趣的电影");

        Teacher teacher = new Teacher();
        teacher.say("雷俊丰",35,10,"Java");
    }
}

class Student{
    String name;
    int age;
    String major;
    String interests;
    void say(String name,int age,String major,String interests){
        System.out.println("学生"+name+",今年"+age+"岁，工作是"+major+",兴趣是"+interests);



    }
}

class Teacher{
    String name;
    int age;
    int teachAge;
    String course;
    void say(String name,int age,int teachAge,String course){
        System.out.println("老师"+name+",今年"+age+"岁，教龄"+age+"年,教授的课程是"+course);
    }
}