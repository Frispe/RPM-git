package com.example.praktos3.addition.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Addition")
public class AdditionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Addition is required")
    private String name;

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
}