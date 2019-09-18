package com.abc.mybatisplus.service;

import com.abc.mybatisplus.entity.User;
import com.abc.mybatisplus.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: DeZhao Chen
 * @create: 2019-09-18 17:40
 **/
@Service
public class UserService extends ServiceImpl<UserMapper,User> {
}
