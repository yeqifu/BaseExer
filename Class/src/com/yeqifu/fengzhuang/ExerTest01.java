package com.yeqifu.fengzhuang;

/**
 * @Author: 落亦-
 * @Date: 2020/1/8 16:37
 */
public class ExerTest01 {
    public static void main(String[] args) {
        Person b = new Person();
//        b.setAge(150);
        Person c = new Person("Tom",20);
        int age1 = c.getAge();

        System.out.println(age1+"   "+c.getName());
        int age = b.getAge();
        System.out.println(age);
    }
}
class Person{
    private int age;
    private String name;

    public Person(){
        age=18;
    }
    public Person(String n,int a){
        name=n;
        age=a;
    }

    public void setAge(int i){
        if (i>=0&&i<=130){
            age=i;
        }else {
            System.out.println("年龄非法");
            return;
        }
    }
    public int getAge(){
        return age;
    }

    public void setName(String n){
        name=n;
    }

    public String getName(){
        return name;
    }

}
