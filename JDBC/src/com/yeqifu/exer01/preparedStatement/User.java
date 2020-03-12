package com.yeqifu.exer01.preparedStatement;

import java.util.Date;

/**
 * @Author: 落亦-
 * @Date: 2020/3/12 17:56
 */
public class User {
    private Integer id;
    private String name;
    private String password;
    private Integer age;
    private String comment;
    private Date birthday;

    public User() {
    }

    public User(Integer id, String name, String password, Integer age, String comment,Date birthday) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.comment = comment;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", comment='" + comment + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
