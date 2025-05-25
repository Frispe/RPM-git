package com.example.praktos3.coolingsystem.entity;

import com.example.praktos3.coolingsystem.model.CoolingSystemModel;

public class CoolingSystemEntity extends CoolingSystemModel {
    public CoolingSystemEntity(int id, int brandId, String model,
                               int coolingTypeId, double price) {
        super(id, brandId, model, coolingTypeId, price);
    }
}