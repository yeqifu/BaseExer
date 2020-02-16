package com.yeqifu.OneArray;

/**
 * 对数组进行复制
 * @Author: 落亦-
 * @Date: 2019/12/29 17:10
 */
public class ArrayTest02 {

    public static void main(String[] args) {
        int[] array1,array2;
        array1=new int[]{2,3,5,7,11,13,17,19};
        array2 = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            array2[i]=array1[i];
        }

        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i]+"\t");
        }


        ArrayUtils arrayUtils = new ArrayUtils();
        int[] copy = arrayUtils.copy(array1);
        for (int num :
                copy) {
            System.out.print(num+",");
        }

    }

}
