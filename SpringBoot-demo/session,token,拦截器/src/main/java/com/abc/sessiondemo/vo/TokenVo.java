package com.abc.sessiondemo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: DeZhao Chen
 * @create: 2019-09-09 18:21
 **/
@Data
public class TokenVo implements Serializable {
    String userName;
    String password;
    String userId;
}
