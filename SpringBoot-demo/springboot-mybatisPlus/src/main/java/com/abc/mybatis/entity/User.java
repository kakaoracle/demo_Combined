package com.abc.mybatis.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description: 数据库实体类
 * @author: DeZhao Chen
 * @create: 2019-06-28 14:13
 **/
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Long managerId;
    private LocalDateTime createTime;
}
