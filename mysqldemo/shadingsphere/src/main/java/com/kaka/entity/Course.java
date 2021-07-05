package com.kaka.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("course")
public class Course {
    private Long cid;
    private String cname;
    private Long user_id;
    private String cstatus;
}
