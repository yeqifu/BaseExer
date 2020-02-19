package com.yeqifu.exer05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: 落亦-
 * @Date: 2020/2/19 13:07
 */
class NumberThread1 implements Runnable{

    private int number = 100;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+":"+number);
            number--;
        }
    }
}

class NumberThread02 implements Runnable{
    private int number = 100;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+":"+number);
            number--;
        }
    }
}
public class ThreadPool {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor)service;
        service.execute(new NumberThread1());
        service.execute(new NumberThread02());
        service.shutdown();
    }


}
