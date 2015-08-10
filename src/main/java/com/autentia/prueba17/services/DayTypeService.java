package com.autentia.prueba17.services;

import java.io.Serializable;
import java.util.List;

import com.autentia.prueba17.model.DayType;

public interface DayTypeService extends Serializable {

    public DayType get(int id);

    public List<DayType> getAll();

    public List<String> getAllDayTypesNames();
}
