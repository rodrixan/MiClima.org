package com.autentia.prueba17.servicios;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.autentia.prueba17.mybatis.mappers.DatoMapper;
import com.autentia.prueba17.pojos.DatoClimatologico;

public class ServicioDatoClimatologicoTest {

    ServicioDatoClimatologico servicio;

    DatoMapper datoMapper = Mockito.mock(DatoMapper.class);

    @Before
    public void setup() {
        servicio = new ServicioDatoClimatologicoImpl(datoMapper);

    }

    @Test
    public void shouldReturnAllDatoClimatologico() {
        List<DatoClimatologico> datosArrayForTest = this.getDatosArrayForTest();

        Mockito.when(datoMapper.getAll()).thenReturn(datosArrayForTest);

        List<DatoClimatologico> allDatoClimatologico = servicio.getAll();

        Assert.assertEquals(allDatoClimatologico, datosArrayForTest);

        Mockito.verify(datoMapper, Mockito.times(1)).getAll();

    }

    @Test
    public void shouldReturnOneDatoClimatologico() {
        DatoClimatologico datoForTest = getDatoForTest();

        Mockito.when(datoMapper.getDato(0)).thenReturn(datoForTest);

        DatoClimatologico datoClimatologico = servicio.get(0);

        Assert.assertEquals(datoClimatologico, datoForTest);

        Mockito.verify(datoMapper, Mockito.times(1)).getDato(0);
    }

    @Test
    public void shouldReturnNothing() {
        DatoClimatologico datoForTest = getDatoForTest();

        servicio.save(datoForTest);

        Mockito.verify(datoMapper, Mockito.times(1)).insertDato(datoForTest);

    }

    @Test
    public void shouldReturnAllDatoClimatologicoOrderByLoc() {
        List<DatoClimatologico> datosArrayForTest = this.getDatosArrayForTest();

        Mockito.when(datoMapper.getAllOrderLoc()).thenReturn(datosArrayForTest);

        List<DatoClimatologico> allDatoClimatologico = servicio.getAllOrderByLoc();

        Assert.assertEquals(allDatoClimatologico, datosArrayForTest);

        Mockito.verify(datoMapper, Mockito.times(1)).getAllOrderLoc();

    }

    @Test
    public void shouldReturnAllDatoClimatologicoOrderByTemp() {
        List<DatoClimatologico> datosArrayForTest = this.getDatosArrayForTest();

        Mockito.when(datoMapper.getAllOrderTemp()).thenReturn(datosArrayForTest);

        List<DatoClimatologico> allDatoClimatologico = servicio.getAllOrderByTemp();

        Assert.assertEquals(allDatoClimatologico, datosArrayForTest);

        Mockito.verify(datoMapper, Mockito.times(1)).getAllOrderTemp();

    }

    @Test
    public void shouldReturnAllDatoClimatologicoWithLocalization() {
        List<DatoClimatologico> datosArrayForTest = this.getDatosArrayForTest();
        final String LOC = "Madrid";

        Mockito.when(datoMapper.getDatoConLoc(LOC)).thenReturn(datosArrayForTest);

        List<DatoClimatologico> allDatoClimatologico = servicio.getAllWithLocalization(LOC);

        Assert.assertEquals(allDatoClimatologico, datosArrayForTest);

        Mockito.verify(datoMapper, Mockito.times(1)).getDatoConLoc(LOC);

    }

    protected DatoClimatologico getDatoForTest() {
        Date d = new Date();
        return new DatoClimatologico(true, "Madrid", 10, 10, 10, d, "Soleado");
    }

    protected List<DatoClimatologico> getDatosArrayForTest() {
        return Arrays.asList(new DatoClimatologico());
    }
}
