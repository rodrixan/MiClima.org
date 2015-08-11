package com.autentia.prueba17.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autentia.prueba17.model.ClimaticData;
import com.autentia.prueba17.mybatis.mappers.ClimaticDataMapper;

@Service("climaticDataService")
public class ClimaticDataServiceImpl implements ClimaticDataService {

    private final ClimaticDataMapper climaticDataMapper;

    @Autowired
    public ClimaticDataServiceImpl(ClimaticDataMapper climaticDataMapper) {
        this.climaticDataMapper = climaticDataMapper;
    }

    @Override
    public List<ClimaticData> getAll() {
        return climaticDataMapper.getAll();
    }

    @Override
    public ClimaticData get(int id) {
        return climaticDataMapper.get(id);
    }

    @Override
    public void insert(ClimaticData climaticData) {
        climaticDataMapper.insert(climaticData);
    }

    @Override
    public List<ClimaticData> getAllValidate() {
        return climaticDataMapper.getAllValidated();
    }

}
