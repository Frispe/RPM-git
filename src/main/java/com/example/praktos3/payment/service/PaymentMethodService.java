package com.example.praktos3.payment.service;

import com.example.praktos3.payment.model.PaymentMethodModel;
import java.util.List;

public interface PaymentMethodService {
    List<PaymentMethodModel> findAllPaymentMethods();
    PaymentMethodModel findPaymentMethodById(long id);
    PaymentMethodModel findPaymentMethodByName(String paymentMethod);
    PaymentMethodModel addPaymentMethod(PaymentMethodModel paymentMethod);
    PaymentMethodModel updatePaymentMethod(PaymentMethodModel paymentMethod);
    void deletePaymentMethod(long id);
    List<PaymentMethodModel> findPaymentMethodsWithPagination(int page, int size);
}