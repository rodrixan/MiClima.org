package com.autentia.prueba17.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
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
    
    private DatoClimatologico datoSeleccionado;

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
    
    /** Navegacion y muestra de detalle*/
    public void onRowSelectNavigate(SelectEvent event) {  
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("datoSeleccionado", event.getObject());  
        
        LOGGER.info("Seleccionado dato con id: {}",datoSeleccionado.getId());
        
        goToDetailPage();
    }

	private void goToDetailPage() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("detalledato.xhtml");
			LOGGER.info("Navegación correcta");
		} catch (IOException e) {
			LOGGER.error("Fallo en navegación");
		}
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

	public DatoClimatologico getDatoSeleccionado() {
		return datoSeleccionado;
	}

	public void setDatoSeleccionado(DatoClimatologico datoSeleccionado) {
		this.datoSeleccionado = datoSeleccionado;
	}
}
