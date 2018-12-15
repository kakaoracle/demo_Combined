package com.iss.Controller;

import com.iss.Domain.City;
import com.iss.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CityController {
    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
    public String findOneCity(Model model, @PathVariable("id") Long id) {
        //这里没有查询数据库,只是返回一个自己定义的实例
        City city1 = new City();
        city1.setCityName("chicago");
        city1.setDescription("great");
        model.addAttribute("cityy", city1);
        return "city";
    }
}
