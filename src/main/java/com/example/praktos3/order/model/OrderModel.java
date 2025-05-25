package com.example.praktos3.order.model;

import com.example.praktos3.addition.model.AdditionModel;
import com.example.praktos3.check.model.CheckModel;
import com.example.praktos3.guarantee.model.GuaranteeModel;
import com.example.praktos3.payment.model.PaymentMethodModel;
import com.example.praktos3.user.model.UserModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;

@Entity
@Table(name = "orders")
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive(message = "Assembly ID must be positive")
    private int assemblyId;

    @NotBlank(message = "Order date is required")
    private String orderDate;

    @NotBlank(message = "Status is required")
    private String status;

    @PositiveOrZero(message = "Total price must be positive or zero")
    private double totalPrice;

    @Column(nullable = false)
    private String warrantyCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "check_id", referencedColumnName = "id")
    private CheckModel check;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "order_additions",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "addition_id"))
    private List<AdditionModel> additions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guarantee_id", referencedColumnName = "id")
    private GuaranteeModel guarantee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_method_id", nullable = false)
    private PaymentMethodModel paymentMethod;


    public OrderModel() {
    }

    public OrderModel(long id, int assemblyId, int customerId, String orderDate,
                      String status, double totalPrice, int paymentMethodId,
                      String warrantyCode, int checkId) {
        this.id = id;
        this.assemblyId = assemblyId;
        this.orderDate = orderDate;
        this.status = status;
        this.totalPrice = totalPrice;
        this.warrantyCode = warrantyCode;

    }

    @Positive(message = "Check ID must be positive")
    public CheckModel getCheck() {
        return check;
    }

    public void setCheck(CheckModel check) {
        this.check = check;
    }

    public String getWarrantyCode() {
        return warrantyCode;
    }

    public void setWarrantyCode(String warrantyCode) {
        this.warrantyCode = warrantyCode;
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

    public List<AdditionModel> getAdditions() {
        return additions;
    }

    public void setAdditions(List<AdditionModel> additions) {
        this.additions = additions;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
    public GuaranteeModel getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(GuaranteeModel guarantee) {
        this.guarantee = guarantee;
    }

    public PaymentMethodModel getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodModel paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}