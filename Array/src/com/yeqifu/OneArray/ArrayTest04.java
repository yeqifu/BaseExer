package com.yeqifu.OneArray;

/**
 * 算法的考查：数组的复制、反转、查找（线性查找、二分查找）
 * @Author: 落亦-
 * @Date: 2019/12/29 17:24
 */
public class ArrayTest04 {

    public static void main(String[] args) {

        String[] arr = new String[]{"JJ","DD","MM","BB","GG","AA","CC"};

        //数组的复制（区别于数组变量的赋值：arr1 = arr）
        /*String[] arr1 = new String[arr.length];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[i];
        }*/

        //数组的反转
        for (int i = 0; i < (arr.length/2); i++) {
            String temp;
            temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1]=temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }



    }

}
