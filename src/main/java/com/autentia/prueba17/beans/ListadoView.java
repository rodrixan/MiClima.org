package com.autentia.prueba17.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autentia.prueba17.pojos.DatoClimatologico;
import com.autentia.prueba17.servicios.ServicioDatoClimatologico;
import com.autentia.prueba17.servicios.ServicioLocalidad;

/**
 * Vista del listado de datos
 *
 * @author Rodrigo de Blas
 */
@ManagedBean(name = "listadoView")
@ViewScoped
public class ListadoView implements Serializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ListadoView.class);

    private List<DatoClimatologico> listaDatosClimatologicos = null;

    private List<DatoClimatologico> listaDatosFiltrada;

    private List<String> localidades = null;

    @ManagedProperty("#{servicioLocalidad}")
    private ServicioLocalidad servicioLocalidad;

    @ManagedProperty("#{servicioDatoClimatologico}")
    private ServicioDatoClimatologico servicioDatoClimatologico;

    /** Metodos */
    @PostConstruct
    public void init() {
        localidades = servicioLocalidad.getAllNombresLocalidad();
        listaDatosClimatologicos = servicioDatoClimatologico.getAllValidate();
        LOGGER.info("Lectura de base de datos: localidades y datos");
    }

    /** Getters/Setters */
    public List<DatoClimatologico> getListaDatosClimatologicos() {
        return listaDatosClimatologicos;
    }

    public void setListaDatosClimatologicos(List<DatoClimatologico> listaDatosClimatologicos) {
        this.listaDatosClimatologicos = listaDatosClimatologicos;
    }

    public List<String> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(List<String> localidades) {
        this.localidades = localidades;
    }

    public List<DatoClimatologico> getListaDatosFiltrada() {
        return listaDatosFiltrada;
    }

    public void setListaDatosFiltrada(List<DatoClimatologico> listaDatosFiltrada) {
        this.listaDatosFiltrada = listaDatosFiltrada;
    }

    public void setServicioDatoClimatologico(ServicioDatoClimatologico servicioDatoClimatologico) {
        this.servicioDatoClimatologico = servicioDatoClimatologico;
    }

    public void setServicioLocalidad(ServicioLocalidad servicioLocalidad) {
        this.servicioLocalidad = servicioLocalidad;
    }
}
