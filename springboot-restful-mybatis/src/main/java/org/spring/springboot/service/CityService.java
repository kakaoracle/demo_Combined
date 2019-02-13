package org.spring.springboot.service;

import org.spring.springboot.entity.City;
import org.spring.springboot.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CityService {

    @Autowired
    private CityMapper cityMapper;

    public List<City> findAllCity(){
        return cityMapper.findAllCity();
    }

    public City findById(Long id) {
        return cityMapper.findById(id);
    }

    public Long saveCity(City city) {
        return cityMapper.saveCity(city);
    }

    public int updateCity(City city) {
        return cityMapper.updateCity(city);
    }

    public int deleteCity(Long id) {
        return cityMapper.deleteCity(id);
    }
}
