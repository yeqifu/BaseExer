package com.yeqifu.method;

/**
 * 递归方法的使用:
 * 1.递归方法：一个方法体内调用它自身
 * 2.方法递归包含了一种隐式的循环，它会重复执行某段代码，但这种重复执行无须循环控制
 *   递归一定要向已知方向递归，否则这种递归就变成了无穷递归，类似于死循环
 *
 * 问题：求1到n的和
 * @Author: 落亦-
 * @Date: 2020/1/8 11:08
 */
public class RecursionTest05 {

    public static void main(String[] args) {
        RecursionTest05 test05 = new RecursionTest05();
        int sum = test05.recursion(3);
        System.out.println(sum);
    }

    public int recursion(int n){
        if (n==1){
            return 1;
        }else {
            return n+recursion(n-1);
        }
    }

}
