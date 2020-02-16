package com.yeqifu.polymorphic.exer01;

/**
 * @Author: 落亦-
 * @Date: 2020/1/14 16:29
 */
public class Graduate extends Student{
    public String major = "IT";
    @Override
    public String getInfo(){
        return "Name:"+name+"\nage:"+age+"\nschool:"+school+"\nmajor:"+major;
    }

}
