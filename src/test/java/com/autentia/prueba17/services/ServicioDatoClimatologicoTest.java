package com.autentia.prueba17.services;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.autentia.prueba17.model.ClimaticData;
import com.autentia.prueba17.mybatis.mappers.ClimaticDataMapper;
import com.autentia.prueba17.services.ClimaticDataService;
import com.autentia.prueba17.services.ClimaticDataServiceImpl;

public class ServicioDatoClimatologicoTest {

    ClimaticDataService servicio;

    ClimaticDataMapper datoMapper = Mockito.mock(ClimaticDataMapper.class);

    @Before
    public void setup() {
        servicio = new ClimaticDataServiceImpl(datoMapper);

    }

    @Test
    public void shouldReturnAllDatoClimatologico() {
        List<ClimaticData> datosArrayForTest = this.getDatosArrayForTest();

        Mockito.when(datoMapper.getAll()).thenReturn(datosArrayForTest);

        List<ClimaticData> allDatoClimatologico = servicio.getAll();

        Assert.assertEquals(allDatoClimatologico, datosArrayForTest);

        Mockito.verify(datoMapper, Mockito.times(1)).getAll();

    }

    @Test
    public void shouldReturnOneDatoClimatologico() {
        ClimaticData datoForTest = getDatoForTest();

        Mockito.when(datoMapper.get(0)).thenReturn(datoForTest);

        ClimaticData datoClimatologico = servicio.get(0);

        Assert.assertEquals(datoClimatologico, datoForTest);

        Mockito.verify(datoMapper, Mockito.times(1)).get(0);
    }

    @Test
    public void shouldReturnNothing() {
        ClimaticData datoForTest = getDatoForTest();

        servicio.insert(datoForTest);

        Mockito.verify(datoMapper, Mockito.times(1)).insert(datoForTest);

    }

    @Test
    public void shouldReturnAllDatoClimatologicoOrderByLoc() {
        List<ClimaticData> datosArrayForTest = this.getDatosArrayForTest();

        Mockito.when(datoMapper.getAllOrderByCity()).thenReturn(datosArrayForTest);

        List<ClimaticData> allDatoClimatologico = servicio.getAllOrderByLoc();

        Assert.assertEquals(allDatoClimatologico, datosArrayForTest);

        Mockito.verify(datoMapper, Mockito.times(1)).getAllOrderByCity();

    }

    @Test
    public void shouldReturnAllDatoClimatologicoOrderByTemp() {
        List<ClimaticData> datosArrayForTest = this.getDatosArrayForTest();

        Mockito.when(datoMapper.getAllOrderByTemperature()).thenReturn(datosArrayForTest);

        List<ClimaticData> allDatoClimatologico = servicio.getAllOrderByTemp();

        Assert.assertEquals(allDatoClimatologico, datosArrayForTest);

        Mockito.verify(datoMapper, Mockito.times(1)).getAllOrderByTemperature();

    }

    @Test
    public void shouldReturnAllDatoClimatologicoWithLocalization() {
        List<ClimaticData> datosArrayForTest = this.getDatosArrayForTest();
        final String LOC = "Madrid";

        Mockito.when(datoMapper.getAllFilterByCity(LOC)).thenReturn(datosArrayForTest);

        List<ClimaticData> allDatoClimatologico = servicio.getAllWithLocalization(LOC);

        Assert.assertEquals(allDatoClimatologico, datosArrayForTest);

        Mockito.verify(datoMapper, Mockito.times(1)).getAllFilterByCity(LOC);

    }

    protected ClimaticData getDatoForTest() {
        Date d = new Date();
        return new ClimaticData(true, "Madrid", 10, 10, 10, d, "Soleado");
    }

    protected List<ClimaticData> getDatosArrayForTest() {
        return Arrays.asList(new ClimaticData());
    }
}
