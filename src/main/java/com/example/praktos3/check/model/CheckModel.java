package com.example.praktos3.check.model;

import com.example.praktos3.order.model.OrderModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "checks")
public class CheckModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Receipt code cannot be blank")
    @Size(min = 3, max = 50, message = "Receipt code must be between 3 and 50 characters")
    private String receiptCode;

    @NotNull(message = "Total price cannot be null")
    @PositiveOrZero(message = "Total price must be positive or zero")
    private Double totalPrice;

    @NotBlank(message = "Delivery address cannot be blank")
    @Size(min = 10, max = 200, message = "Delivery address must be at least 10 characters")
    private String deliveryAddress;

    @OneToOne(mappedBy = "check")
    private OrderModel order;

    public CheckModel() {
    }

    public CheckModel(Long id, String receiptCode, Double totalPrice, String deliveryAddress) {
        this.id = id;
        this.receiptCode = receiptCode;
        this.totalPrice = totalPrice;
        this.deliveryAddress = deliveryAddress;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(String receiptCode) {
        this.receiptCode = receiptCode;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public OrderModel getOrder() {
        return order;
    }

    public void setOrder(OrderModel order) {
        this.order = order;
    }
}