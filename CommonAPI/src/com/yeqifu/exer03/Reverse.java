package com.yeqifu.exer03;

import org.junit.Test;

/**
 * 将一个字符串进行反转。将字符串中指定部分进行反转。
 * 比如“abcdefg”反转为“abfedcg”
 * @Author: 落亦-
 * @Date: 2020/2/20 21:33
 */
public class Reverse {

    @Test
    public static void reverseTest(String str,Integer startIndex,Integer endIndex){
        //1.先将str转换成char[]数组
        char[] charStr = str.toCharArray();
        //2.再将charStr中对应的字符串进行转换
        //2.1声明一个temp中间变量
        char temp;
        for (int i = startIndex-1; i < charStr.length-startIndex ; i++) {
            temp = charStr[i];
            charStr[i] = charStr[charStr.length-i];
            charStr[charStr.length-i] = temp;
        }
        //3.将charStr转换成字符串
        String strReverse = String.valueOf(charStr);
        System.out.println(strReverse);

    }

    public static void main(String[] args) {
        Reverse.reverseTest("abcdefg",3,6);
    }

}
