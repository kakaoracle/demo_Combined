package org.spring.springboot.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 详情entity
 * @author: cdz
 * @create: 2019-03-03 16:14
 **/
@Data
public class DetailEntity implements Serializable {

    @ApiModelProperty("索引id")
    private Long id;
    @ApiModelProperty("订单ID")
    private Long orderId;
    @ApiModelProperty("详情编号")
    private String detailCode;
    @ApiModelProperty("商品名称")
    private String productName;
    @ApiModelProperty("商品价格")
    private String productPrice;
    @ApiModelProperty("创建人姓名")
    private String creator;
    @ApiModelProperty("创建人账号")
    private String createdBy;
    @ApiModelProperty("最后更新者账号")
    private String lastUpdatedBy;
    @ApiModelProperty("最后更新时间")
    private String lastUpdateDate;
    @ApiModelProperty("最后更新者姓名")
    private String lastUpdater;
}
