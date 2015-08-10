package com.autentia.prueba17.services;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.autentia.prueba17.model.City;
import com.autentia.prueba17.mybatis.mappers.CityMapper;
import com.autentia.prueba17.services.CityService;
import com.autentia.prueba17.services.CityServiceImpl;

public class ServicioLocalidadTest {

    CityService servicio;

    CityMapper localidadMapper = Mockito.mock(CityMapper.class);

    @Before
    public void setup() {
        servicio = new CityServiceImpl(localidadMapper);

    }

    @Test
    public void shouldReturnAllTipoDia() {
        List<City> localidadArrayForTest = this.getLocalidadArrayForTest();

        Mockito.when(localidadMapper.getAll()).thenReturn(localidadArrayForTest);

        List<City> allLocalidad = servicio.getAll();

        Assert.assertEquals(allLocalidad, localidadArrayForTest);

        Mockito.verify(localidadMapper, Mockito.times(1)).getAll();

    }

    @Test
    public void shouldReturnOneTipoDia() {
        City localidadForTest = getLocalidadForTest();

        Mockito.when(localidadMapper.get(0)).thenReturn(localidadForTest);

        City localidad = servicio.get(0);

        Assert.assertEquals(localidad, localidadForTest);

        Mockito.verify(localidadMapper, Mockito.times(1)).get(0);
    }

    @Test
    public void shouldReturnAllNamesForTipoDia() {
        List<String> namesArrayForTest = this.getNombresLocalidadArrayForTest();

        Mockito.when(localidadMapper.getAllCityNames()).thenReturn(namesArrayForTest);

        List<String> allDatoClimatologico = servicio.getAllCityNames();

        Assert.assertEquals(allDatoClimatologico, namesArrayForTest);

        Mockito.verify(localidadMapper, Mockito.times(1)).getAllCityNames();

    }

    protected City getLocalidadForTest() {
        return new City("Madrid");
    }

    protected List<String> getNombresLocalidadArrayForTest() {
        return Arrays.asList("Madrid");
    }

    protected List<City> getLocalidadArrayForTest() {
        return Arrays.asList(new City());
    }
}
