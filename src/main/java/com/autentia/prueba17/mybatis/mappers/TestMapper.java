package com.autentia.prueba17.mybatis.mappers;

import java.util.List;

import com.autentia.prueba17.pojos.TestPOJO;

/**
 * Interfaz de uso de TestMapper: Actua sobre la tabla "pruebatabla"
 * 
 * @author Rodrigo de Blas
 */
public interface TestMapper {

    /**
     * Selecciona todos los datos de la tabla
     * 
     * @return lista con testPOJOs
     */
    List<TestPOJO> getAll();

    /**
     * Busca un TestPOJO por id
     * 
     * @param idTestPOJO identificador
     * @return TestPOJO con id asociado
     */
    TestPOJO findById(Long idTestPOJO);

    /**
     * Actualiza la informacion de un TestPOJO
     * 
     * @param TestPOJO objeto con campos modificados
     */
    void update(TestPOJO testPOJO);

    /**
     * Elimina un TestPOJO de la tabla
     * 
     * @param TestPOJO objeto a eliminar
     */
    void remove(TestPOJO testPOJO);

    /**
     * Inserta un TestPOJO en la tabla
     * 
     * @param TestPOJO datos a insertar
     */
    void insert(TestPOJO testPOJO);
}
