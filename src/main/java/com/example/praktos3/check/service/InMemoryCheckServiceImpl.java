package com.example.praktos3.check.service;

import com.example.praktos3.check.model.CheckModel;
import com.example.praktos3.check.repository.InMemoryCheckRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryCheckServiceImpl implements CheckService {

    private final InMemoryCheckRepository checkRepository;

    public InMemoryCheckServiceImpl(InMemoryCheckRepository checkRepository) {
        this.checkRepository = checkRepository;
    }

    @Override
    public List<CheckModel> findAllChecks() {
        return checkRepository.findAll();
    }

    @Override
    public CheckModel findCheckById(Long id) {
        return checkRepository.findById(id).orElse(null);
    }

    @Override
    public CheckModel findCheckByReceiptCode(String receiptCode) {
        return checkRepository.findByReceiptCode(receiptCode);
    }

    @Override
    public CheckModel addCheck(CheckModel check) {
        return checkRepository.save(check);
    }

    @Override
    public CheckModel updateCheck(CheckModel check) {
        if (checkRepository.existsById(check.getId())) {
            return checkRepository.save(check);
        }
        return null;
    }

    @Override
    public void deleteCheck(Long id) {
        checkRepository.deleteById(id);
    }

    @Override
    public List<CheckModel> findChecksWithPagination(int page, int size) {
        return checkRepository.findChecksWithPagination(page, size);
    }
}