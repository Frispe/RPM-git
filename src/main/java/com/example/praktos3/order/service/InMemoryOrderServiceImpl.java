package com.example.praktos3.order.service;

import com.example.praktos3.order.model.OrderModel;
import com.example.praktos3.order.repository.InMemoryOrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InMemoryOrderServiceImpl implements OrderService {

    private final InMemoryOrderRepository orderRepository;

    public InMemoryOrderServiceImpl(InMemoryOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderModel> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public OrderModel findOrderById(long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<OrderModel> findOrderByDate(String orderDate) {  // Изменен тип возвращаемого значения
        return orderRepository.findByOrderDate(orderDate);
    }

    @Override
    public OrderModel addOrder(OrderModel order) {
        return orderRepository.save(order);
    }

    @Override
    public OrderModel updateOrder(OrderModel order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<OrderModel> findOrdersWithPagination(int page, int size) {
        return orderRepository.findOrdersWithPagination(page, size);
    }
}