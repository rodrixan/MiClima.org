package com.autentia.prueba17.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autentia.prueba17.model.DayType;
import com.autentia.prueba17.mybatis.mappers.DayTypeMapper;

@Service("dayTypeService")
public class DayTypeServiceImpl implements DayTypeService {

    private final DayTypeMapper dayTypeMapper;

    @Autowired
    public DayTypeServiceImpl(DayTypeMapper dayTypeMapper) {
        this.dayTypeMapper = dayTypeMapper;
    }

    @Override
    public DayType get(int id) {
        return dayTypeMapper.get(id);
    }

    @Override
    public List<DayType> getAll() {
        return dayTypeMapper.getAll();
    }

    @Override
    public List<String> getAllDayTypesNames() {
        return dayTypeMapper.getAllDayTypesNames();
    }

}
