package com.autentia.prueba17.mybatis.mappers;

import java.io.Serializable;
import java.util.List;

import com.autentia.prueba17.pojos.Localidad;

/**
 * Interfaz de uso de LocalidadMapper: Actua sobre la tabla "localidades"
 *
 * @author Rodrigo de Blas
 */
public interface LocalidadMapper extends Serializable {

    /**
     * Selecciona una localidad por su id
     *
     * @param id identificador de la localidad
     * @return dia asociado al id
     */
    Localidad selectLocalidad(int id);

    /**
     * Selecciona todas las localidades de la tabla "localidades"
     *
     * @return lista de localidades
     */
    List<Localidad> selectAll();

    /**
     * Selecciona los nombres de localidades de la tabla "localidades"
     *
     * @return lista de nombres de las localidades
     */
    List<String> selectAllNombres();
}
