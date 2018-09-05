package org.spring.springboot.dao;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.City;

import java.util.List;

/**
 * 城市 DAO 接口类
 */
public interface CityDao {

    /**
     * 获取全部城市信息列表
     */
    List<City> findAllCity();

    /**
     * 根据城市 ID，获取城市信息
     @Param()作用,一是不用的话入参就只能有一个,且是javabean,如果有多个必须用@param.
     */
    City findById(@Param("id") Long id);

    Long saveCity(City city);

    Long updateCity(City city);

    Long deleteCity(Long id);
}
