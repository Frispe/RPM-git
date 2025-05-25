package com.example.praktos3.guarantee.model;

import com.example.praktos3.order.model.OrderModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;

@Entity
@Table(name = "Guarantee")
public class GuaranteeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Start date is required")
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    private LocalDate endDate;

    @Positive(message = "Duration must be positive")
    private int durationInDays;

    @OneToOne(mappedBy = "guarantee")
    private OrderModel order;

    public GuaranteeModel() {
    }

    public GuaranteeModel(long id, LocalDate startDate, LocalDate endDate, int durationInDays) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.durationInDays = durationInDays;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public int getDurationInDays() { return durationInDays; }
    public void setDurationInDays(int durationInDays) { this.durationInDays = durationInDays; }
    public OrderModel getOrder() {
        return order;
    }

    public void setOrder(OrderModel order) {
        this.order = order;
    }
}