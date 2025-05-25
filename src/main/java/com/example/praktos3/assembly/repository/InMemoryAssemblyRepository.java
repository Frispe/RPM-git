package com.example.praktos3.assembly.repository;

import com.example.praktos3.assembly.model.AssemblyModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InMemoryAssemblyRepository extends JpaRepository<AssemblyModel, Long> {
    AssemblyModel findAssemblyByPcBuilderId(Long pcBuilderId);

    @Query("SELECT a FROM AssemblyModel a JOIN FETCH a.processor p JOIN FETCH p.brand")
    List<AssemblyModel> findAllWithProcessorAndBrand();

    default List<AssemblyModel> findAssembliesWithPagination(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        Page<AssemblyModel> assemblyPage = findAll(pageable);
        return assemblyPage.getContent();
    }
}