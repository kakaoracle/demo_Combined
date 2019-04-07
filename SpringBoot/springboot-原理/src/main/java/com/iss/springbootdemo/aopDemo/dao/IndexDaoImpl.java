package com.iss.springbootdemo.aopDemo.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: cWX597167
 * @create: 2019-04-07 08:54
 **/
@Component
@Repository
public class IndexDaoImpl implements IndexDao {
    @Override
    public void query() {
        System.out.println("dao---query");
    }
}
