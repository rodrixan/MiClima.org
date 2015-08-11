package com.autentia.prueba17.services;

import java.io.Serializable;
import java.util.List;

import com.autentia.prueba17.model.ClimaticData;

public interface ClimaticDataService extends Serializable {

    List<ClimaticData> getAll();

    ClimaticData get(int id);

    void insert(ClimaticData climaticData);

    List<ClimaticData> getAllValidate();

}
