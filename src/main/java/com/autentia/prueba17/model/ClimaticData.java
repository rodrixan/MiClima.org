package com.autentia.prueba17.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Modelizado de la informacion de la tabla datos. Representa un dato climatologico
 *
 * @author Rodrigo de Blas prueba
 */
public class ClimaticData implements Serializable {

    private int id;

    private boolean validated;

    private String cityName;

    private Integer temperature;

    @Min(0)
    @Max(100)
    private Integer humidity;

    @Min(0)
    private Integer precipitation;

    private Date date;

    private String dayTypeName;

    public ClimaticData() {
    }

    public ClimaticData(boolean validated, String cityName, int temperature, int humidity, int precipitation, Date date,
            String dayTypeName) {
        this.validated = validated;
        this.cityName = cityName;
        this.temperature = temperature;
        this.humidity = humidity;
        this.precipitation = precipitation;
        this.setFecha(date);
        this.dayTypeName = dayTypeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isValidado() {
        return validated;
    }

    public void setValidado(boolean validated) {
        this.validated = validated;
    }

    public String getLocalidad() {
        return cityName;
    }

    public void setLocalidad(String cityName) {
        this.cityName = cityName;
    }

    public Integer getTemperatura() {
        return temperature;
    }

    public void setTemperatura(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getHumedad() {
        return humidity;
    }

    public void setHumedad(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getPrecipitacion() {
        return precipitation;
    }

    public void setPrecipitacion(Integer precipitation) {
        this.precipitation = precipitation;
    }

    public Date getFecha() {

        return (date != null) ? new Date(date.getTime()) : null;
    }

    public void setFecha(Date date) {
        this.date = (date != null) ? new Date(date.getTime()) : null;
    }

    public String getTipoDia() {
        return dayTypeName;
    }

    public void setTipoDia(String dayTypeName) {
        this.dayTypeName = dayTypeName;
    }

    @Override
    public String toString() {

        final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        return validatedToString() + ";" + cityName + ";" + df.format(date) + ";" + dayTypeName;
    }

    private String validatedToString() {
        if (validated) {
            return "validado";
        }
        return "no validado";
    }

    public static class ClimaticDataBuilder {

        private boolean validated;

        private String cityName;

        private Integer temperature;

        private Integer humidity;

        private Integer precipitation;

        private Date date;

        private String dayTypeName;

        public static ClimaticDataBuilder anInstance() {
            return new ClimaticDataBuilder();
        }

        public ClimaticDataBuilder setValidated(boolean validated) {
            this.validated = validated;
            return this;

        }

        public ClimaticDataBuilder setCityName(String cityName) {
            this.cityName = cityName;
            return this;
        }

        public ClimaticDataBuilder setTemperature(int temperature) {
            this.temperature = temperature;
            return this;
        }

        public ClimaticDataBuilder setHumidity(int humidity) {
            this.humidity = humidity;
            return this;
        }

        public ClimaticDataBuilder setPrecipitation(int precipitation) {
            this.precipitation = precipitation;
            return this;
        }

        public ClimaticDataBuilder setDate(Date date) {
            this.date = new Date(date.getTime());
            return this;
        }

        public ClimaticDataBuilder setDayTypeName(String dayTypeName) {
            this.dayTypeName = dayTypeName;
            return this;
        }

        public ClimaticData build() {
            return new ClimaticData(validated, cityName, temperature, humidity, precipitation, date, dayTypeName);
        }
    }

}
