package com.example.praktos3.check.entity;

import com.example.praktos3.check.model.CheckModel;

public class CheckEntity extends CheckModel {
    public CheckEntity(int id, String receiptCode, double totalPrice, String deliveryAddress) {
        super((long) id, receiptCode, totalPrice, deliveryAddress);
    }
}