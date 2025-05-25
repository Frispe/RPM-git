package com.example.praktos3.user.repository;

import com.example.praktos3.user.model.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InMemoryUserRepository extends JpaRepository<UserModel, Long> {
    List<UserModel> findUsersByLogin(String login);

    default List<UserModel> findUsersWithPagination(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        Page<UserModel> userPage = findAll(pageable);
        return userPage.getContent();
    }
}