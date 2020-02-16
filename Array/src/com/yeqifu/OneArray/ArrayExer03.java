package com.yeqifu.OneArray;

import java.util.Random;

/**
 * 定义一个int型的一维数组，包含10个元素，分别赋一些随机整数，然后求出所有元素的最大值、最小值,和值,平均值
 * 要求：所有随机数都是两位数
 * @Author: 落亦-
 * @Date: 2019/12/29 15:52
 */
public class ArrayExer03 {

    public static void main(String[] args) {

        //1.动态初始化一个拥有10个元素的一维数组
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            Random random = new Random();
            int num = random.nextInt(90)+10;
            arr[i]=num;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
        System.out.println();

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j]>arr[j+1]){
                    int temp;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.print("排序之后的数组元素为：");
        for (int s : arr) {
            System.out.print(s+"\t");
        }

        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum +=arr[i];
        }
        double average = sum/arr.length;

        System.out.println("该数组所有元素最大值为："+arr[arr.length-1]);
        System.out.println("该数组所有元素最小值为："+arr[0]);
        System.out.println("该数组所有元素的和为："+sum);
        System.out.println("该数组所有元素的平均值为："+average);

    }

}
