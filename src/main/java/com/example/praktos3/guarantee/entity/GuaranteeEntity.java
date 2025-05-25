package com.example.praktos3.guarantee.entity;

import com.example.praktos3.guarantee.model.GuaranteeModel;
import java.time.LocalDate;

public class GuaranteeEntity extends GuaranteeModel {

    public GuaranteeEntity(int id, LocalDate startDate, LocalDate endDate, int durationInDays) {
        super(id, startDate, endDate, durationInDays);
    }
}