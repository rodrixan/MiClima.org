package com.autentia.prueba17.services;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.autentia.prueba17.model.DayType;
import com.autentia.prueba17.mybatis.mappers.DayTypeMapper;
import com.autentia.prueba17.services.DayTypeService;
import com.autentia.prueba17.services.DayTypeServiceImpl;

public class ServicioTipoDiaTest {

    DayTypeService servicio;

    DayTypeMapper diaMapper = Mockito.mock(DayTypeMapper.class);

    @Before
    public void setup() {
        servicio = new DayTypeServiceImpl(diaMapper);

    }

    @Test
    public void shouldReturnAllTipoDia() {
        List<DayType> tipoDiaArrayForTest = this.getTipoDiaArrayForTest();

        Mockito.when(diaMapper.getAll()).thenReturn(tipoDiaArrayForTest);

        List<DayType> allTipoDia = servicio.getAll();

        Assert.assertEquals(allTipoDia, tipoDiaArrayForTest);

        Mockito.verify(diaMapper, Mockito.times(1)).getAll();

    }

    @Test
    public void shouldReturnOneTipoDia() {
        DayType diaForTest = getTipoDiaForTest();

        Mockito.when(diaMapper.get(0)).thenReturn(diaForTest);

        DayType tipoDia = servicio.get(0);

        Assert.assertEquals(tipoDia, diaForTest);

        Mockito.verify(diaMapper, Mockito.times(1)).get(0);
    }

    @Test
    public void shouldReturnAllNamesForTipoDia() {
        List<String> namesArrayForTest = this.getNombresTipoDiaArrayForTest();

        Mockito.when(diaMapper.getAllDayTypesNames()).thenReturn(namesArrayForTest);

        List<String> allDatoClimatologico = servicio.getAllDayTypesNames();

        Assert.assertEquals(allDatoClimatologico, namesArrayForTest);

        Mockito.verify(diaMapper, Mockito.times(1)).getAllDayTypesNames();

    }

    protected DayType getTipoDiaForTest() {
        return new DayType("LLuvioso");
    }

    protected List<String> getNombresTipoDiaArrayForTest() {
        return Arrays.asList("Soleado");
    }

    protected List<DayType> getTipoDiaArrayForTest() {
        return Arrays.asList(new DayType());
    }
}
