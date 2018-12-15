package com.iss.Service;

import com.iss.Domain.City;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CityService {
    public List<City> findAllCity();

    public City findCityById(Long id);

    public Long saveCity(City city);

    public Long updateCity(City city);

    public Long deleteCity(Long id);

}
