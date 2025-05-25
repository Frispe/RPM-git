package com.example.praktos3.order.entity;

import com.example.praktos3.order.model.OrderModel;

public class OrderEntity extends OrderModel {
    public OrderEntity(int id, int assemblyId, int customerId, String orderDate,
                       String status, double totalPrice, int paymentMethodId,
                       String warrantyCode, int checkId) {
        super(id, assemblyId, customerId, orderDate, status, totalPrice,
                paymentMethodId, warrantyCode, checkId);
    }
}