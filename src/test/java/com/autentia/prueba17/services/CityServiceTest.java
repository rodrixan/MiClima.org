package com.autentia.prueba17.services;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.autentia.prueba17.model.City;
import com.autentia.prueba17.mybatis.mappers.CityMapper;

public class CityServiceTest {

    CityService cityService;

    CityMapper mockedCityMapper = Mockito.mock(CityMapper.class);

    @Before
    public void setup() {
        cityService = new CityServiceImpl(mockedCityMapper);

    }

    @Test
    public void shouldReturnAllCities() {
        final List<City> cityArrayForTest = this.getCityArrayForTest();

        Mockito.when(mockedCityMapper.getAll()).thenReturn(cityArrayForTest);

        final List<City> allCityList = cityService.getAll();

        Assert.assertEquals(allCityList, cityArrayForTest);

        Mockito.verify(mockedCityMapper, Mockito.times(1)).getAll();

    }

    @Test
    public void shouldReturnOneCity() {
        final City cityForTest = getCityForTest();

        Mockito.when(mockedCityMapper.get(0)).thenReturn(cityForTest);

        final City city = cityService.get(0);

        Assert.assertEquals(city, cityForTest);

        Mockito.verify(mockedCityMapper, Mockito.times(1)).get(0);
    }

    @Test
    public void shouldReturnAllCityNames() {
        final List<String> cityNamesArrayForTest = this.getCityNamesArrayForTest();

        Mockito.when(mockedCityMapper.getAllCityNames()).thenReturn(cityNamesArrayForTest);

        final List<String> allCityNames = cityService.getAllCityNames();

        Assert.assertEquals(allCityNames, cityNamesArrayForTest);

        Mockito.verify(mockedCityMapper, Mockito.times(1)).getAllCityNames();

    }

    protected City getCityForTest() {
        return new City("Madrid");
    }

    protected List<String> getCityNamesArrayForTest() {
        return Arrays.asList("Madrid");
    }

    protected List<City> getCityArrayForTest() {
        return Arrays.asList(new City());
    }
}
