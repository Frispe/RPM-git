package com.example.praktos3.addition.service;

import com.example.praktos3.addition.model.AdditionModel;
import com.example.praktos3.addition.repository.InMemoryAdditionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryAdditionServiceImpl implements AdditionService {

    private final InMemoryAdditionRepository additionRepository;

    public InMemoryAdditionServiceImpl(InMemoryAdditionRepository additionRepository) {
        this.additionRepository = additionRepository;
    }

    @Override
    public List<AdditionModel> findAllAdditions() {
        return additionRepository.findAll();
    }

    @Override
    public AdditionModel findAdditionById(int id) {
        return additionRepository.findById((long) id).orElse(null);
    }

    @Override
    public AdditionModel findAdditionByName(String name) {
        return additionRepository.findAdditionModelByName(name);
    }

    @Override
    public AdditionModel addAddition(AdditionModel addition) {
        return additionRepository.save(addition);
    }

    @Override
    public AdditionModel updateAddition(AdditionModel addition) {
        return additionRepository.save(addition);
    }

    @Override
    public void deleteAddition(int id) {
        additionRepository.deleteById((long) id);
    }

    @Override
    public List<AdditionModel> findAdditionsWithPagination(int page, int size) {
        return additionRepository.findAdditionWithPagination(page, size);
    }

    @Override
    public List<AdditionModel> findAllById(List<Long> ids) {
        return additionRepository.findAllById(ids);
    }
}