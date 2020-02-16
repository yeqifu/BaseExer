package com.yeqifu.method;

/**
 * 可变参数
 * @Author: 落亦-
 * @Date: 2020/1/2 20:37
 */
public class ClassTest03 {

    public static void main(String[] args) {

        ClassTest03 classTest03 = new ClassTest03();
        classTest03.show("走过的路","每一步都算数","戒骄戒躁","稳扎稳打");
        classTest03.show(new String[]{"走过的路","每一步都算数","戒骄戒躁","稳扎稳打"});

    }

    /**
     * 其实JDK 5.0提供的可变参数实际上就是一个数组
     * @param str
     */
    public void show(String ... str){
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]+", ");
        }
    }

    /*public void show(String[] str){
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]+", ");
        }
    }*/


}
