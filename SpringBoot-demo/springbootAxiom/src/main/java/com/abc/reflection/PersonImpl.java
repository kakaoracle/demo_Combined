package com.abc.reflection;

/**
 * @description: 实现类
 * @author: DeZhao Chen
 * @create: 2019-07-06 19:50
 **/
public class PersonImpl implements PersonInterface {

    private  String id;
    private String name;
    private  String age;

    @Override
    public void read() {

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
