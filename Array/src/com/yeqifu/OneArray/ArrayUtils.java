package com.yeqifu.OneArray;

/**
 * @Author: 落亦-
 * @Date: 2020/1/2 16:11
 */
public class ArrayUtils {

    /**
     * 求数组元素的最大值
     * @param arr   需要求最大值的数组
     * @return      该数组中的最大值
     */
    public int getMax(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]>max){
                int temp;
                temp=arr[i];
                arr[i]=max;
                max=temp;
            }
        }
        return max;
    }

    /**
     * 求数组元素的最小值
     * @param arr   需要求最小值的数组
     * @return      该数组中的最小值
     */
    public int getMin(int[] arr){
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]<min){
                int temp;
                temp=arr[i];
                arr[i]=min;
                min=temp;
            }
        }
        return min;
    }

    /**
     * 求数组元素的和
     * @param arr   需要求和的数组
     * @return      数组元素的和
     */
    public int getSum(int[] arr){
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        return sum;
    }


    /**
     * 求数组元素的平均值
     * @param arr   需要求平均值的数组
     * @return      该数组元素的平均值
     */
    public int getAverage(int[] arr){
        ArrayUtils arrayUtils = new ArrayUtils();
        int average = arrayUtils.getSum(arr) / arr.length;
        return average;
    }

    /**
     * 反转数组
     * @param arr   需要反转的数组
     */
    public void reverse(int[] arr){
        for (int i = 0; i < arr.length / 2; i++) {
            int temp;
            temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = arr[i];
        }
    }

    /**
     * 复制数组
     * @param arr   需要复制的数组
     * @return
     */
    public int[] copy(int[] arr){
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i]=arr[i];
        }
        return arr2;
    }

    /**
     * 对数组进行冒泡排序
     * @param arr   需要排序的数组
     */
    public void maopaoSort(int[] arr){


    }

    /**
     * 输出数组
     * @param arr
     */
    public void print(int[] arr){
        for (int num :
                arr) {
            System.out.println(num+", ");
        }
    }

    /**
     * 查找数组
     * @param arr
     * @param dest
     * @return
     */
    public int getIndex(int[] arr,int dest){

        return 0;
    }

}
