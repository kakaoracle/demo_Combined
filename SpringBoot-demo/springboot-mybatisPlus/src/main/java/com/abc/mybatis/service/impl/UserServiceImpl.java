package com.abc.mybatis.service.impl;

import com.abc.mybatis.entity.User;
import com.abc.mybatis.mapper.UserMapper;
import com.abc.mybatis.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kakaoracle
 * @since 2019-06-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
