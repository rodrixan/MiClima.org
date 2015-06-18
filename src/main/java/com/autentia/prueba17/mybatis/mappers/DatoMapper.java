package com.autentia.prueba17.mybatis.mappers;

import java.io.Serializable;
import java.util.List;

import com.autentia.prueba17.pojos.DatoClimatologico;

/**
 * Interfaz de uso de DatoMapper: Actua sobre la tabla "datos"
 *
 * @author Rodrigo de Blas
 */
public interface DatoMapper extends Serializable {

    /**
     * Inserta un dato en la tabla "datos"
     *
     * @param dato dato a insertar (validado)
     */
    void insertDato(DatoClimatologico dato);

    /**
     * Selecciona un dato por su id
     *
     * @param id identificador del dato a obtener
     * @return dato asociado al id parametro
     */
    DatoClimatologico getDato(int id);

    /**
     * Selecciona todos los datos de la tabla "datos"
     *
     * @return lista de datos (validados y sin validar)
     */
    List<DatoClimatologico> getAll();

    /**
     * Selecciona los datos que esten validados en la tabla "datos"
     *
     * @return lista de datos validados
     */
    List<DatoClimatologico> getAllValidados();

    /**
     * Selecciona los datos ordenados por localidad de la tabla "datos"
     *
     * @return lista de datos ordenada por localidad
     */
    List<DatoClimatologico> getAllOrderLoc();

    /**
     * Selecciona los datos ordenados por temperatura de la tabla "datos"
     *
     * @return lista de datos ordenada por temperatura
     */
    List<DatoClimatologico> getAllOrderTemp();

    /**
     * Selecciona los datos que tengan una cierta localidad de la tabla "datos"
     *
     * @param localidad localidad usada como filtro
     * @return lista de datos cuya localidad sea la deseada
     */
    List<DatoClimatologico> getDatoConLoc(String localidad);
}
