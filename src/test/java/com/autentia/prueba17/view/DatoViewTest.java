package com.autentia.prueba17.view;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.autentia.prueba17.services.CityService;
import com.autentia.prueba17.services.ClimaticDataService;
import com.autentia.prueba17.services.DayTypeService;
import com.autentia.prueba17.view.ClimaticDataView;

/**
 * Test unitario de DatoView
 *
 * @author rodrideblas
 */
public class DatoViewTest {

    ClimaticDataView datoView;

    /** servicios mockeados */

    ClimaticDataService srvDatoClimatologicoMock = Mockito.mock(ClimaticDataService.class);

    CityService srvLocalidadMock = Mockito.mock(CityService.class);

    DayTypeService srvTipoDiaMock = Mockito.mock(DayTypeService.class);

    private List<String> locNamesArrayForTest;

    private List<String> dayNamesArrayForTest;

    @Before
    public void setup() {
        datoView = new ClimaticDataView();
        datoView.setClimaticDataService(srvDatoClimatologicoMock);
        datoView.setCityService(srvLocalidadMock);
        datoView.setDayTypeService(srvTipoDiaMock);

        locNamesArrayForTest = this.getNombresLocalidadArrayForTest();
        dayNamesArrayForTest = this.getNombresTipoDiaArrayForTest();

        Mockito.when(srvLocalidadMock.getAllCityNames()).thenReturn(locNamesArrayForTest);
        Mockito.when(srvTipoDiaMock.getAllDayTypesNames()).thenReturn(dayNamesArrayForTest);

        datoView.loadData();
    }

    @Test
    public void shouldLoadLocsAndDays() {

        Mockito.verify(srvLocalidadMock).getAllCityNames();
        Mockito.verify(srvTipoDiaMock).getAllDayTypesNames();
        assertEquals(locNamesArrayForTest, datoView.getCityNames());
        assertEquals(dayNamesArrayForTest, datoView.getDayTypesNames());

    }

    @Test
    public void shouldSaveDatoClimatologico() {

    }

    protected List<String> getNombresLocalidadArrayForTest() {
        return Arrays.asList("Madrid");

    }

    protected List<String> getNombresTipoDiaArrayForTest() {
        return Arrays.asList("Soleado");
    }
}
