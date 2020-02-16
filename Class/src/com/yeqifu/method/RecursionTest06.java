package com.yeqifu.method;

/**
 * 问题：已知有一个数列：f(0)=1,f(1)=4,f(n+2)=2*f(n+1)+f(n)
 *      其中n是大于0的整数，求f(10)的值
 * @Author: 落亦-
 * @Date: 2020/1/8 11:31
 */
public class RecursionTest06 {
    public static void main(String[] args) {
        RecursionTest06 test06 = new RecursionTest06();
        int result = test06.getResult(10);
        System.out.println(result);
    }
    public int getResult(int n){
        if (0==n){
            return 1;
        }else if (n==1){
            return 4;
        }else {
            return 2*getResult(n-1)+getResult(n-2);

        }
    }
}
