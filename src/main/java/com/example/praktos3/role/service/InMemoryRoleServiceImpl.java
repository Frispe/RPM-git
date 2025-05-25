package com.example.praktos3.role.service;

import com.example.praktos3.role.model.RoleModel;
import com.example.praktos3.role.repository.InMemoryRoleRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InMemoryRoleServiceImpl implements RoleService {

    private final InMemoryRoleRepository roleRepository;

    public InMemoryRoleServiceImpl(InMemoryRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleModel> findAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public RoleModel findRoleById(long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public RoleModel findRoleByRole(String role) {
        return roleRepository.findRoleByRole(role);
    }

    @Override
    public RoleModel addRole(RoleModel role) {
        return roleRepository.save(role);
    }

    @Override
    public RoleModel updateRole(RoleModel role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public List<RoleModel> findRolesWithPagination(int page, int size) {
        return roleRepository.findRolesWithPagination(page, size);
    }
}