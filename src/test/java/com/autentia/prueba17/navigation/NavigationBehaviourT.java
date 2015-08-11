package com.autentia.prueba17.navigation;

import org.junit.Before;
import org.junit.Test;

import net.sourceforge.jwebunit.junit.WebTester;

/**
 * Test de prueba de la navegacion de la app (jwebunit) Comprueba que la navegacion sea correcta
 *
 * @author Rodrigo de Blas
 */
public class NavigationBehaviourT {

    private WebTester tester;

    private static final String BASE_URL = "http://localhost:8080/miclima.org";

    private static final String INICIO_PAG = "/index.xhtml";

    private static final String DATO_PAG = "/nuevodato.xhtml";

    private static final String LISTADO_PAG = "/listadatos.xhtml";

    @Before
    protected void setUp() {
        tester = new WebTester();
        tester.getTestContext().setBaseUrl(BASE_URL);
    }

    @Test
    public void testNuevoDato() {
        // desde la pagina principal
        tester.beginAt(INICIO_PAG);
        tester.assertButtonPresent("select:nuevo");
        tester.clickButton("select:nuevo");
        try {
            // damos tiempo a que se actualice la pagina
            Thread.sleep(500);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
        tester.assertTitleEquals("Añadir nuevo dato");

        // desde la pagina de listado
        tester.beginAt(LISTADO_PAG);
        tester.assertButtonPresent("listado:nuevo");
        tester.clickButton("listado:nuevo");
        try {
            // damos tiempo a que se actualice la pagina
            Thread.sleep(500);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
        tester.assertTitleEquals("Añadir nuevo dato");
    }

    @Test
    public void testListado() {
        // desde la pagina principal
        tester.beginAt(INICIO_PAG);
        tester.assertButtonPresent("select:listado");
        tester.clickButton("select:listado");
        try {
            // damos tiempo a que se actualice la pagina
            Thread.sleep(1000);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
        tester.assertTitleEquals("Listado de Datos");

        // desde la pagina de a�adir dato
        tester.beginAt(DATO_PAG);
        tester.assertButtonPresent("registro:listado");
        tester.clickButton("registro:listado");
        try {
            // damos tiempo a que se actualice la pagina
            Thread.sleep(500);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
        tester.assertTitleEquals("Listado de Datos");
    }

    @Test
    public void testInicio() {
        // desde la pagina de datos
        tester.beginAt(DATO_PAG);
        tester.assertButtonPresent("registro:volver");
        tester.clickButton("registro:volver");
        try {
            // damos tiempo a que se actualice la pagina
            Thread.sleep(500);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
        tester.assertTitleEquals("Inicio");

        // desde la pagina de listado
        tester.beginAt(LISTADO_PAG);
        tester.assertButtonPresent("listado:volver");
        tester.clickButton("listado:volver");
        try {
            // damos tiempo a que se actualice la pagina
            Thread.sleep(500);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
        tester.assertTitleEquals("Inicio");
    }

}
