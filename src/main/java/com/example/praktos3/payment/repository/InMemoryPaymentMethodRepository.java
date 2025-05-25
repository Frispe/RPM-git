package com.example.praktos3.payment.repository;

import com.example.praktos3.payment.model.PaymentMethodModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InMemoryPaymentMethodRepository extends JpaRepository<PaymentMethodModel, Long> {
    PaymentMethodModel findByName(String name);

    default List<PaymentMethodModel> findPaymentMethodsWithPagination(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        Page<PaymentMethodModel> paymentMethodPage = findAll(pageable);
        return paymentMethodPage.getContent();
    }
}