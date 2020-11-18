package com.geektime.pojo;

/**
 * @author YangMin
 * @time 2020-11-16 17:06
 */
public class User {

    private int id;
    private String username;
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User() {}

    public User(String username,String phone) {
        this.username = username;
        this.phone = phone;
    }

    public User(int id,String username,String phone) {
        this.id = id;
        this.username = username;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "id: " + this.id + ", username: " + this.username + ", phone: " + this.phone;
    }
}
