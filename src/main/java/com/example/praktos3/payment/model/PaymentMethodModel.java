package com.example.praktos3.payment.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "PaymentMethod")
public class PaymentMethodModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Payment method is required")
    private String name;

    public PaymentMethodModel() {
    }

    public PaymentMethodModel(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotBlank(message = "Payment method is required") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Payment method is required") String name) {
        this.name = name;
    }
}