package com.autentia.prueba17.servicios;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.autentia.prueba17.mybatis.mappers.DiaMapper;
import com.autentia.prueba17.pojos.TipoDia;

public class ServicioTipoDiaTest {

    ServicioTipoDia servicio;

    DiaMapper diaMapper = Mockito.mock(DiaMapper.class);

    @Before
    public void setup() {
        servicio = new ServicioTipoDiaImpl(diaMapper);

    }

    @Test
    public void shouldReturnAllTipoDia() {
        List<TipoDia> tipoDiaArrayForTest = this.getTipoDiaArrayForTest();

        Mockito.when(diaMapper.selectAll()).thenReturn(tipoDiaArrayForTest);

        List<TipoDia> allTipoDia = servicio.getAll();

        Assert.assertEquals(allTipoDia, tipoDiaArrayForTest);

        Mockito.verify(diaMapper, Mockito.times(1)).selectAll();

    }

    @Test
    public void shouldReturnOneTipoDia() {
        TipoDia diaForTest = getTipoDiaForTest();

        Mockito.when(diaMapper.selectDia(0)).thenReturn(diaForTest);

        TipoDia tipoDia = servicio.get(0);

        Assert.assertEquals(tipoDia, diaForTest);

        Mockito.verify(diaMapper, Mockito.times(1)).selectDia(0);
    }

    @Test
    public void shouldReturnAllNamesForTipoDia() {
        List<String> namesArrayForTest = this.getNombresTipoDiaArrayForTest();

        Mockito.when(diaMapper.selectAllNombres()).thenReturn(namesArrayForTest);

        List<String> allDatoClimatologico = servicio.getAllTiposDia();

        Assert.assertEquals(allDatoClimatologico, namesArrayForTest);

        Mockito.verify(diaMapper, Mockito.times(1)).selectAllNombres();

    }

    protected TipoDia getTipoDiaForTest() {
        return new TipoDia("LLuvioso");
    }

    protected List<String> getNombresTipoDiaArrayForTest() {
        return Arrays.asList("Soleado");
    }

    protected List<TipoDia> getTipoDiaArrayForTest() {
        return Arrays.asList(new TipoDia());
    }
}
