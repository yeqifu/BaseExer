package com.yeqifu.exer.exer02;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 落亦-
 * @Date: 2020/3/6 11:21
 */
public class ArrayListTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(9);
        list.add(99);
        System.out.println(list.get(2));
    }
}
