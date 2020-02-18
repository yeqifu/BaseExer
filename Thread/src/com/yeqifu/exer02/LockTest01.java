package com.yeqifu.exer02;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用lock解决线程安全问题
 * @Author: 落亦-
 * @Date: 2020/2/18 11:23
 */
class LockRunnable implements Runnable{

    private int ticket = 100;

    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {

        while (true){
            lock.lock();
            try {
                if (ticket>0){
                    System.out.println(Thread.currentThread().getName()+"卖票:票号为"+ticket);
                    ticket--;
                }else {
                    break;
                }
            }finally {
                lock.unlock();
            }

        }

    }
}
public class LockTest01 {
    public static void main(String[] args) {
        LockRunnable lockRunnable = new LockRunnable();
        Thread lockTest01 = new Thread(lockRunnable);
        Thread lockTest02 = new Thread(lockRunnable);
        Thread lockTest03 = new Thread(lockRunnable);
        lockTest01.setName("窗口一");
        lockTest02.setName("窗口二");
        lockTest03.setName("窗口三");

        lockTest01.start();
        lockTest02.start();
        lockTest03.start();

    }

}
