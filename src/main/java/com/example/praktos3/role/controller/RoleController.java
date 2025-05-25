package com.example.praktos3.role.controller;

import com.example.praktos3.role.model.RoleModel;
import com.example.praktos3.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/roleList")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public String getAllRoles(@RequestParam(defaultValue = "0") int page, Model model) {
        int size = 10;
        List<RoleModel> roles = roleService.findRolesWithPagination(page, size);
        model.addAttribute("roles", roles);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages",
                (int) Math.ceil((double) roleService.findAllRoles().size() / size));
        return "roleList";
    }

    @PostMapping("/add")
    public String addRole(@RequestParam String role) {
        RoleModel newRole = new RoleModel(0, role);
        roleService.addRole(newRole);
        return "redirect:/roleList?page=0";
    }

    @PostMapping("/update")
    public String updateRole(@RequestParam long id,
                             @RequestParam String role) {
        RoleModel updatedRole = new RoleModel(id, role);
        roleService.updateRole(updatedRole);
        return "redirect:/roleList?page=0";
    }

    @PostMapping("/delete")
    public String deleteRole(@RequestParam long id) {
        roleService.deleteRole(id);
        return "redirect:/roleList?page=0";
    }

    @GetMapping("/searchById")
    public String searchRoleById(@RequestParam long id, Model model) {
        RoleModel role = roleService.findRoleById(id);
        model.addAttribute("roles", role != null ? List.of(role) : List.of());
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "roleList";
    }

    @GetMapping("/searchByRole")
    public String searchRoleByRole(@RequestParam String role, Model model) {
        RoleModel roleModel = roleService.findRoleByRole(role);
        model.addAttribute("roles", roleModel != null ? List.of(roleModel) : List.of());
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "roleList";
    }
}