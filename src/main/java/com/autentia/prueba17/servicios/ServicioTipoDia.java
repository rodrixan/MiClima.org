package com.autentia.prueba17.servicios;

import java.io.Serializable;
import java.util.List;

import com.autentia.prueba17.pojos.TipoDia;

public interface ServicioTipoDia extends Serializable {

    public TipoDia get(int id);

    public List<TipoDia> getAll();

    public List<String> getAllTiposDia();
}
