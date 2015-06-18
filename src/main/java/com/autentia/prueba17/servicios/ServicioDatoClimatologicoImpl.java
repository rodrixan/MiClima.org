package com.autentia.prueba17.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autentia.prueba17.mybatis.mappers.DatoMapper;
import com.autentia.prueba17.pojos.DatoClimatologico;

@Service("servicioDatoClimatologico")
public class ServicioDatoClimatologicoImpl implements ServicioDatoClimatologico {

    private final DatoMapper datoMapper;

    @Autowired
    public ServicioDatoClimatologicoImpl(DatoMapper datoMapper) {
        this.datoMapper = datoMapper;
    }

    @Override
    public List<DatoClimatologico> getAll() {
        return datoMapper.getAll();
    }

    @Override
    public DatoClimatologico get(int id) {
        return datoMapper.getDato(id);
    }

    @Override
    public void save(DatoClimatologico datoClimatologico) {
        datoMapper.insertDato(datoClimatologico);
    }

    @Override
    public List<DatoClimatologico> getAllValidate() {
        return datoMapper.getAllValidados();
    }

    @Override
    public List<DatoClimatologico> getAllOrderByLoc() {
        return datoMapper.getAllOrderLoc();
    }

    @Override
    public List<DatoClimatologico> getAllOrderByTemp() {
        return datoMapper.getAllOrderTemp();
    }

    @Override
    public List<DatoClimatologico> getAllWithLocalization(String loc) {
        return datoMapper.getDatoConLoc(loc);
    }

}
