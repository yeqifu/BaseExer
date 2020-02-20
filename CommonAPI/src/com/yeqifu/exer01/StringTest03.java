package com.yeqifu.exer01;

import org.junit.Test;

/**
 * 请将str1="abc123" 转换成str2="a21cb3"
 * @Author: 落亦-
 * @Date: 2020/2/20 11:44
 */
public class StringTest03 {

    @Test
    public void test01(){
        String str1 = "abc123";
        char[] chars = str1.toCharArray();
        char temp;
        for (int i = 1; i <=(str1.length()-1)/2; i++) {
            /*if (i<str1.length()/2){*/
                temp = chars[i];
                chars[i] = chars[str1.length()-1-i];
                chars[str1.length()-1-i] = temp;
            /*}*/
        }
        String s = String.valueOf(chars);
        System.out.println(s);
    }
}
