package com.example.praktos3.coolingtype.service;

import com.example.praktos3.coolingtype.model.CoolingTypeModel;
import java.util.List;

public interface CoolingTypeService {
    List<CoolingTypeModel> findAllCoolingTypes();
    CoolingTypeModel findCoolingTypeById(long id);
    CoolingTypeModel findCoolingTypeByName(String typeName);
    CoolingTypeModel addCoolingType(CoolingTypeModel coolingType);
    CoolingTypeModel updateCoolingType(CoolingTypeModel coolingType);
    void deleteCoolingType(long id);
    List<CoolingTypeModel> findCoolingTypesWithPagination(int page, int size);
}