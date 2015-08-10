package com.autentia.prueba17.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DatoTest {

    private ClimaticData datoTest;

    @Before
    public void setup() {
        final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d = null;
        try {
            d = sdf.parse("21/12/2015");
        } catch (final ParseException e) {
            e.printStackTrace();
        }

        datoTest = new ClimaticData(true, "Madrid", 10, 10, 10, d, "Soleado");
    }

    @Test
    public void testFechaOK() {

        final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        assertEquals(sdf.format(datoTest.getFecha()), "21/12/2015");
    }

    @Test
    public void testFechaNull() {
        datoTest.setFecha(null);
        assertEquals(datoTest.getFecha(), null);
    }

    @Test
    public void testToStringValidado() {
        datoTest.setValidado(true);
        assertTrue(datoTest.toString().contains("validado"));
    }

    @Test
    public void testToStringNoValidado() {
        datoTest.setValidado(false);
        assertTrue(datoTest.toString().contains("no validado"));
    }

}
