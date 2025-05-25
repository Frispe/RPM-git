package com.example.praktos3.user.service;

import com.example.praktos3.user.model.UserModel;
import java.util.List;

public interface UserService {
    List<UserModel> findAllUsers();
    UserModel findUserById(Long id);
    UserModel addUser(UserModel user);
    UserModel updateUser(UserModel user);
    void deleteUser(Long id);
    List<UserModel> findUsersByLogin(String login);
    List<UserModel> findUsersWithPagination(int page, int size);
}