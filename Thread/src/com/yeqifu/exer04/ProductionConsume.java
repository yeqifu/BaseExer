package com.yeqifu.exer04;

/**
 * 生产者(Productor)将产品交给店员(Clerk),而消费者(Customer)从店员处取走产品，店员一次只能持有
 * 固定数量的产品(比如：20),如果生产者试图生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品
 * 了在通知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来
 * 取走产品。
 * @Author: 落亦-
 * @Date: 2020/2/18 18:34
 */
class Clerk{

    public int productCount = 0;

    /**
     * 生产产品
     */
    public synchronized void produceProduct() {
        while (true){
            if (productCount<20) {
                productCount++;
                System.out.println(Thread.currentThread().getName() + "生产产品:" + productCount);
                notify();
            }else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 消费产品
     */
    public synchronized void customeProduct() {
        while (true) {
            if (productCount>0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread.yield();
                System.out.println(Thread.currentThread().getName() + "消费产品:" + productCount);
                productCount--;
                notify();
            }else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

/**
 * 生产者
 */
class Productor extends Thread{

    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true){
            clerk.produceProduct();
        }

    }
}

/**
 * 消费者
 */
class Customer extends Thread{
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        clerk.customeProduct();
    }
}



public class ProductionConsume {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor productor01 = new Productor(clerk);
        Customer customer01 = new Customer(clerk);

        productor01.setName("生产者一");
        customer01.setName("消费者一");
        productor01.start();
        customer01.start();

    }

}
