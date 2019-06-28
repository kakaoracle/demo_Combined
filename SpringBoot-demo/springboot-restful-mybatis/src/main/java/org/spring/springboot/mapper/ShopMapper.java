package org.spring.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.spring.springboot.entity.DetailEntity;
import org.spring.springboot.entity.OrderEntity;
import org.spring.springboot.vo.DetailVo;
import org.spring.springboot.vo.OrderVo;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface ShopMapper {
    //新增订单表,此处的返回值int不是主键值,而是插入的行数,>0则表示插入成功
    int createOrder(OrderEntity orderEntity);

    //新增详情表
    int createDetail(@Param("detailEntityList") List<DetailEntity> detailEntityList);

    List<OrderEntity> getOrders(@Param("createdBy") String createdBy, @Param("createDateMin") Date createDateMin, @Param("createDateMax") Date createDateMax);

    OrderEntity getOrderById(Long id);

    List<DetailEntity> getDetailsByOrderId(Long orderId);

    int updateOrder(OrderEntity orderEntity);

    int updateDetail(List<DetailEntity> detailEntityList);

    int deleteDetailByOrderId(@Param("orderId") Long orderId);

    int deleteOrderById(@Param("id") Long id);
    //

}
