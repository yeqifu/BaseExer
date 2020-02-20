package com.yeqifu.exer01;

import org.junit.Test;

/**
 * String与基本数据类型、包装类之间的转换
 * String --> 基本数据类型、包装类:调用包装类的静态方法：parseXxx(str)
 * 基本数据类型、包装类 --> String:调用String重载的valueOf(xxx)
 * @Author: 落亦-
 * @Date: 2020/2/20 11:29
 */
public class StringTest02 {

    @Test
    public void test01(){
        String str01 = "123";
        int s = Integer.parseInt(str01);
        System.out.println(s);
        Integer b = Integer.parseInt(str01);
        System.out.println(b);


        int num = 456;
        String c = num+"";
        System.out.println(c);
        Integer num01 = new Integer("789");
        String s1 = String.valueOf(num01);
        System.out.println(s1);
    }


}
