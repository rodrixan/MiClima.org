package com.autentia.prueba17.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autentia.prueba17.mybatis.mappers.DiaMapper;
import com.autentia.prueba17.pojos.TipoDia;

@Service("servicioTipoDia")
public class ServicioTipoDiaImpl implements ServicioTipoDia {

    private final DiaMapper diaMapper;

    @Autowired
    public ServicioTipoDiaImpl(DiaMapper diaMapper) {
        this.diaMapper = diaMapper;
    }

    @Override
    public TipoDia get(int id) {
        return diaMapper.selectDia(id);
    }

    @Override
    public List<TipoDia> getAll() {
        return diaMapper.selectAll();
    }

    @Override
    public List<String> getAllTiposDia() {
        return diaMapper.selectAllNombres();
    }

}
