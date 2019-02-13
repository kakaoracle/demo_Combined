package org.spring.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.spring.springboot.entity.City;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: cWX597167
 * @create: 2019-02-13 22:49
 **/
@Mapper
@Repository//不用repository的话,服务层会有红色提示未注入
public interface CityMapper {
    //查
    public City findById(@Param("id")Long id);
    //查
    public List<City> findAllCity();
    //增
    public Long saveCity(City city);
    //改
    public int updateCity(City city);
    //删
    public int deleteCity(@Param("id")Long id);

}
