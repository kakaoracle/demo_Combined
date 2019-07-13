package com.abc.annotation.bean;

import com.abc.annotation.CdzGet;

import java.util.List;

/**
 * @description:
 * @author: DeZhao Chen
 * @create: 2019-07-11 10:01
 **/
public class User {
    private  String name;
    private int age;
    private List<User> friends;
    private  boolean married;


    @CdzGet(uuidTest = "cdz")
    public boolean isMarried(){
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    @CdzGet()
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @CdzGet()
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @CdzGet()
    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }





}
