package com.autentia.prueba17.servicios;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.autentia.prueba17.mybatis.mappers.LocalidadMapper;
import com.autentia.prueba17.pojos.Localidad;

public class ServicioLocalidadTest {

    ServicioLocalidad servicio;

    LocalidadMapper localidadMapper = Mockito.mock(LocalidadMapper.class);

    @Before
    public void setup() {
        servicio = new ServicioLocalidadImpl(localidadMapper);

    }

    @Test
    public void shouldReturnAllTipoDia() {
        List<Localidad> localidadArrayForTest = this.getLocalidadArrayForTest();

        Mockito.when(localidadMapper.selectAll()).thenReturn(localidadArrayForTest);

        List<Localidad> allLocalidad = servicio.getAll();

        Assert.assertEquals(allLocalidad, localidadArrayForTest);

        Mockito.verify(localidadMapper, Mockito.times(1)).selectAll();

    }

    @Test
    public void shouldReturnOneTipoDia() {
        Localidad localidadForTest = getLocalidadForTest();

        Mockito.when(localidadMapper.selectLocalidad(0)).thenReturn(localidadForTest);

        Localidad localidad = servicio.get(0);

        Assert.assertEquals(localidad, localidadForTest);

        Mockito.verify(localidadMapper, Mockito.times(1)).selectLocalidad(0);
    }

    @Test
    public void shouldReturnAllNamesForTipoDia() {
        List<String> namesArrayForTest = this.getNombresLocalidadArrayForTest();

        Mockito.when(localidadMapper.selectAllNombres()).thenReturn(namesArrayForTest);

        List<String> allDatoClimatologico = servicio.getAllNombresLocalidad();

        Assert.assertEquals(allDatoClimatologico, namesArrayForTest);

        Mockito.verify(localidadMapper, Mockito.times(1)).selectAllNombres();

    }

    protected Localidad getLocalidadForTest() {
        return new Localidad("Madrid");
    }

    protected List<String> getNombresLocalidadArrayForTest() {
        return Arrays.asList("Madrid");
    }

    protected List<Localidad> getLocalidadArrayForTest() {
        return Arrays.asList(new Localidad());
    }
}
