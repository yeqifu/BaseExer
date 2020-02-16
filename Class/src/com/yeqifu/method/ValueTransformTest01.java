package com.yeqifu.method;

/**
 * 问题描述：定义一个int型数组：int[] arr = new int[]{12,3,3,34,56,77,432};
 *         让数组的每个位置上的值去除以首位置的元素，得到的结果作为该位置上的新值。遍历新的数组
 * @Author: 落亦-
 * @Date: 2020/1/7 10:21
 */
public class ValueTransformTest01 {

    public static void main(String[] args) {
        int[] arr = new int[]{12,3,3,34,56,77,432};
        int[] arr2 = new int[arr.length];
        int i = 0;
        while (i<arr.length){
            int s = arr[i] / arr[0];
            arr2[i] = s;
            i++;
        }
        for (int num : arr2) {
            System.out.println(num);
        }




    }

}
