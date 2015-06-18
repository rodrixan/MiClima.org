package com.autentia.prueba17.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autentia.prueba17.pojos.DatoClimatologico;
import com.autentia.prueba17.servicios.ServicioDatoClimatologico;
import com.autentia.prueba17.servicios.ServicioLocalidad;
import com.autentia.prueba17.servicios.ServicioTipoDia;

/**
 * Vista de un dato
 *
 * @author Rodrigo de Blas
 */
@ManagedBean(name = "datoView")
@RequestScoped
public class DatoView implements Serializable {

    private static final String REQ_MSG = "Campo requerido";

    public static final String OK_MSG = "Dato añadido con éxito";

    public static final String ERR_MSG = "No se ha podido añadir el dato";

    private static final Logger LOGGER = LoggerFactory.getLogger(DatoView.class);

    /** dato valido a guardar */
    @Valid
    private DatoClimatologico datoClimatologico;

    /** flag para verificacion */
    private boolean error = true;

    /** listas de ciudades y tipos de dias */
    private List<String> localidades;

    private List<String> tipodias;

    @ManagedProperty("#{servicioLocalidad}")
    private ServicioLocalidad servicioLocalidad;

    @ManagedProperty("#{servicioTipoDia}")
    private ServicioTipoDia srvTipoDia;

    @ManagedProperty("#{servicioDatoClimatologico}")
    private ServicioDatoClimatologico srvDatoClimatologico;

    /** contructores y m�todos */

    /**
     * Constructor vacio: Crea un dato y recoge las posibles localidades y dias
     */
    public DatoView() {
        error = true;
    }

    /**
     * Crea un dato y carga las listas de localidades y tipos de dia
     */
    @PostConstruct
    protected void init() {
        // vacio para rellenar por el form.
        datoClimatologico = new DatoClimatologico();

        // servicios para localidades y tipo de dias
        localidades = servicioLocalidad.getAllNombresLocalidad();

        tipodias = srvTipoDia.getAllTiposDia();

        LOGGER.info("Lectura de base de datos: localidades y tipos dia");
    }

    /**
     * Guarda un dato ya valido en la base de datos
     */
    public void saveDato() {
        srvDatoClimatologico.save(datoClimatologico);
        LOGGER.info("Almacenamieto de dato climatologico en base de datos: {}", datoClimatologico);
        showSuccess();
    }

    private void showSuccess() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, OK_MSG, datoClimatologico.toString());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /** Getters/Setters */

    public DatoClimatologico getDatoClimatologico() {
        return datoClimatologico;
    }

    public void setDato(DatoClimatologico datoClimatologico) {
        this.datoClimatologico = datoClimatologico;
    }

    public String getReqMsg() {
        return REQ_MSG;
    }

    public List<String> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(List<String> localidades) {
        this.localidades = localidades;
    }

    public List<String> getTipodias() {
        return tipodias;
    }

    public void setTipodias(List<String> tipodias) {
        this.tipodias = tipodias;
    }

    public boolean isError() {
        return error;
    }

    protected void setError(boolean error) {
        this.error = error;
    }

    public void setServicioLocalidad(ServicioLocalidad servicioLocalidad) {
        this.servicioLocalidad = servicioLocalidad;
    }

    public void setSrvTipoDia(ServicioTipoDia srvTipoDia) {
        this.srvTipoDia = srvTipoDia;
    }

    public void setSrvDatoClimatologico(ServicioDatoClimatologico srvDatoClimatologico) {
        this.srvDatoClimatologico = srvDatoClimatologico;
    }
}
