package com.yeqifu.exer01;

/**
 * @Author: 落亦-
 * @Date: 2020/2/17 19:24
 */
class TicketSecurityThread extends Thread{

    private static int ticket = 100;

    private static Object object = new Object();

    @Override
    public void run() {
        synchronized (object) {
            while (true) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
public class TicketSecurity02 {
    public static void main(String[] args) {
        TicketSecurityThread ticketSecurityThread01 = new TicketSecurityThread();
        TicketSecurityThread ticketSecurityThread02 = new TicketSecurityThread();
        TicketSecurityThread ticketSecurityThread03 = new TicketSecurityThread();
        ticketSecurityThread01.setName("窗口一：");
        ticketSecurityThread02.setName("窗口二：");
        ticketSecurityThread03.setName("窗口三：");

        ticketSecurityThread01.start();
        ticketSecurityThread02.start();
        ticketSecurityThread03.start();
    }
}
