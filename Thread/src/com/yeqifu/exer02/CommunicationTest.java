package com.yeqifu.exer02;

/**
 * 实现两个线程交替打印1-100
 * @Author: 落亦-
 * @Date: 2020/2/18 16:34
 */
class CommunicationRunnable implements Runnable{

    private int number = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }
    }
}
public class CommunicationTest {

    public static void main(String[] args) {
        CommunicationRunnable communicationRunnable = new CommunicationRunnable();
        Thread communication01 = new Thread(communicationRunnable);
        Thread communication02 = new Thread(communicationRunnable);
        communication01.setName("线程一");
        communication02.setName("线程二");
        communication01.start();
        communication02.start();
    }


}
