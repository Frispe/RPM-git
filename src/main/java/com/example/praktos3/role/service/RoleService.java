package com.example.praktos3.role.service;

import com.example.praktos3.role.model.RoleModel;
import java.util.List;

public interface RoleService {
    List<RoleModel> findAllRoles();
    RoleModel findRoleById(long id);
    RoleModel findRoleByRole(String role);
    RoleModel addRole(RoleModel role);
    RoleModel updateRole(RoleModel role);
    void deleteRole(long id);
    List<RoleModel> findRolesWithPagination(int page, int size);
}