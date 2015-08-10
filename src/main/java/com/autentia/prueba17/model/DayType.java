package com.autentia.prueba17.model;

/**
 * Modelizado de la informacion de la tabla dias. Representa un tipo de dia
 *
 * @author Rodrigo de Blas
 */
public class DayType {

    private int id;

    private String typeName;

    public DayType() {

    }

    public DayType(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;

    }

    public DayType(String typeName) {
        this.typeName = typeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

}
