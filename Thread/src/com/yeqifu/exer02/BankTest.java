package com.yeqifu.exer02;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: 落亦-
 * @Date: 2020/2/18 13:44
 */
class Account implements Runnable{
    private int total = 0;

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        try {
            for (int i = 0; i < 3; i++) {
                total+=1000;
                System.out.println("账户余额为："+total);
            }
        }finally {
            lock.unlock();
        }
    }

}

public class BankTest {

    public static void main(String[] args) {

        Account account = new Account();
        Thread account01 = new Thread(account);
        Thread account02 = new Thread(account);
        account01.setName("账户一：");
        account02.setName("账户二：");
        account01.start();
        account02.start();

    }
}
