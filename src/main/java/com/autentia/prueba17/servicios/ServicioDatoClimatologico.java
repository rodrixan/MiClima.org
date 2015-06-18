package com.autentia.prueba17.servicios;

import java.io.Serializable;
import java.util.List;

import com.autentia.prueba17.pojos.DatoClimatologico;

public interface ServicioDatoClimatologico extends Serializable {

    List<DatoClimatologico> getAll();

    DatoClimatologico get(int id);

    void save(DatoClimatologico datoClimatologico);

    List<DatoClimatologico> getAllValidate();

    List<DatoClimatologico> getAllOrderByLoc();

    List<DatoClimatologico> getAllOrderByTemp();

    List<DatoClimatologico> getAllWithLocalization(String localidad);

}
