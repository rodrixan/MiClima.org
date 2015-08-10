package com.autentia.prueba17.services;

import java.io.Serializable;
import java.util.List;

import com.autentia.prueba17.model.City;

public interface CityService extends Serializable {

    List<City> getAll();

    City get(int id);

    List<String> getAllCityNames();

}
