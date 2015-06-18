package com.autentia.prueba17.mybatis.mappers;

import java.io.Serializable;
import java.util.List;

import com.autentia.prueba17.pojos.TipoDia;

/**
 * Interfaz de uso de DiaMapper: Actua sobre la tabla "dias"
 *
 * @author Rodrigo de Blas
 */
public interface DiaMapper extends Serializable {

    /**
     * Selecciona un tipo de dia por su id
     *
     * @param id identificador del tipo de dia
     * @return dia asociado al id
     */
    TipoDia selectDia(int id);

    /**
     * Selecciona todos los dias de la tabla "dias"
     *
     * @return lista de dias
     */
    List<TipoDia> selectAll();

    /**
     * Selecciona los nombres de dias de la tabla "dias"
     *
     * @return lista de nombres de los tipos de dias
     */
    List<String> selectAllNombres();
}
