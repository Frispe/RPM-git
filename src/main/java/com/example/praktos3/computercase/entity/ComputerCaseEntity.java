package com.example.praktos3.computercase.entity;

import com.example.praktos3.computercase.model.ComputerCaseModel;

public class ComputerCaseEntity extends ComputerCaseModel {
    public ComputerCaseEntity(int id, int brandId, String model,
                              String formFactor, double price) {
        super(id, brandId, model, formFactor, price);
    }
}