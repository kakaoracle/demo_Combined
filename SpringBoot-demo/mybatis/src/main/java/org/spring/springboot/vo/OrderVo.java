package org.spring.springboot.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @description: 订单vo
 * @author: cdz
 * @create: 2019-03-01 22:38
 **/
@Data
@ApiModel("订单vo")
public class OrderVo {
    @ApiModelProperty(value = "创建时间", required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createDate;
    @ApiModelProperty("创建人账号")
    private String creator;
    @ApiModelProperty("创建人姓名")
    private String createdBy;
    @ApiModelProperty("最后更新者姓名")
    private String lastUpdatedBy;
    @ApiModelProperty("最后更新者账号")
    private String lastUpdater;
    @ApiModelProperty("详情voList")
    private List<DetailVo> detailVoList;
}
