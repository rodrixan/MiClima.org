package com.autentia.prueba17.servicios;

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

import com.autentia.prueba17.pojos.DatoClimatologico;

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
public class ServicioDatoClimatologicoIT {

    @Autowired
    ServicioDatoClimatologico servicioDatoClimatologico;

    @Test
    public void shouldReturnAllDatoClimatologico() {

        List<DatoClimatologico> allDatoClimatologico = servicioDatoClimatologico.getAll();
        assertFalse(allDatoClimatologico.isEmpty());
    }

    @Test
    public void shouldInsertANewDato() {
        List<DatoClimatologico> allDatoClimatologico = servicioDatoClimatologico.getAll();
        int numberOfDataPrev = allDatoClimatologico.size();

        DatoClimatologico dataToInsert = getDataToInsert();

        servicioDatoClimatologico.save(dataToInsert);

        allDatoClimatologico = servicioDatoClimatologico.getAll();
        int numberOfDataCurr = allDatoClimatologico.size();

        assertEquals(numberOfDataPrev + 1, numberOfDataCurr);

    }

    private DatoClimatologico getDataToInsert() {
        DatoClimatologico ret = DatoClimatologico.DatoClimatologicoBuilder.anInstance().setValidado(true)
                .setLocalidad("Madrid").setTemperatura(10).setHumedad(10).setPrecipitacion(10).setFecha(new Date())
                .setTipoDia("Soleado").build();

        return ret;
    }
}
