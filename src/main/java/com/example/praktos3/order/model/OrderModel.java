package com.example.praktos3.order.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "orders")
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  // Изменено на IDENTITY для автоинкремента
    private long id;

    @Positive(message = "Assembly ID must be positive")
    @Column(nullable = false)
    private int assemblyId;

    @Positive(message = "Customer ID must be positive")
    @Column(nullable = false)
    private int customerId;

    @NotBlank(message = "Order date is required")
    @Column(nullable = false, name = "order_date")  // Указано имя колонки в БД
    private String orderDate;

    @NotBlank(message = "Status is required")
    @Column(nullable = false)
    private String status;

    @PositiveOrZero(message = "Total price must be positive or zero")
    @Column(nullable = false)
    private double totalPrice;

    @Positive(message = "Payment method ID must be positive")
    @Column(nullable = false)
    private int paymentMethodId;

    @Column(nullable = false)
    private String warrantyCode;

    @Positive(message = "Check ID must be positive")
    @Column(nullable = false)
    private int checkId;

    public OrderModel() {
    }

    public OrderModel(long id, int assemblyId, int customerId, String orderDate,
                      String status, double totalPrice, int paymentMethodId,
                      String warrantyCode, int checkId) {
        this.id = id;
        this.assemblyId = assemblyId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.status = status;
        this.totalPrice = totalPrice;
        this.paymentMethodId = paymentMethodId;
        this.warrantyCode = warrantyCode;
        this.checkId = checkId;
    }

    @Positive(message = "Check ID must be positive")
    public int getCheckId() {
        return checkId;
    }

    public void setCheckId(@Positive(message = "Check ID must be positive") int checkId) {
        this.checkId = checkId;
    }

    public String getWarrantyCode() {
        return warrantyCode;
    }

    public void setWarrantyCode(String warrantyCode) {
        this.warrantyCode = warrantyCode;
    }

    @Positive(message = "Payment method ID must be positive")
    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(@Positive(message = "Payment method ID must be positive") int paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    @PositiveOrZero(message = "Total price must be positive or zero")
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(@PositiveOrZero(message = "Total price must be positive or zero") double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public @NotBlank(message = "Status is required") String getStatus() {
        return status;
    }

    public void setStatus(@NotBlank(message = "Status is required") String status) {
        this.status = status;
    }

    public @NotBlank(message = "Order date is required") String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(@NotBlank(message = "Order date is required") String orderDate) {
        this.orderDate = orderDate;
    }

    @Positive(message = "Customer ID must be positive")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(@Positive(message = "Customer ID must be positive") int customerId) {
        this.customerId = customerId;
    }

    @Positive(message = "Assembly ID must be positive")
    public int getAssemblyId() {
        return assemblyId;
    }

    public void setAssemblyId(@Positive(message = "Assembly ID must be positive") int assemblyId) {
        this.assemblyId = assemblyId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}