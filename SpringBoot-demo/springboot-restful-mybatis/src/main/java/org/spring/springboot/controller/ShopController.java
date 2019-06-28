package org.spring.springboot.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.java.Log;
import org.spring.springboot.constant.CommonConstant;
import org.spring.springboot.entity.OrderEntity;
import org.spring.springboot.service.ShopService;
import org.spring.springboot.utils.MsgResult;
import org.spring.springboot.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @description: 购买商品
 * @author: cWX597167
 * @create: 2019-03-01 22:53
 **/
@RestController
@Api(tags = "购买商品")
@RequestMapping("/shop")
@Log
public class ShopController {

    @Autowired
    ShopService shopService;

    //增加
    @PostMapping("/createOrder")
    public MsgResult createOrder(
            @ApiParam(value = "订单及详情", required = true) @RequestBody OrderVo orderVo
    ) {
        return shopService.createOrderWithDetail(orderVo);
    }


    //条件查询订单表
    @GetMapping("/getOrders")
    public MsgResult getOrders(
            @ApiParam(value = "创建者姓名", required = false) @RequestParam(value = "createdBy", required = false) String createdBy,
            @ApiParam(value = "创建时间最早时间", required = false) @RequestParam(value = "createDateMin", required = false) String createDateMin,
            @ApiParam(value = "创建时间最晚时间", required = false) @RequestParam(value = "createDateMax", required = false) String createDateMax,
            @ApiParam(value = "页码", required = false) @RequestParam(defaultValue = "1", value = "pageNumber", required = false) int pageNumber,
            @ApiParam(value = "每页数量", required = false) @RequestParam(defaultValue = "10", value = "pageSize", required = false) int pageSize

    ) {
        return shopService.getOrders(createdBy, createDateMin, createDateMax, pageNumber, pageSize);
    }

    //查询某一订单详情
    @GetMapping("/getOrderDetailById/{id}")
    public MsgResult getOrderDetailById(
            @ApiParam(value = "订单id", required = true) @PathVariable(value = "id", required = true) Long id
    ) {
        return shopService.getOrderDetailById(id);
    }

    //更新订单,由于需要id,因此这儿用entity而不用vo
    @PutMapping("/updateOrderDetail")
    public MsgResult updateOrderDetail(
            @ApiParam(value = "订单及详情", required = true) @RequestBody OrderEntity orderEntity
    ) {
        return shopService.updateOrderDetail(orderEntity);
    }

    //删除订单及对应详情
    @DeleteMapping("/deleteOrderDetail/{id}")
    public MsgResult deleteOrderDetail(
            @ApiParam(value = "id", required = true) @PathVariable(value = "id", required = true) Long id
    ) {
        return shopService.deleteOrderDetail(id);
    }


}
