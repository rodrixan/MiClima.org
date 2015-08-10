package interfaz;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import net.sourceforge.jwebunit.junit.WebTester;

/**
 * Test de prueba de la navegacion de la app (jwebunit) Comprueba que la navegacion sea correcta
 *
 * @author Rodrigo de Blas
 */
public class NavegacionBT extends TestCase {

    // atributo para navegacion
    private final WebTester tester;

    // URLs y paginas de la applicacion
    private static final String BASE_URL = "http://localhost:8080/miclima.org";

    private static final String INICIO_PAG = "/index.xhtml";

    private static final String DATO_PAG = "/nuevodato.xhtml";

    private static final String LISTADO_PAG = "/listadatos.xhtml";

    /**
     * Constructor: crea una isntancia del tester
     *
     * @param arg0 cadena
     */
    public NavegacionBT(String arg0) {
        super(arg0);
        tester = new WebTester();
        tester.getTestContext().setBaseUrl(BASE_URL);
    }

    @Override
    @Before
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    @After
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Comprueba que se accede bien a la pagina de a�adir dato
     */
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

    /**
     * Comprueba que se puede acceder a la pagina de listado de datos
     */
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

    /**
     * Comprueba que se puede acceder a la pagina principal
     */
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
