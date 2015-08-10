package com.autentia.prueba17.view;

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

import com.autentia.prueba17.model.ClimaticData;
import com.autentia.prueba17.services.CityService;
import com.autentia.prueba17.services.ClimaticDataService;
import com.autentia.prueba17.services.DayTypeService;

/**
 * Vista de un dato
 *
 * @author Rodrigo de Blas
 */
@ManagedBean(name = "climaticDataView")
@RequestScoped
public class ClimaticDataView implements Serializable {

    private static final String REQ_MSG = "Campo requerido";

    public static final String OK_MSG = "Dato añadido con éxito";

    public static final String ERR_MSG = "No se ha podido añadir el dato";

    private static final Logger LOGGER = LoggerFactory.getLogger(ClimaticDataView.class);

    /** dato a guardar (tiene que ser valido) */
    @Valid
    private ClimaticData climaticData;

    /** listas de ciudades y tipos de dias */
    private List<String> cityNames;

    private List<String> dayTypesNames;

    @ManagedProperty("#{cityService}")
    private CityService cityService;

    @ManagedProperty("#{dayTypeService}")
    private DayTypeService dayTypeService;

    @ManagedProperty("#{climaticDataService}")
    private ClimaticDataService climaticDataService;

    public ClimaticDataView() {
    }

    @PostConstruct
    protected void loadData() {
        // vacio para rellenar por el form.
        climaticData = new ClimaticData();

        // servicios para localidades y tipo de dias
        cityNames = cityService.getAllCityNames();

        dayTypesNames = dayTypeService.getAllDayTypesNames();

        LOGGER.info("Lectura de base de datos: localidades y tipos dia");
    }

    public void insertClimaticData() {
        climaticDataService.insert(climaticData);
        LOGGER.info("Almacenamieto de dato climatologico en base de datos: {}", climaticData);
        showSuccess();
    }

    private void showSuccess() {
        final FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, OK_MSG, climaticData.toString());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /** Getters/Setters */

    public ClimaticData getClimaticData() {
        return climaticData;
    }

    public void setClimaticData(ClimaticData climaticData) {
        this.climaticData = climaticData;
    }

    public String getReqMsg() {
        return REQ_MSG;
    }

    public List<String> getCityNames() {
        return cityNames;
    }

    public void setCityNames(List<String> cityNames) {
        this.cityNames = cityNames;
    }

    public List<String> getDayTypesNames() {
        return dayTypesNames;
    }

    public void setDayTypesNames(List<String> dayTypesNames) {
        this.dayTypesNames = dayTypesNames;
    }

    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    public void setDayTypeService(DayTypeService dayTypeService) {
        this.dayTypeService = dayTypeService;
    }

    public void setClimaticDataService(ClimaticDataService climaticDataService) {
        this.climaticDataService = climaticDataService;
    }
}
