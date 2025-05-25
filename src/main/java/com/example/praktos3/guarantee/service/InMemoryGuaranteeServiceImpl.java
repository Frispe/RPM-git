package com.example.praktos3.guarantee.service;

import com.example.praktos3.guarantee.model.GuaranteeModel;
import com.example.praktos3.guarantee.repository.InMemoryGuaranteeRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class InMemoryGuaranteeServiceImpl implements GuaranteeService {

    private final InMemoryGuaranteeRepository guaranteeRepository;

    public InMemoryGuaranteeServiceImpl(InMemoryGuaranteeRepository guaranteeRepository) {
        this.guaranteeRepository = guaranteeRepository;
    }

    @Override
    public List<GuaranteeModel> findAllGuarantees() {
        return guaranteeRepository.findAll();
    }

    @Override
    public GuaranteeModel findGuaranteeById(long id) {
        return guaranteeRepository.findById(id).orElse(null);
    }

    @Override
    public GuaranteeModel findGuaranteeByStartDate(LocalDate startDate) {
        return guaranteeRepository.findGuaranteeByStartDate(startDate);
    }

    @Override
    public GuaranteeModel addGuarantee(GuaranteeModel guarantee) {
        return guaranteeRepository.save(guarantee);
    }

    @Override
    public GuaranteeModel updateGuarantee(GuaranteeModel guarantee) {
        return guaranteeRepository.save(guarantee);
    }

    @Override
    public void deleteGuarantee(long id) {
        guaranteeRepository.deleteById(id);
    }

    @Override
    public List<GuaranteeModel> findGuaranteesWithPagination(int page, int size) {
        return guaranteeRepository.findGuaranteesWithPagination(page, size);
    }
}