package com.abc.mybatisplus;

import com.abc.mybatisplus.entity.User;
import com.abc.mybatisplus.mapper.UserMapper;
import com.abc.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisplusApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Test
    public void contextLoads() {
        List<User> userList = userMapper.selectList(null);//条件为null时查询所有数据
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setAge(14);
        user.setName("东方不败");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    //测试自定义的mapper方法
    public void testInsert1(){
        User user = userMapper.select1();
        System.out.println(user);
    }


    //测试从service层进行调用,并用wrapper构造器进行排序
    @Autowired
    UserService userService;
    @Test
    public void testService(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_time");
        List<User> list = userService.list(wrapper);
        System.out.println(list);
    }


    //测试分页查询
    @Test
    public void testPageService(){
        Page<User> page = new Page<>(1,1);
        IPage<User> userIPage = userMapper.selectPage(page, null);
        System.out.println(userIPage);

    }


}
