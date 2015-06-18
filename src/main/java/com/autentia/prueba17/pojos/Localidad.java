package com.autentia.prueba17.pojos;

/**
 * Modelizado de la informacion de la tabla localidades Representa una localidad
 * 
 * @author Rodrigo de Blas
 */
public class Localidad {

    /** atirbutos */
    private int id;

    private String nombre;

    /** Constructores */

    /**
     * Constructor vacio
     */
    public Localidad() {

    }

    /**
     * Constructor completo
     * 
     * @param id identificador de la localidad
     * @param nombre nombre de la localidad
     */
    public Localidad(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;

    }

    /**
     * Constructor sin id (se asignara automaticamente)
     * 
     * @param nombre nombre de la localidad
     */
    public Localidad(String nombre) {
        this.nombre = nombre;
    }

    /** getters & setters */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
