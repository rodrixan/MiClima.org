package com.autentia.prueba17.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ClimaticDataTest {

    private ClimaticData climaticDataToTest;

    @Before
    public void setup() {
        final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d = null;
        try {
            d = sdf.parse("21/12/2015");
        } catch (final ParseException e) {
            e.printStackTrace();
        }

        climaticDataToTest = new ClimaticData(true, "Madrid", 10, 10, 10, d, "Soleado");
    }

    @Test
    public void testDateOK() {

        final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        assertEquals(sdf.format(climaticDataToTest.getDate()), "21/12/2015");
    }

    @Test
    public void testDateNull() {
        climaticDataToTest.setDate(null);
        assertEquals(climaticDataToTest.getDate(), null);
    }

    @Test
    public void testValidatedToString() {
        climaticDataToTest.setValidated(true);
        assertTrue(climaticDataToTest.toString().contains("validado"));
    }

    @Test
    public void testNonValidatedToString() {
        climaticDataToTest.setValidated(false);
        assertTrue(climaticDataToTest.toString().contains("no validado"));
    }

}
