package com.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("人员vo")
public class Person {
    @ApiModelProperty(value = "姓名",required = false)
    private String name;
    @ApiModelProperty(value = "性别",required = true)
    private String sex;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
