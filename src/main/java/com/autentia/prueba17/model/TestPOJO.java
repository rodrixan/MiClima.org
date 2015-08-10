package com.autentia.prueba17.model;

/**
 * Modelizado de la informacion de la tabla pruebatabla Representa un dato climatologico
 * 
 * @author Rodrigo de Blas
 */
public class TestPOJO {

    /** atributos */
    private Integer columna1;

    private int id;

    private String columna2;

    /** constructores */
    /**
     * Constructor vacio
     */
    public TestPOJO() {

    }

    /**
     * Constructor
     * 
     * @param id identificador
     * @param columna1 numero
     * @param columna2 cadena
     */
    public TestPOJO(int id, Integer columna1, String columna2) {
        this.id = id;
        this.columna1 = columna1;
        this.columna2 = columna2;
    }

    /** getters & setters */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getColumna1() {
        return columna1;
    }

    public void setColumna1(Integer columna1) {
        this.columna1 = columna1;
    }

    public String getColumna2() {
        return columna2;
    }

    public void setColumna2(String columna2) {
        this.columna2 = columna2;
    }

}
