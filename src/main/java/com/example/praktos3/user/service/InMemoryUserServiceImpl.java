package com.example.praktos3.user.service;

import com.example.praktos3.user.model.UserModel;
import com.example.praktos3.user.repository.InMemoryUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryUserServiceImpl implements UserService {

    private final InMemoryUserRepository userRepository;

    public InMemoryUserServiceImpl(InMemoryUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserModel> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserModel findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserModel addUser(UserModel user) {
        return userRepository.save(user);
    }

    @Override
    public UserModel updateUser(UserModel user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserModel> findUsersByLogin(String login) {
        return userRepository.findUsersByLogin(login);
    }

    @Override
    public List<UserModel> findUsersWithPagination(int page, int size) {
        return userRepository.findUsersWithPagination(page, size);
    }
}