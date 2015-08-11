package com.autentia.prueba17.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.autentia.prueba17.model.ClimaticData;
import com.autentia.prueba17.services.ClimaticDataService;

/**
 * Prueba de integracion de ServicioDatoClimatologico con su mapper
 *
 * @author rodrideblas
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml",
"classpath:applicationContext-test.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class ClimaticDataServiceIT {

    @Autowired
    ClimaticDataService servicioDatoClimatologico;

    @Test
    public void shouldReturnAllDatoClimatologico() {

        List<ClimaticData> allDatoClimatologico = servicioDatoClimatologico.getAll();
        assertFalse(allDatoClimatologico.isEmpty());
    }

    @Test
    public void shouldInsertANewDato() {
        List<ClimaticData> allDatoClimatologico = servicioDatoClimatologico.getAll();
        int numberOfDataPrev = allDatoClimatologico.size();

        ClimaticData dataToInsert = getDataToInsert();

        servicioDatoClimatologico.insert(dataToInsert);

        allDatoClimatologico = servicioDatoClimatologico.getAll();
        int numberOfDataCurr = allDatoClimatologico.size();

        assertEquals(numberOfDataPrev + 1, numberOfDataCurr);

    }

    private ClimaticData getDataToInsert() {
        ClimaticData ret = ClimaticData.ClimaticDataBuilder.anInstance().setValidated(true)
                .setCityName("Madrid").setTemperature(10).setHumidity(10).setPrecipitation(10).setDate(new Date())
                .setDayTypeName("Soleado").build();

        return ret;
    }
}
