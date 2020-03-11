package com.yeqifu.exer;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @Author: 落亦-
 * @Date: 2020/3/5 12:55
 */
public class LambdaTest02 {

    @Test
    public void test(){
        /**
         * 创建了非匿名对象的匿名实现类
         */
        Consumer<Double> consumer = new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println(aDouble);
            }
        };

        consumer.accept(500.0);

        System.out.println("**************************");

        Consumer<Double> consumer1 = aDouble -> System.out.println(aDouble);
        consumer1.accept(600.0);

    }




}
