package com.autentia.prueba17.beans;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.autentia.prueba17.servicios.ServicioDatoClimatologico;
import com.autentia.prueba17.servicios.ServicioLocalidad;
import com.autentia.prueba17.servicios.ServicioTipoDia;

/**
 * Test unitario de DatoView
 *
 * @author rodrideblas
 */
public class DatoViewTest {

    DatoView datoView;

    /** servicios mockeados */

    ServicioDatoClimatologico srvDatoClimatologicoMock = Mockito.mock(ServicioDatoClimatologico.class);

    ServicioLocalidad srvLocalidadMock = Mockito.mock(ServicioLocalidad.class);

    ServicioTipoDia srvTipoDiaMock = Mockito.mock(ServicioTipoDia.class);

    private List<String> locNamesArrayForTest;

    private List<String> dayNamesArrayForTest;

    @Before
    public void setup() {
        datoView = new DatoView();
        datoView.setSrvDatoClimatologico(srvDatoClimatologicoMock);
        datoView.setServicioLocalidad(srvLocalidadMock);
        datoView.setSrvTipoDia(srvTipoDiaMock);

        locNamesArrayForTest = this.getNombresLocalidadArrayForTest();
        dayNamesArrayForTest = this.getNombresTipoDiaArrayForTest();

        Mockito.when(srvLocalidadMock.getAllNombresLocalidad()).thenReturn(locNamesArrayForTest);
        Mockito.when(srvTipoDiaMock.getAllTiposDia()).thenReturn(dayNamesArrayForTest);

        datoView.init();
    }

    @Test
    public void shouldLoadLocsAndDays() {

        Mockito.verify(srvLocalidadMock).getAllNombresLocalidad();
        Mockito.verify(srvTipoDiaMock).getAllTiposDia();
        assertEquals(locNamesArrayForTest, datoView.getLocalidades());
        assertEquals(dayNamesArrayForTest, datoView.getTipodias());

    }

    @Test
    public void shouldSaveDatoClimatologico() {

    }

    protected List<String> getNombresLocalidadArrayForTest() {
        return Arrays.asList("Madrid");

    }

    protected List<String> getNombresTipoDiaArrayForTest() {
        return Arrays.asList("Soleado");
    }
}
