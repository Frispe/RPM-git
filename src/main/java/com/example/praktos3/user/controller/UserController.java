package com.example.praktos3.user.controller;

import com.example.praktos3.user.model.UserModel;
import com.example.praktos3.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/userList")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllUsers(@RequestParam(defaultValue = "0") int page, Model model) {
        int size = 10;
        List<UserModel> users = userService.findUsersWithPagination(page, size);
        model.addAttribute("users", users);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages",
                (int) Math.ceil((double) userService.findAllUsers().size() / size));
        return "userList";
    }

    @PostMapping("/add")
    public String addUser(@RequestParam String lastName,
                          @RequestParam String firstName,
                          @RequestParam String middleName,
                          @RequestParam String login,
                          @RequestParam String password,
                          @RequestParam String phoneNumber,
                          @RequestParam String email,
                          @RequestParam String address) {
        UserModel newUser = new UserModel(null, lastName, firstName, middleName,
                login, password, phoneNumber, email, address);
        userService.addUser(newUser);
        return "redirect:/userList?page=0";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam Long id,
                             @RequestParam String lastName,
                             @RequestParam String firstName,
                             @RequestParam String middleName,
                             @RequestParam String login,
                             @RequestParam String password,
                             @RequestParam String phoneNumber,
                             @RequestParam String email,
                             @RequestParam String address) {
        UserModel updatedUser = new UserModel(id, lastName, firstName, middleName,
                login, password, phoneNumber, email, address);
        userService.updateUser(updatedUser);
        return "redirect:/userList?page=0";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return "redirect:/userList?page=0";
    }

    @GetMapping("/searchById")
    public String searchUserById(@RequestParam Long id, Model model) {
        UserModel user = userService.findUserById(id);
        model.addAttribute("users", user != null ? List.of(user) : List.of());
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "userList";
    }

    @GetMapping("/searchByLogin")
    public String searchUserByLogin(@RequestParam String login, Model model) {
        List<UserModel> users = userService.findUsersByLogin(login);
        model.addAttribute("users", users != null ? users : List.of());
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "userList";
    }
    @GetMapping("/{id}/orders")
    public String getUserOrders(@PathVariable Long id, Model model) {
        UserModel user = userService.findUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("orders", user.getOrders());
        return "userOrders";
    }
}