package com.yeqifu.OneArray;

/**
 * 给一个数组 arr 里面的元素分别为 34，5，22，-98，6，-76，0，-3
 * 求22在此数组中的索引，未找到则返回未找到
 * @Author: 落亦-
 * @Date: 2019/12/30 11:24
 */
public class ArrayTest05 {
    public static void main(String[] args) {

        int[] arr = new int[]{34,5,22,-98,6,-76,0,-3};
        int dest =22;
        int i;
        for (i = 0; i < arr.length; i++) {
            if (dest==arr[i]){
                System.out.println(i);
                break;
            }
        }
        if (i==arr.length){
            System.out.println("未找到");
        }


    }
}
