package com.yeqifu.exer;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @Author: 落亦-
 * @Date: 2020/2/29 10:31
 */
public class ReflectTest {

    @Test
    public void test01() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //获取Class实例    方法一：通过.class
        Class<Person> clazz = Person.class;
        System.out.println(clazz);

        //获取Class实例    方法二：调用Class的静态方法：forName(String classPath)
        Class clazz2 = Class.forName("com.yeqifu.exer.Person");
        System.out.println(clazz2);


        //获取Class实例    方法三：使用类的加载器
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        Class clazz3 = classLoader.loadClass("com.yeqifu.exer.Person");
        System.out.println(clazz3);

        System.out.println(clazz==clazz2);
        System.out.println(clazz==clazz3);
        System.out.println(clazz2==clazz3);


        Person o = clazz.newInstance();
        System.out.println(o);


    }





}
