package com.hello;

import club.throwable.processor.Builder;

public class Person {

    private Integer age;
    private String name;

    public Integer getAge() {
        return age;
    }

    @Builder
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Builder
    public void setName(String name) {
        this.name = name;
    }
}