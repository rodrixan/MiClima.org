package com.autentia.prueba17.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autentia.prueba17.model.City;
import com.autentia.prueba17.mybatis.mappers.CityMapper;

@Service("cityService")
public class CityServiceImpl implements CityService {

    private final CityMapper cityMapper;

    @Autowired
    public CityServiceImpl(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    @Override
    public City get(int id) {
        return cityMapper.get(id);
    }

    @Override
    public List<City> getAll() {
        return cityMapper.getAll();
    }

    @Override
    public List<String> getAllCityNames() {
        return cityMapper.getAllCityNames();
    }

}
