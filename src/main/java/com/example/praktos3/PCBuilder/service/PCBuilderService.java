package com.example.praktos3.PCBuilder.service;

import com.example.praktos3.PCBuilder.model.PCBuilderModel;
import java.util.List;

public interface PCBuilderService {
    List<PCBuilderModel> findAllPCBuilders();
    PCBuilderModel findPCBuilderById(long id);
    PCBuilderModel findPCBuilderByFirstName(String firstName);
    PCBuilderModel addPCBuilder(PCBuilderModel pcBuilder);
    PCBuilderModel updatePCBuilder(PCBuilderModel pcBuilder);
    void deletePCBuilder(long id);
    List<PCBuilderModel> findPCBuildersWithPagination(int page, int size);
}