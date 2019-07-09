package com.abc.loadAndInstanceBean.dao.impl;

import com.abc.loadAndInstanceBean.dao.DemoDao;

/**
 * @description: daoImpl
 * @author: DeZhao Chen
 * @create: 2019-07-03 17:59
 **/
public class DemoDaoImpl implements DemoDao {
    @Override
    public void greet() {
        System.out.println("Hello,World");
    }

    @Override
    public void fly() {
        System.out.println("Let's go to fly");
    }
}
