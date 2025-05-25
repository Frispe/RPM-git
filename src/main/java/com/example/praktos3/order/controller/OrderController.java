package com.example.praktos3.order.controller;

import com.example.praktos3.order.model.OrderModel;
import com.example.praktos3.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/orderList")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String getAllOrders(@RequestParam(defaultValue = "0") int page, Model model) {
        int size = 10;
        List<OrderModel> orders = orderService.findOrdersWithPagination(page, size);
        model.addAttribute("orders", orders);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages",
                (int) Math.ceil((double) orderService.findAllOrders().size() / size));
        return "orderList";
    }

    @PostMapping("/add")
    public String addOrder(@RequestParam int assemblyId,
                           @RequestParam int customerId,
                           @RequestParam String orderDate,
                           @RequestParam String status,
                           @RequestParam double totalPrice,
                           @RequestParam int paymentMethodId,
                           @RequestParam String warrantyCode,
                           @RequestParam int checkId) {
        OrderModel newOrder = new OrderModel(0, assemblyId, customerId, orderDate,
                status, totalPrice, paymentMethodId,
                warrantyCode, checkId);
        orderService.addOrder(newOrder);
        return "redirect:/orderList?page=0";
    }

    @PostMapping("/update")
    public String updateOrder(@RequestParam long id,
                              @RequestParam int assemblyId,
                              @RequestParam int customerId,
                              @RequestParam String orderDate,
                              @RequestParam String status,
                              @RequestParam double totalPrice,
                              @RequestParam int paymentMethodId,
                              @RequestParam String warrantyCode,
                              @RequestParam int checkId) {
        OrderModel updatedOrder = new OrderModel(id, assemblyId, customerId, orderDate,
                status, totalPrice, paymentMethodId,
                warrantyCode, checkId);
        orderService.updateOrder(updatedOrder);
        return "redirect:/orderList?page=0";
    }

    @PostMapping("/delete")
    public String deleteOrder(@RequestParam long id) {
        orderService.deleteOrder(id);
        return "redirect:/orderList?page=0";
    }

    @GetMapping("/searchById")
    public String searchOrderById(@RequestParam long id, Model model) {
        OrderModel order = orderService.findOrderById(id);
        model.addAttribute("orders", order != null ? List.of(order) : List.of());
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "orderList";
    }

    @GetMapping("/searchByDate")
    public String searchOrderByDate(@RequestParam String orderDate, Model model) {
        List<OrderModel> orders = orderService.findOrderByDate(orderDate);
        model.addAttribute("orders", orders != null ? orders : List.of());
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "orderList";
    }
}