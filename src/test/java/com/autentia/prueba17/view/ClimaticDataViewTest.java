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

/**
 * Test unitario de DatoView
 *
 * @author rodrideblas
 */
public class ClimaticDataViewTest {

    ClimaticDataView climaticDataViewForTest;

    ClimaticDataService mockedClimaticDataService = Mockito.mock(ClimaticDataService.class);

    CityService mockedCityService = Mockito.mock(CityService.class);

    DayTypeService mockedDayTypeService = Mockito.mock(DayTypeService.class);

    private List<String> cityNamesForTest;

    private List<String> dayTypeNamesForTest;

    @Before
    public void setup() {
        climaticDataViewForTest = new ClimaticDataView();
        climaticDataViewForTest.setClimaticDataService(mockedClimaticDataService);
        climaticDataViewForTest.setCityService(mockedCityService);
        climaticDataViewForTest.setDayTypeService(mockedDayTypeService);

        cityNamesForTest = this.getCityNamesArrayForTest();
        dayTypeNamesForTest = this.getDayTypeNamesArrayForTest();

        Mockito.when(mockedCityService.getAllCityNames()).thenReturn(cityNamesForTest);
        Mockito.when(mockedDayTypeService.getAllDayTypesNames()).thenReturn(dayTypeNamesForTest);

        climaticDataViewForTest.loadData();
    }

    @Test
    public void shouldLoadLocsAndDays() {

        Mockito.verify(mockedCityService).getAllCityNames();
        Mockito.verify(mockedDayTypeService).getAllDayTypesNames();
        assertEquals(cityNamesForTest, climaticDataViewForTest.getCityNames());
        assertEquals(dayTypeNamesForTest, climaticDataViewForTest.getDayTypesNames());

    }

    protected List<String> getCityNamesArrayForTest() {
        return Arrays.asList("Madrid");

    }

    protected List<String> getDayTypeNamesArrayForTest() {
        return Arrays.asList("Soleado");
    }
}
