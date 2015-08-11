package com.autentia.prueba17.services;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.autentia.prueba17.model.DayType;
import com.autentia.prueba17.mybatis.mappers.DayTypeMapper;

public class DayTypeServiceTest {

    DayTypeService dayTypeServiceForTest;

    DayTypeMapper mockedDayTypeMapper = Mockito.mock(DayTypeMapper.class);

    @Before
    public void setup() {
        dayTypeServiceForTest = new DayTypeServiceImpl(mockedDayTypeMapper);

    }

    @Test
    public void shouldReturnAllDayTypes() {
        final List<DayType> dayTypeArrayForTest = this.getDayTypeArrayForTest();

        Mockito.when(mockedDayTypeMapper.getAll()).thenReturn(dayTypeArrayForTest);

        final List<DayType> allDayTypes = dayTypeServiceForTest.getAll();

        Assert.assertEquals(allDayTypes, dayTypeArrayForTest);

        Mockito.verify(mockedDayTypeMapper, Mockito.times(1)).getAll();

    }

    @Test
    public void shouldReturnOneDayType() {
        final DayType dayTypeForTest = getDayTypeForTest();

        Mockito.when(mockedDayTypeMapper.get(0)).thenReturn(dayTypeForTest);

        final DayType dayType = dayTypeServiceForTest.get(0);

        Assert.assertEquals(dayType, dayTypeForTest);

        Mockito.verify(mockedDayTypeMapper, Mockito.times(1)).get(0);
    }

    @Test
    public void shouldReturnAllDayTypeNames() {
        final List<String> dayTypeNamesArrayForTest = this.getDayTypeNamesArrayForTest();

        Mockito.when(mockedDayTypeMapper.getAllDayTypesNames()).thenReturn(dayTypeNamesArrayForTest);

        final List<String> allDayTypeNames = dayTypeServiceForTest.getAllDayTypesNames();

        Assert.assertEquals(allDayTypeNames, dayTypeNamesArrayForTest);

        Mockito.verify(mockedDayTypeMapper, Mockito.times(1)).getAllDayTypesNames();

    }

    protected DayType getDayTypeForTest() {
        return new DayType("LLuvioso");
    }

    protected List<String> getDayTypeNamesArrayForTest() {
        return Arrays.asList("Soleado");
    }

    protected List<DayType> getDayTypeArrayForTest() {
        return Arrays.asList(new DayType());
    }
}
