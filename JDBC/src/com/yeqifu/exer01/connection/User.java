package com.yeqifu.exer01.connection;

/**
 * @Author: 落亦-
 * @Date: 2020/3/12 11:53
 */
public class User {
    private String name;
    private String password;

    public User() {
    }

    public User(String name, String password) {
        super();
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", password=" + password + "]";
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

}
