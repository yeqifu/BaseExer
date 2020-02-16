package com.yeqifu.OneArray;

/**
 * 问题：创建一个长度为6的int型数组，要求数组元素的值都在1-30之间，且是随机赋值。
 *      同时，要求元素的值各不相同。
 * @Author: 落亦-
 * @Date: 2019/12/29 10:45
 */
public class ArrayExer02 {


    public static void main(String[] args) {
        //1.动态初始化一个int型的数组
        int[] arr = new int[6];
        int total = arr.length;

        int num = (int) (Math.random()*29+1);
        arr[0] = num;

        for (int i = 1; i < total; i++) {
            //2.生成1-30的随机数
            int num2 = (int) (Math.random()*29+1);
            //给arr[i]赋值
            arr[i]=num2;
            //从arr[1]开始就要对比是否有重复
            for (int j = 0; j < i-1; j++) {
                int num3 = (int)(Math.random()*29+1);
                if (arr[i]==arr[i-1]){
                    arr[i] = num3;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }




}
