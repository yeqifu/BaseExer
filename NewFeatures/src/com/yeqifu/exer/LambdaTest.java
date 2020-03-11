package com.yeqifu.exer;

import org.junit.Test;
import java.util.Comparator;

/**
 * @Author: 落亦-
 * @Date: 2020/3/5 11:33
 */
public class LambdaTest {

    @Test
    public void test01(){
        System.out.println("*************普通写法*********************");
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        System.out.println(comparator.compare(12, 13));

        System.out.println("*************Lambda表达式写法*******************");

        Comparator<Integer> comparator1 = (o1,o2) -> o1.compareTo(o2);
        System.out.println(comparator1.compare(12, 11));

        System.out.println("***************方法引用写法************************");

        Comparator<Integer> comparator2 = Integer::compare;
        System.out.println(comparator2.compare(12, 11));


    }
}
