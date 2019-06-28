package com.abc.mybatis;

import com.abc.mybatis.entity.User;
import com.abc.mybatis.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sound.sampled.Line;
import java.util.List;

/**
 * @description: 测试各种条件构造器
 * @author: DeZhao Chen
 * @create: 2019-06-28 16:17
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class 条件构造器 {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test1(){
        //条件:name like '%雨%' and age<40
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name", "雨").lt("age", 40);
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }

    @Test
    public void test2(){
        //条件:name like '王%' and age>40 order by age desc,id asc
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.likeRight("name", "王").or().
                ge("age",25).orderByDesc("age").
                orderByAsc("id");
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }

    //查询出的字段不全部显示即select * 变为select id,name from xxx
    @Test
    public void test3(){
        //注意:1,只能用排除不能用显示某几个字段
        //对主键无效
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name", "王")
                .lt("age",40)
                .select(User.class, info->!info.getColumn().equals("name")&&!info.getColumn().equals("age"));
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }


}



















