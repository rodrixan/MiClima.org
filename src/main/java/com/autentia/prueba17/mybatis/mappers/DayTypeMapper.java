package com.autentia.prueba17.mybatis.mappers;

import java.io.Serializable;
import java.util.List;

import com.autentia.prueba17.model.DayType;

/**
 * Interfaz de uso de DiaMapper: Actua sobre la tabla "dias"
 *
 * @author Rodrigo de Blas
 */
public interface DayTypeMapper extends Serializable {

    DayType get(int id);

    List<DayType> getAll();

    List<String> getAllDayTypesNames();
}
