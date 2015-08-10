package com.autentia.prueba17.model;

/**
 * Modelizado de la informacion de la tabla localidades. Representa una localidad
 * 
 * @author Rodrigo de Blas
 */
public class City {

    private int id;

    private String name;


    public City() {

    }


    public City(int id, String name) {
        this.id = id;
        this.name = name;

    }


    public City(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
