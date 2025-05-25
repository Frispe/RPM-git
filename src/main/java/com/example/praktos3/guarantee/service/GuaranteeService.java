package com.example.praktos3.guarantee.service;

import com.example.praktos3.guarantee.model.GuaranteeModel;
import java.time.LocalDate;
import java.util.List;

public interface GuaranteeService {
    List<GuaranteeModel> findAllGuarantees();
    GuaranteeModel findGuaranteeById(long id);
    GuaranteeModel findGuaranteeByStartDate(LocalDate startDate);
    GuaranteeModel addGuarantee(GuaranteeModel guarantee);
    GuaranteeModel updateGuarantee(GuaranteeModel guarantee);
    void deleteGuarantee(long id);
    List<GuaranteeModel> findGuaranteesWithPagination(int page, int size);
}