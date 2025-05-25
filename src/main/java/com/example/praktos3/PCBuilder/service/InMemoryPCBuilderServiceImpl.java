package com.example.praktos3.PCBuilder.service;

import com.example.praktos3.PCBuilder.model.PCBuilderModel;
import com.example.praktos3.PCBuilder.repository.InMemoryPCBuilderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InMemoryPCBuilderServiceImpl implements PCBuilderService {

    private final InMemoryPCBuilderRepository pcBuilderRepository;

    public InMemoryPCBuilderServiceImpl(InMemoryPCBuilderRepository pcBuilderRepository) {
        this.pcBuilderRepository = pcBuilderRepository;
    }

    @Override
    public List<PCBuilderModel> findAllPCBuilders() {
        return pcBuilderRepository.findAll();
    }

    @Override
    public PCBuilderModel findPCBuilderById(long id) {
        return pcBuilderRepository.findById(id).orElse(null);
    }

    @Override
    public PCBuilderModel findPCBuilderByFirstName(String firstName) {
        return pcBuilderRepository.findPCBuilderByFirstName(firstName);
    }

    @Override
    public PCBuilderModel addPCBuilder(PCBuilderModel pcBuilder) {
        return pcBuilderRepository.save(pcBuilder);
    }

    @Override
    public PCBuilderModel updatePCBuilder(PCBuilderModel pcBuilder) {
        return pcBuilderRepository.save(pcBuilder);
    }

    @Override
    public void deletePCBuilder(long id) {
        pcBuilderRepository.deleteById(id);
    }

    @Override
    public List<PCBuilderModel> findPCBuildersWithPagination(int page, int size) {
        return pcBuilderRepository.findPCBuildersWithPagination(page, size);
    }
}