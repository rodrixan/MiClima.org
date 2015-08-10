package com.autentia.prueba17.view;

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

import com.autentia.prueba17.model.ClimaticData;
import com.autentia.prueba17.services.CityService;
import com.autentia.prueba17.services.ClimaticDataService;

/**
 * Vista del listado de datos
 *
 * @author Rodrigo de Blas
 */
@ManagedBean(name = "climaticDataListView")
@ViewScoped
public class ClimaticDataListView implements Serializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClimaticDataListView.class);

    private List<ClimaticData> climaticDataList = null;

    private List<ClimaticData> filteredClimaticDataList;

    private List<String> cityNames = null;

    private ClimaticData selectedClimaticData;

    @ManagedProperty("#{cityService}")
    private CityService cityService;

    @ManagedProperty("#{climaticDataService}")
    private ClimaticDataService climaticDataService;

    @PostConstruct
    public void loadData() {
        cityNames = cityService.getAllCityNames();
        climaticDataList = climaticDataService.getAllValidate();
        LOGGER.info("Lectura de base de datos: localidades y datos");
    }

    public void onRowSelectNavigate(SelectEvent event) {
        putSelectedDataInContext(event);

        LOGGER.info("Seleccionado dato con id: {}", selectedClimaticData.getId());

        goToDetailPage();
    }

    private void putSelectedDataInContext(SelectEvent event) {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("datoSeleccionado", event.getObject());
    }

    private void goToDetailPage() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("detalledato.xhtml");
            LOGGER.info("Navegación correcta");
        } catch (final IOException e) {
            LOGGER.error("Fallo en navegación: {}", e);
        }
    }

    /** Getters/Setters */
    public List<ClimaticData> getClimaticDataList() {
        return climaticDataList;
    }

    public void setClimaticDataList(List<ClimaticData> climaticDataList) {
        this.climaticDataList = climaticDataList;
    }

    public List<String> getCityNames() {
        return cityNames;
    }

    public void setCityNames(List<String> cityNames) {
        this.cityNames = cityNames;
    }

    public List<ClimaticData> getFilteredClimaticDataList() {
        return filteredClimaticDataList;
    }

    public void setFilteredClimaticDataList(List<ClimaticData> filteredClimaticDataList) {
        this.filteredClimaticDataList = filteredClimaticDataList;
    }

    public void setClimaticDataService(ClimaticDataService climaticDataService) {
        this.climaticDataService = climaticDataService;
    }

    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    public ClimaticData getSelectedClimaticData() {
        return selectedClimaticData;
    }

    public void setSelectedClimaticData(ClimaticData selectedClimaticData) {
        this.selectedClimaticData = selectedClimaticData;
    }
}
