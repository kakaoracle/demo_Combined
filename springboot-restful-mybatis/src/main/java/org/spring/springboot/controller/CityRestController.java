package org.spring.springboot.controller;

import org.spring.springboot.entity.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *restful的增删改查由请求报文中的请求方式决定,分别是put,delete,post,get
 put与post都是需要用requestbody的,因为新增与修改往往都需要很多的参数
 */
@RestController
@RequestMapping("/city")
public class CityRestController {

    @Autowired
    private CityService cityService;
    //pathVariable:接收路径参数
    //requestParam:接收拼接参数
    //requestBody:接收实体类
    @GetMapping(value = "/findOneCity/{id}")
    public City findOneCity(@PathVariable("id") Long id) {
        return cityService.findById(id);
    }

    @GetMapping(value = "/findAllCity")
    public List<City> findAllCity() {
        return cityService.findAllCity();
    }

    @PostMapping(value = "/createCity")
    public void createCity(@RequestBody City city) {
        cityService.saveCity(city);
    }

    @PutMapping(value = "/updateCity")
    public void updateCity(@RequestBody City city) {
        cityService.updateCity(city);
    }

    @DeleteMapping(value = "/deleteCity/{id}")
    public void deleteCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
    }
}
