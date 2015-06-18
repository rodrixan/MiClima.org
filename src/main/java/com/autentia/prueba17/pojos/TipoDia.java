package com.autentia.prueba17.pojos;

/**
 * Modelizado de la informacion de la tabla dias Representa un tipo de dia
 *
 * @author Rodrigo de Blas
 */
public class TipoDia {

    /** atributos */
    private int id;

    private String nombreTipo;

    /**
     * Contructor vac�o
     */
    public TipoDia() {

    }

    /**
     * Constructor completo
     *
     * @param id identificador del dia
     * @param nombreTipo tipo de dia (Soleado, Nublado...)
     */
    public TipoDia(int id, String nombreTipo) {
        this.id = id;
        this.nombreTipo = nombreTipo;

    }

    /**
     * Constructor sin id (se asignara automaticamente)
     *
     * @param nomreTipo tipo de dia (Soleado, Nublado...)
     */
    public TipoDia(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    /** getters & setters */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoDia() {
        return nombreTipo;
    }

    public void setTipoDia(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

}
