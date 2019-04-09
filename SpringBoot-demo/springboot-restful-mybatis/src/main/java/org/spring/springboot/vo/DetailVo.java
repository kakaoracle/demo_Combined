package org.spring.springboot.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 详情VO
 * @author: cWX597167
 * @create: 2019-03-01 22:40
 **/
@Data
@ApiModel("详情类")
public class DetailVo {
    @ApiModelProperty(value = "商品名称",required = true)
    private String productName;
    @ApiModelProperty(value = "商品价格",required = true)
    private String productPrice;
    @ApiModelProperty("创建人姓名")
    private String creator;
    @ApiModelProperty("创建人账号")
    private String createdBy;
    @ApiModelProperty("最后更新者账号")
    private String lastUpdatedBy;
    @ApiModelProperty("最后更新者姓名")
    private String lastUpdater;
}
