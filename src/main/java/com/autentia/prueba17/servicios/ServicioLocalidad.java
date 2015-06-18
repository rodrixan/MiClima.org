package com.autentia.prueba17.servicios;

import java.io.Serializable;
import java.util.List;

import com.autentia.prueba17.pojos.Localidad;

public interface ServicioLocalidad extends Serializable {

    List<Localidad> getAll();

    Localidad get(int id);

    List<String> getAllNombresLocalidad();

}
