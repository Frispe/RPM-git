package com.example.praktos3.addition.model;

import com.example.praktos3.order.model.OrderModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "Addition")
public class AdditionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Addition is required")
    private String name;

    @ManyToMany(mappedBy = "additions", fetch = FetchType.LAZY)
    private List<OrderModel> orders;

    public AdditionModel(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public @NotBlank(message = "Addition is required") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Addition is required") String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public AdditionModel() {
    }

    public List<OrderModel> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderModel> orders) {
        this.orders = orders;
    }
}