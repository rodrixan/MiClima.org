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

public class ClimaticDataServiceTest {

    ClimaticDataService climaticDataServiceForTest;

    ClimaticDataMapper mockedClimaticDataMapper = Mockito.mock(ClimaticDataMapper.class);

    @Before
    public void setup() {
        climaticDataServiceForTest = new ClimaticDataServiceImpl(mockedClimaticDataMapper);

    }

    @Test
    public void shouldReturnAllClimaticData() {
        final List<ClimaticData> climaticDataArray = this.getClimaticDataArrayForTest();

        Mockito.when(mockedClimaticDataMapper.getAll()).thenReturn(climaticDataArray);

        final List<ClimaticData> allClimaticData = climaticDataServiceForTest.getAll();

        Assert.assertEquals(allClimaticData, climaticDataArray);

        Mockito.verify(mockedClimaticDataMapper, Mockito.times(1)).getAll();

    }

    @Test
    public void shouldReturnOneClimaticData() {
        final ClimaticData climaticDataForTest = getClimaticDataForTest();

        Mockito.when(mockedClimaticDataMapper.get(0)).thenReturn(climaticDataForTest);

        final ClimaticData climaticData = climaticDataServiceForTest.get(0);

        Assert.assertEquals(climaticData, climaticDataForTest);

        Mockito.verify(mockedClimaticDataMapper, Mockito.times(1)).get(0);
    }

    @Test
    public void shouldReturnNothing() {
        final ClimaticData climaticDataForTest = getClimaticDataForTest();

        climaticDataServiceForTest.insert(climaticDataForTest);

        Mockito.verify(mockedClimaticDataMapper, Mockito.times(1)).insert(climaticDataForTest);

    }

    protected ClimaticData getClimaticDataForTest() {
        final Date d = new Date();
        return new ClimaticData(true, "Madrid", 10, 10, 10, d, "Soleado");
    }

    protected List<ClimaticData> getClimaticDataArrayForTest() {
        return Arrays.asList(new ClimaticData());
    }
}
