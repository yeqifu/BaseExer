package com.yeqifu.exer01;

/**
 * 懒汉式单例模式
 * @Author: 落亦-
 * @Date: 2020/2/17 20:32
 */
class Singleton{
    private Singleton(){

    }
    private static Singleton instance = null;

    public static Singleton getInstance(){
        /*synchronized (Singleton.class) {

            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }*/

        if (instance == null) {
            synchronized (Singleton.class) {

                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
public class SingletonTest {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.out.println(instance);
        Singleton instance02 = Singleton.getInstance();
        System.out.println(instance02);

    }

}
