package com.autentia.prueba17.pojos;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Modelizado de la informacion de la tabla datos Representa un dato climatologico
 *
 * @author Rodrigo de Blas
 * prueba
 */
public class DatoClimatologico implements Serializable {

    /** atributos */
    private int id;

    private boolean validado;

    private String localidad;

    private Integer temperatura;

    @Min(0)
    @Max(100)
    private Integer humedad;

    @Min(0)
    private Integer precipitacion;

    private Date fecha;

    private String tipodia;

    /** Constructores */

    /**
     * Constructor vacio
     */
    public DatoClimatologico() {
    }

    /**
     * Constructor sin id (se asignara automaticamente)
     *
     * @param validado si el dato esta validado o no
     * @param localidad nombre de la localidad del dato
     * @param temperatura temperatura en �C asociada al dato
     * @param humedad % de humedad del dato
     * @param precipitacion precipitacion en mm asociada al dato
     * @param fecha fecha del dato
     * @param tipodia tipo de dia del dato (Soleado, Nublado...)
     */
    public DatoClimatologico(boolean validado, String localidad, int temperatura, int humedad, int precipitacion,
            Date fecha, String tipodia) {
        super();
        this.validado = validado;
        this.localidad = localidad;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.precipitacion = precipitacion;
        this.setFecha(fecha);
        this.tipodia = tipodia;
    }

    /** getters & setters */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Integer getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Integer temperatura) {
        this.temperatura = temperatura;
    }

    public Integer getHumedad() {
        return humedad;
    }

    public void setHumedad(Integer humedad) {
        this.humedad = humedad;
    }

    public Integer getPrecipitacion() {
        return precipitacion;
    }

    public void setPrecipitacion(Integer precipitacion) {
        this.precipitacion = precipitacion;
    }

    public Date getFecha() {
  
        return (fecha != null) ? new Date(fecha.getTime()) : null;
    }

    public void setFecha(Date fecha) {
        this.fecha = (fecha != null) ? new Date(fecha.getTime()) : null;
    }

    public String getTipodia() {
        return tipodia;
    }

    public void setTipodia(String tipodia) {
        this.tipodia = tipodia;
    }

    /**
     * Representacion de un dato en cadena de texto
     */
    @Override
    public String toString() {
        // formato de fecha a mostrar
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        // para no mostrar true/false
        String val = (validado) ? "validado" : "no validado";

        return val + ";" + localidad + ";" + df.format(fecha) + ";" + tipodia;
    }

    public static class DatoClimatologicoBuilder {

        private boolean validado;

        private String localidad;

        private Integer temperatura;

        private Integer humedad;

        private Integer precipitacion;

        private Date fecha;

        private String tipodia;

        public static DatoClimatologicoBuilder anInstance() {
            return new DatoClimatologicoBuilder();
        }

        public DatoClimatologicoBuilder setValidado(boolean validado) {
            this.validado = validado;
            return this;

        }

        public DatoClimatologicoBuilder setLocalidad(String localidad) {
            this.localidad = localidad;
            return this;
        }

        public DatoClimatologicoBuilder setTemperatura(int temperatura) {
            this.temperatura = temperatura;
            return this;
        }

        public DatoClimatologicoBuilder setHumedad(int humedad) {
            this.humedad = humedad;
            return this;
        }

        public DatoClimatologicoBuilder setPrecipitacion(int precipitacion) {
            this.precipitacion = precipitacion;
            return this;
        }

        public DatoClimatologicoBuilder setFecha(Date fecha) {
            this.fecha = new Date(fecha.getTime());
            return this;
        }

        public DatoClimatologicoBuilder setTipoDia(String tipodia) {
            this.tipodia = tipodia;
            return this;
        }

        public DatoClimatologico build() {
            return new DatoClimatologico(validado, localidad, temperatura, humedad, precipitacion, fecha, tipodia);
        }
    }

}
