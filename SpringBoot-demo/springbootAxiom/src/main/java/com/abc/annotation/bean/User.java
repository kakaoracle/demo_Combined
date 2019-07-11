package com.abc.annotation.bean;

import com.abc.annotation.GetMethod;
import com.abc.annotation.SetMethod;

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


    @GetMethod("married")
    public boolean isMarried(){
        return married;
    }

    @SetMethod("married")
    public void setMarried(boolean married) {
        this.married = married;
    }

    @GetMethod("name")
    public String getName() {
        return name;
    }

    @SetMethod("name")
    public void setName(String name) {
        this.name = name;
    }

    @GetMethod("age")
    public int getAge() {
        return age;
    }

    @SetMethod("age")
    public void setAge(int age) {
        this.age = age;
    }

    @GetMethod("friends")
    public List<User> getFriends() {
        return friends;
    }

    @SetMethod("friends")
    public void setFriends(List<User> friends) {
        this.friends = friends;
    }





}
