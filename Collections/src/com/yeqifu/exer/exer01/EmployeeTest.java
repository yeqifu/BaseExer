package com.yeqifu.exer.exer01;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;

import java.util.*;

/**
 * @Author: 落亦-
 * @Date: 2020/2/25 16:02
 */
public class EmployeeTest {

    @Test
    public void test(){
        Employee employee1 = new Employee("luoyi",21,new MyDate(2020,2,25));
        Employee employee2 = new Employee("jiucheng",21,new MyDate(2020,2,24));
        Employee employee3 = new Employee("zhangsan",21,new MyDate(2020,2,23));
        Employee employee4 = new Employee("lili",21,new MyDate(2020,2,22));
        Employee employee5 = new Employee("wangwu",21,new MyDate(2020,2,21));
        Collection set = new TreeSet();
        set.add(employee1);
        set.add(employee2);
        set.add(employee3);
        set.add(employee4);
        set.add(employee5);
        for (Object o : set) {
            System.out.println(o);
        }
    }

    @Test
    public void test2(){
        Employee employee1 = new Employee("luoyi",21,new MyDate(2020,2,25));
        Employee employee2 = new Employee("jiucheng",21,new MyDate(2019,2,24));
        Employee employee3 = new Employee("zhangsan",21,new MyDate(2030,2,23));
        Employee employee4 = new Employee("lili",21,new MyDate(2017,2,22));
        Employee employee5 = new Employee("wangwu",21,new MyDate(2016,2,21));
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee){

                    Employee e1 =(Employee) o1;
                    Employee e2 =(Employee) o2;
                    if (e1.getBirthday().getYear()>e2.getBirthday().getYear()){
                        return -1;
                    }else if (e1.getBirthday().getYear()<e2.getBirthday().getYear()){
                        return 1;
                    }else if (e1.getBirthday().getMonth()>e2.getBirthday().getMonth()){
                        return -1;
                    }else if (e1.getBirthday().getMonth()<e2.getBirthday().getMonth()){
                        return 1;
                    }else if (e1.getBirthday().getDay()>e2.getBirthday().getDay()){
                        return -1;
                    }else if (e1.getBirthday().getDay()<e2.getBirthday().getDay()){
                        return 1;
                    }else {
                        return 0;
                    }
                }else {
                    throw new RuntimeException("传入的数据类型不正确");
                }
            }
        };
        Collection set = new TreeSet(comparator);
        set.add(employee1);
        set.add(employee2);
        set.add(employee3);
        set.add(employee4);
        set.add(employee5);
        for (Object o : set) {
            System.out.println(o);
        }
    }


    @Test
    public void test03(){
        Map<String,Integer> map = new HashMap<>(16);
        map.put("luoyi",21);
        map.put("jiucheng",22);
        for (Map.Entry<String,Integer> o : map.entrySet()) {
            System.out.println(o.getKey()+"----"+o.getValue());
        }
    }


}
