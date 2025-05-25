package com.example.praktos3.addition.repository;

import com.example.praktos3.addition.model.AdditionModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InMemoryAdditionRepository extends JpaRepository<AdditionModel, Long> {
    AdditionModel findAdditionModelByName(String name);

    default List<AdditionModel> findAdditionWithPagination(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        Page<AdditionModel> additionPage = findAll(pageable);
        return additionPage.getContent();
    }
}