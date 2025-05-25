package com.example.praktos3.assembly.service;

import com.example.praktos3.assembly.model.AssemblyModel;
import java.util.List;

public interface AssemblyService {
    List<AssemblyModel> findAllAssemblies();
    AssemblyModel findAssemblyById(long id);
    AssemblyModel findAssemblyByPcBuilderId(Long pcBuilderId);
    AssemblyModel addAssembly(AssemblyModel assembly);
    AssemblyModel updateAssembly(AssemblyModel assembly);
    void deleteAssembly(long id);
    List<AssemblyModel> findAssembliesWithPagination(int page, int size);
}