package com.example.praktos3.guarantee.repository;

import com.example.praktos3.guarantee.model.GuaranteeModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface InMemoryGuaranteeRepository extends JpaRepository<GuaranteeModel, Long> {
    GuaranteeModel findGuaranteeByStartDate(LocalDate startDate);

    default List<GuaranteeModel> findGuaranteesWithPagination(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        Page<GuaranteeModel> guaranteePage = findAll(pageable);
        return guaranteePage.getContent();
    }
}