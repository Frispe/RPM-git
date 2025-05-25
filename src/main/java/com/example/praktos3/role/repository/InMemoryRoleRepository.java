package com.example.praktos3.role.repository;

import com.example.praktos3.role.model.RoleModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InMemoryRoleRepository extends JpaRepository<RoleModel, Long> {
    RoleModel findRoleByRole(String role);

    default List<RoleModel> findRolesWithPagination(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        Page<RoleModel> rolePage = findAll(pageable);
        return rolePage.getContent();
    }
}