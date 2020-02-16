package com.yeqifu.polymorphic.exer01;

/**
 * @Author: 落亦-
 * @Date: 2020/1/14 16:31
 */
public class InstanceTest {
    public static void main(String[] args) {
        InstanceTest test = new InstanceTest();
        test.method(new Graduate());
        test.method(new Student());
        test.method(new Person());
    }
    public void method(Person e){
        System.out.println(e.getInfo());
        if (e instanceof Graduate){
            System.out.println("a graduated student");
            System.out.println("a student");
            System.out.println("a person");
            System.out.println("======================");
        }else if (e instanceof Student){
            System.out.println("a student");
            System.out.println("a person");
            System.out.println("======================");
        }else if (e instanceof Person){
            System.out.println("a person");
        }
    }
}
