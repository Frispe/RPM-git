package com.example.praktos3.PCBuilder.repository;

import com.example.praktos3.PCBuilder.model.PCBuilderModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InMemoryPCBuilderRepository extends JpaRepository<PCBuilderModel, Long> {
    PCBuilderModel findPCBuilderByFirstName(String firstName);

    default List<PCBuilderModel> findPCBuildersWithPagination(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        Page<PCBuilderModel> pcBuilderPage = findAll(pageable);
        return pcBuilderPage.getContent();
    }
}