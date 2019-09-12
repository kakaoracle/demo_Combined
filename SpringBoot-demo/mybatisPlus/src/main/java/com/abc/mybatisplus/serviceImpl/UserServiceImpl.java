package com.abc.mybatisplus.serviceImpl;

import com.abc.mybatisplus.entity.User;
import com.abc.mybatisplus.mapper.UserMapper;
import com.abc.mybatisplus.service.UserSerice;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 陈德照123
 * @since 2019-09-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserSerice {

}
