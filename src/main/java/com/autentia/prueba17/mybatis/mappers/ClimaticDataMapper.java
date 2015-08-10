package com.autentia.prueba17.mybatis.mappers;

import java.io.Serializable;
import java.util.List;

import com.autentia.prueba17.model.ClimaticData;

/**
 * Interfaz de uso de DatoMapper: Actua sobre la tabla "datos"
 *
 * @author Rodrigo de Blas
 */
public interface ClimaticDataMapper extends Serializable {

    void insert(ClimaticData climaticData);

    ClimaticData get(int id);

    List<ClimaticData> getAll();

    List<ClimaticData> getAllValidated();

    List<ClimaticData> getAllOrderByCity();

    List<ClimaticData> getAllOrderByTemperature();

    List<ClimaticData> getAllFilterByCity(String cityName);
}
