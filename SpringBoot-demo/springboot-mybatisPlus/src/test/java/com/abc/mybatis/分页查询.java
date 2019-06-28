package com.abc.mybatis;

import com.abc.mybatis.entity.User;
import com.abc.mybatis.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description: 分页查询
 * @author: DeZhao Chen
 * @create: 2019-06-28 17:00
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class 分页查询 {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test1(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.ge("age",26);
        //第0页和第1页都是一样的,都是开头的一页
        Page<User> page = new Page<>(1, 2);
        IPage<User> userIPage = userMapper.selectPage(page, wrapper);
        System.out.println("总页数:"+userIPage.getPages()+",总记录数:"+userIPage.getTotal()+",结果:"+userIPage.getRecords());
    }

}











