package com.example.praktos3.assembly.service;

import com.example.praktos3.assembly.model.AssemblyModel;
import com.example.praktos3.assembly.repository.InMemoryAssemblyRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InMemoryAssemblyServiceImpl implements AssemblyService {

    private final InMemoryAssemblyRepository assemblyRepository;

    public InMemoryAssemblyServiceImpl(InMemoryAssemblyRepository assemblyRepository) {
        this.assemblyRepository = assemblyRepository;
    }

    @Override
    public List<AssemblyModel> findAllAssemblies() {
        return assemblyRepository.findAll();
    }

    @Override
    public AssemblyModel findAssemblyById(long id) {
        return assemblyRepository.findById(id).orElse(null);
    }

    @Override
    public AssemblyModel findAssemblyByPcBuilderId(Long pcBuilderId) {
        return assemblyRepository.findAssemblyByPcBuilderId(pcBuilderId);
    }

    @Override
    public AssemblyModel addAssembly(AssemblyModel assembly) {
        return assemblyRepository.save(assembly);
    }

    @Override
    public AssemblyModel updateAssembly(AssemblyModel assembly) {
        return assemblyRepository.save(assembly);
    }

    @Override
    public void deleteAssembly(long id) {
        assemblyRepository.deleteById(id);
    }

    @Override
    public List<AssemblyModel> findAssembliesWithPagination(int page, int size) {
        return assemblyRepository.findAssembliesWithPagination(page, size);
    }
}