package com.abc.依赖注入_非注解.service;


import com.abc.依赖注入_非注解.dao.DemoDao;

/**
 * @description: 实现类
 * @author: DeZhao Chen
 * @create: 2019-07-04 16:04
 **/
public class DemoServiceImpl implements DemoService {
    private DemoDao demoDao;
    private String lightColor;

    public DemoServiceImpl() {
    }

    public DemoDao getDemoDao() {
        System.out.println("+++++ getDemoDao: " + demoDao.toString());
        return demoDao;
    }

    public void setDemoDao(DemoDao demoDao) {
        System.out.println("+++++ setDemoDao: " + demoDao.toString());
        this.demoDao = demoDao;
    }

    public String getLightColor() {
        return lightColor;
    }

    public void setLightColor(String lightColor) {
        this.lightColor = lightColor;
    }

    @Override
    public void greet() {
        demoDao.greet();
    }

    @Override
    public void fly() {
        demoDao.fly();
    }

    @Override
    public void lighting() {
        System.out.println("+++++++++lighting,color is " + lightColor);
    }
}
