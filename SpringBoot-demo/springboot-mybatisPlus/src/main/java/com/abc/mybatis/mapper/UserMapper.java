package com.abc.mybatis.mapper;

import com.abc.mybatis.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kakaoracle
 * @since 2019-06-28
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

}
