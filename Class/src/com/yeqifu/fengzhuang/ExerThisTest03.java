package com.yeqifu.fengzhuang;

/**
 * @Author: 落亦-
 * @Date: 2020/1/9 10:13
 */
public class ExerThisTest03 {

    public static void main(String[] args) {

        Boy boy = new Boy("罗密欧",20);
        boy.shout();
        Girl girl = new Girl("朱丽叶",18);
        girl.marry(boy);

        Girl girl1 = new Girl("祝英台",19);
        int compare = girl.compare(girl1);
        if (compare>0){
            System.out.println(girl.getName()+"大");
        }else if (compare<0){
            System.out.println(girl1.getName()+"大");
        }else {
            System.out.println("一样大");
        }

    }

}

class Boy{
    private String name;
    private int age;

    public Boy(){

    }

    public Boy(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String i){
        this.name=i;
    }

    public String getName(){
        return name;
    }

    public void setAge(int i){
        this.age = i;
    }

    public int getAge(){
        return age;
    }

    public void marry(Girl girl){
        System.out.println("我想娶"+girl.getName());
    }

    public void shout(){
        if (this.age>=22){
            System.out.println("你可以去合法登记结婚了！");
        }else {
            System.out.println("非法!");
        }
    }

}

class Girl{
    private String name;
    private int age;

    public Girl(){

    }

    public Girl(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String i){
        this.name = i;
    }

    public String getName(){
        return name;
    }

    public void marry(Boy boy){
        System.out.println("我想嫁给"+boy.getName());
        boy.marry(this);
    }

    /**
     * 比较两个对象的大小
     * @param girl  传递过来的女孩对象
     * @return      正数：当前对象大    负数：当前对象小    0：当前对象与形参对象相等
     */
    public int compare(Girl girl){
        return this.age-girl.age;
    }
}
