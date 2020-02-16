package com.yeqifu.method;

/**
 * 重载练习
 * @Author: 落亦-
 * @Date: 2020/1/2 17:31
 */
public class OverloadTest01 {

    public static void main(String[] args) {

        OverloadTest01 overloadTest01 = new OverloadTest01();
        overloadTest01.mOL(5);
        overloadTest01.mOL(8,8);
        overloadTest01.mOL("戒骄戒躁，稳扎稳打");
    }

    public void mOL(int num){
        System.out.println("执行平方的结果为："+num*num);
    }

    public void mOL(int num1,int num2){
        System.out.println("两个数相乘的结果为："+num1*num2);
    }

    public void mOL(String str){
        System.out.println("输出的字符串信息为："+str);
    }


}
