package com.yeqifu.object.exer02;

/**
 * @Author: 落亦-
 * @Date: 2020/1/15 10:06
 */
public class MyDate {

    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj instanceof MyDate){
            MyDate o = (MyDate)obj;
            return this.day == o.day&&this.month == o.month&&this.year ==o.year;
        }
        return false;
    }
}
