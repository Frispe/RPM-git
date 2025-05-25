package com.example.praktos3.order.service;

import com.example.praktos3.order.model.OrderModel;
import java.util.List;

public interface OrderService {
    List<OrderModel> findAllOrders();
    OrderModel findOrderById(long id);
    List<OrderModel> findOrderByDate(String orderDate);
    OrderModel addOrder(OrderModel order);
    OrderModel updateOrder(OrderModel order);
    void deleteOrder(long id);
    List<OrderModel> findOrdersWithPagination(int page, int size);
}