package com.yeqifu.exer01;

/**
 * 面试题
 * @Author: 落亦-
 * @Date: 2020/2/19 20:59
 */
public class StringTest01 {
    String str = new String("good");
    char[] ch = {'t','e','s','t'};
    public void change(String str,char ch[]){
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest01 ex = new StringTest01();
        ex.change(ex.str,ex.ch);
        System.out.println(ex.str);
        System.out.println(ex.ch);
    }
}
