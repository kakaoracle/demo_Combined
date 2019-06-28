package org.spring.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: cWX597167
 * @create: 2019-03-03 16:14
 **/
@Data
public class OrderEntity implements Serializable {
    @ApiModelProperty("订单id")
    private Long id;
    @ApiModelProperty("订单编码")
    private String orderCode;
    //@JSONField(format = "yyyy-MM-dd HH:mm:ss")  //FastJson包使用注解,需要在pom中单独添加依赖
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") //Jackson包使用注解,需要在pom中单独添加依赖
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")   //格式化前台日期参数注解
    @ApiModelProperty("预计开始配送时间")
    private Date beginDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("预计结束配送时间")
    private Date endDate;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    @ApiModelProperty("创建人账号")
    private String creator;
    @ApiModelProperty("创建人姓名")
    private String createdBy;
    @ApiModelProperty("最后更新者姓名")
    private String lastUpdatedBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("最后更新时间")
    private Date lastUpdateDate;
    @ApiModelProperty("最后更新者账号")
    private String lastUpdater;
    @ApiModelProperty("订单entityList")
    private List<DetailEntity> detailEntityList;

}
