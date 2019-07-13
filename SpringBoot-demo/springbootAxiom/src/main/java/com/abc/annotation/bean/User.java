package com.abc.annotation.bean;

import com.abc.annotation.CdzGet;


/**
 * @description:
 * @author: DeZhao Chen
 * @create: 2019-07-11 10:01
 **/
public class User {
    private int age;
    @CdzGet
    private  String name;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


}
