package com.yeqifu.polymorphic.exer01;

/**
 * @Author: 落亦-
 * @Date: 2020/1/14 16:27
 */
public class Student extends Person {
    protected String school = "pku";
    @Override
    public String getInfo(){
        return "Name:"+name+"\nage:"+age+"\nschool:"+school;
    }
}
