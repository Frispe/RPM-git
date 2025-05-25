package com.example.praktos3.addition.service;

import com.example.praktos3.addition.model.AdditionModel;
import java.util.List;

public interface AdditionService {
    List<AdditionModel> findAllAdditions();
    AdditionModel findAdditionById(int id);
    AdditionModel findAdditionByName(String name);
    AdditionModel addAddition(AdditionModel addition);
    AdditionModel updateAddition(AdditionModel addition);
    void deleteAddition(int id);
    List<AdditionModel> findAdditionsWithPagination(int page, int size);
    List<AdditionModel> findAllById(List<Long> ids);
}