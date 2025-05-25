package com.example.praktos3.order.repository;

import com.example.praktos3.order.model.OrderModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InMemoryOrderRepository extends JpaRepository<OrderModel, Long> {
    List<OrderModel> findByOrderDate(String orderDate);

    default List<OrderModel> findOrdersWithPagination(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        Page<OrderModel> orderPage = findAll(pageable);
        return orderPage.getContent();
    }
}