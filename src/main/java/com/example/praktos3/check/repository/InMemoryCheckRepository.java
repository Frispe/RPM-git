package com.example.praktos3.check.repository;

import com.example.praktos3.check.model.CheckModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InMemoryCheckRepository extends JpaRepository<CheckModel, Long> {
    CheckModel findByReceiptCode(String receiptCode);  // Изменено название метода

    default List<CheckModel> findChecksWithPagination(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        Page<CheckModel> checkPage = findAll(pageable);
        return checkPage.getContent();
    }
}