package com.yeqifu.OneArray;

/**
 * 对于char型数组 arr  sout(arr)不会输出数组 arr 的引用而是输出数组 arr 的全部元素的值。
 * 想要输出数组 arr 的地址，只需让数组 arr 和字符串做并置运算即可。
 * @Author: 落亦-
 * @Date: 2019/12/30 17:50
 */
public class ArrayTest06 {

    public static void main(String[] args) {

        char[] arr = {'斯','嘉','丽'};

        System.out.println(arr);
        System.out.println(""+arr);

    }

}
