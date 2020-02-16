package com.yeqifu.Class;

/**
 * @Author: 落亦-
 * @Date: 2020/1/1 9:57
 */
public class ClassTest02 {

    public static void main(String[] args) {
        Person person = new Person();
        person.name="luoyi";
        person.age=20;
        person.sex=1;
        person.study();
        person.showAge();
        person.addAge(2);
        person.showAge();

        Person person2 = new Person();
        person.name="luoyi";
        person.age=20;
        person.sex=1;
        person.study();
        person.showAge();
        person.addAge(2);
    }
}

class Person {

    String name;
    int age;
    int sex;

    public void study(){
        System.out.println("studying");
    }

    public void showAge(){
        System.out.println("年龄是："+age);
    }

    public int addAge(int i){
        age +=i;
        return age;
    }



}