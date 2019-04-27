package org.spring.springboot.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.db.sql.Order;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.java.Log;
import org.spring.springboot.constant.CommonConstant;
import org.spring.springboot.entity.DetailEntity;
import org.spring.springboot.entity.OrderEntity;
import org.spring.springboot.mapper.ShopMapper;
import org.spring.springboot.utils.DateUtils;
import org.spring.springboot.utils.MsgResult;
import org.spring.springboot.vo.DetailVo;
import org.spring.springboot.vo.OrderVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: 购物
 * @author: cWX597167
 * @create: 2019-03-01 23:09
 **/
@Service
@Log
public class ShopService {

    @Autowired
    ShopMapper shopMapper;

    //用了事务,如果下面的sql语句有一句发生错误,那么之前所有的都不生效
    @Transactional
    public MsgResult createOrderWithDetail(OrderVo orderVo) {
        int createDatailResult = 0;
        int createOrderResult = 0;
        OrderEntity orderEntity = new OrderEntity();
        DetailEntity detailEntity = new DetailEntity();
        List<DetailEntity> detailEntityList = new ArrayList<>();
        BeanUtils.copyProperties(orderVo,orderEntity);
        //生成固定格式(开头为IMF)随机字符串
        orderEntity.setOrderCode("ORDER"+ IdUtil.fastSimpleUUID().substring(0,15));
        orderEntity.setBeginDate(DateUtils.parseStringToDate("2018-01-01 00:00:00"));
        orderEntity.setEndDate(DateUtils.parseStringToDate("2018-03-06 09:08:00"));
        //插入后的entity中的id字段会自动填充
        log.info("**2orderEntity:"+orderEntity);
        createOrderResult = shopMapper.createOrder(orderEntity);
        //isEmpty用来判断null与空字符串,isBlank用来判断null与多个空字符串
        if (null != orderVo.getDetailVoList()){
            for (DetailVo item : orderVo.getDetailVoList()){
                BeanUtils.copyProperties(item,detailEntity);
                log.info("***用了beanUtils后复制完成后:"+detailEntity);
                detailEntity.setOrderId(orderEntity.getId());
                detailEntity.setDetailCode("DETAIL"+IdUtil.fastSimpleUUID().substring(0,13));
                detailEntityList.add(detailEntity);
            }
            log.info("***detailEntityList为:"+detailEntityList);
            createDatailResult = shopMapper.createDetail(detailEntityList);
        }
        if (createDatailResult > 0 || createOrderResult > 0){
            return MsgResult.build(CommonConstant.HTTP_CODE_OK, CommonConstant.HTTP_STATUS_OK);
        }else {
            log.info("插入失败");
            return MsgResult.build(CommonConstant.HTTP_Code_NO_CONTENT,CommonConstant.HTTP_STATUS_NO_CONTENT);
        }
    }

    public MsgResult getOrders(String createdBy, String createDateMin, String createDateMax, int pageNumber, int pageSize) {
        //下面如果有两个查询,那么只能会对第一个查询起到分页效果
        PageHelper.startPage(pageNumber,pageSize);
        log.info("***最后的查询条件为:createdBy:"+createdBy+",max:"+DateUtils.parseStringToDate(createDateMax)+",min:"+DateUtils.parseStringToDate(createDateMin));
        List<OrderEntity> orderEntityList = shopMapper.getOrders(createdBy, DateUtils.parseStringToDate(createDateMin), DateUtils.parseStringToDate(createDateMax));
        PageInfo<OrderEntity> pageInfo = new PageInfo<OrderEntity>(orderEntityList);
        return MsgResult.build(CommonConstant.HTTP_CODE_OK,CommonConstant.HTTP_STATUS_OK,pageInfo);
    }

    public MsgResult getOrderDetailById(Long id) {
        OrderEntity orderEntity = shopMapper.getOrderById(id);
        List<DetailEntity> detailEntityList = shopMapper.getDetailsByOrderId(id);
        orderEntity.setDetailEntityList(detailEntityList);
        return MsgResult.build(CommonConstant.HTTP_CODE_OK,CommonConstant.HTTP_STATUS_OK,orderEntity);
    }

    @Transactional
    public MsgResult updateOrderDetail(OrderEntity orderEntity) {
        log.info("***接收到的orderEntity是:"+orderEntity);
        int updateOrderResult = shopMapper.updateOrder(orderEntity);
        int deleteDetailResult = shopMapper.deleteDetailByOrderId(orderEntity.getId());
        //因为订单可能会减少,因此订单可以更新,但是详情表一般没有更新,只有删除与插入
        List<DetailEntity> detailEntityList = orderEntity.getDetailEntityList();
        DetailEntity detailEntity = new DetailEntity();
        List<DetailEntity> detailEntityList1 = new ArrayList<>();
        if (detailEntityList != null){
            for (DetailEntity detail : detailEntityList){
                BeanUtil.copyProperties(detail,detailEntity);
                detailEntity.setOrderId(orderEntity.getId());
                detailEntity.setDetailCode("DETAIL"+IdUtil.fastSimpleUUID().substring(0,13));
                detailEntityList1.add(detailEntity);
            }
        }
        log.info("**将要插入的详情List:"+detailEntityList1);
        int createDetailResult = shopMapper.createDetail(detailEntityList1);

        if (updateOrderResult > 0 && deleteDetailResult > 0 && createDetailResult > 0){
            return MsgResult.build(CommonConstant.HTTP_CODE_OK,CommonConstant.HTTP_STATUS_OK);
        }else{
            return MsgResult.build(CommonConstant.HTTP_Code_NO_CONTENT,CommonConstant.HTTP_STATUS_NO_CONTENT);
        }

    }

    @Transactional
    public MsgResult deleteOrderDetail(Long id) {
        int deleteOrderResult = shopMapper.deleteOrderById(id);
        int deleteDetailResult = shopMapper.deleteDetailByOrderId(id);
        if (deleteDetailResult > 0 && deleteOrderResult > 0){
            return MsgResult.build(CommonConstant.HTTP_CODE_OK,CommonConstant.HTTP_STATUS_OK);
        }else {
            return MsgResult.build(CommonConstant.HTTP_Code_NO_CONTENT,CommonConstant.HTTP_STATUS_NO_CONTENT);
        }
    }
}
