package com.autentia.prueba17.services;

import java.io.Serializable;
import java.util.List;

import com.autentia.prueba17.model.ClimaticData;

public interface ClimaticDataService extends Serializable {

    List<ClimaticData> getAll();

    ClimaticData get(int id);

    void insert(ClimaticData datoClimatologico);

    List<ClimaticData> getAllValidate();

    List<ClimaticData> getAllOrderByLoc();

    List<ClimaticData> getAllOrderByTemp();

    List<ClimaticData> getAllWithLocalization(String localidad);

}
