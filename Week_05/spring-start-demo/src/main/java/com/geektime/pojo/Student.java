package com.geektime.pojo;

import java.io.Serializable;

/**
 * @author YangMin
 * @time 2020-11-17 22:47
 */
public class Student implements Serializable {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void init(){
        System.out.println("\nhello...........");
    }

    @Override
    public String toString() {
        return "id: " + id + ";name: " + name;
    }

}
