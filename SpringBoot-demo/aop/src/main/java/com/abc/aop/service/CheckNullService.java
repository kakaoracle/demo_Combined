package com.abc.aop.service;

import com.abc.aop.annotation.CheckNull;
import com.abc.aop.vo.Param;
import org.springframework.stereotype.Service;

@Service
public class CheckNullService {

    @CheckNull
    public void test(String nullVal, @CheckNull(group="test") Param param) {
        System.out.println(param);
    }
}
