package com.autentia.prueba17.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autentia.prueba17.mybatis.mappers.LocalidadMapper;
import com.autentia.prueba17.pojos.Localidad;

@Service("servicioLocalidad")
public class ServicioLocalidadImpl implements ServicioLocalidad {

    private final LocalidadMapper localidadMapper;

    @Autowired
    public ServicioLocalidadImpl(LocalidadMapper localidadMapper) {
        this.localidadMapper = localidadMapper;
    }

    @Override
    public Localidad get(int id) {
        return localidadMapper.selectLocalidad(id);
    }

    @Override
    public List<Localidad> getAll() {
        return localidadMapper.selectAll();
    }

    @Override
    public List<String> getAllNombresLocalidad() {
        return localidadMapper.selectAllNombres();
    }

}
