package com.example.praktos3.user.entity;

import com.example.praktos3.user.model.UserModel;

public class UserEntity extends UserModel {

    public UserEntity(int id, String lastName, String firstName, String middleName, String login, String password, String phoneNumber, String email, String address) {
        super((long) id, lastName, firstName, middleName, login, password, phoneNumber, email, address);
    }
}