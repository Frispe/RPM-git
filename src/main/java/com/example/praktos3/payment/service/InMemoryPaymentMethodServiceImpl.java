package com.example.praktos3.payment.service;

import com.example.praktos3.payment.model.PaymentMethodModel;
import com.example.praktos3.payment.repository.InMemoryPaymentMethodRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InMemoryPaymentMethodServiceImpl implements PaymentMethodService {

    private final InMemoryPaymentMethodRepository paymentMethodRepository;

    public InMemoryPaymentMethodServiceImpl(InMemoryPaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    public List<PaymentMethodModel> findAllPaymentMethods() {
        return paymentMethodRepository.findAll();
    }

    @Override
    public PaymentMethodModel findPaymentMethodById(long id) {
        return paymentMethodRepository.findById(id).orElse(null);
    }

    @Override
    public PaymentMethodModel findPaymentMethodByName(String name) {
        return paymentMethodRepository.findByName(name);
    }

    @Override
    public PaymentMethodModel addPaymentMethod(PaymentMethodModel paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public PaymentMethodModel updatePaymentMethod(PaymentMethodModel paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public void deletePaymentMethod(long id) {
        paymentMethodRepository.deleteById(id);
    }

    @Override
    public List<PaymentMethodModel> findPaymentMethodsWithPagination(int page, int size) {
        return paymentMethodRepository.findPaymentMethodsWithPagination(page, size);
    }
}