package com.autentia.prueba17.mybatis.mappers;

import java.io.Serializable;
import java.util.List;

import com.autentia.prueba17.model.City;

/**
 * Interfaz de uso de LocalidadMapper: Actua sobre la tabla "localidades"
 *
 * @author Rodrigo de Blas
 */
public interface CityMapper extends Serializable {

    City get(int id);

    List<City> getAll();

    List<String> getAllCityNames();
}
