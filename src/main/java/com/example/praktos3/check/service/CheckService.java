package com.example.praktos3.check.service;

import com.example.praktos3.check.model.CheckModel;
import java.util.List;

public interface CheckService {
    List<CheckModel> findAllChecks();
    CheckModel findCheckById(Long id);
    CheckModel findCheckByReceiptCode(String receiptCode);
    CheckModel addCheck(CheckModel check);
    CheckModel updateCheck(CheckModel check);
    void deleteCheck(Long id);
    List<CheckModel> findChecksWithPagination(int page, int size);
}