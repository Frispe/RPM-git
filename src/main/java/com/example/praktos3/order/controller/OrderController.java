package com.example.praktos3.order.controller;

import com.example.praktos3.addition.model.AdditionModel;
import com.example.praktos3.addition.service.AdditionService;
import com.example.praktos3.check.model.CheckModel;
import com.example.praktos3.guarantee.model.GuaranteeModel;
import com.example.praktos3.order.model.OrderModel;
import com.example.praktos3.order.service.OrderService;
import com.example.praktos3.payment.model.PaymentMethodModel;
import com.example.praktos3.payment.service.PaymentMethodService;
import com.example.praktos3.user.model.UserModel;
import com.example.praktos3.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/orderList")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private PaymentMethodService paymentMethodService;

    @Autowired
    private AdditionService additionService;

    @GetMapping
    public String getAllOrders(@RequestParam(defaultValue = "0") int page, Model model) {
        int size = 10;
        List<OrderModel> orders = orderService.findOrdersWithPagination(page, size);
        List<UserModel> users = userService.findAllUsers();
        List<AdditionModel> additions = additionService.findAllAdditions();
        List<PaymentMethodModel> paymentMethods = paymentMethodService.findAllPaymentMethods();

        model.addAttribute("orders", orders);
        model.addAttribute("users", users);
        model.addAttribute("additions", additions);
        model.addAttribute("paymentMethods", paymentMethods);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages",
                (int) Math.ceil((double) orderService.findAllOrders().size() / size));
        return "orderList";
    }

    @PostMapping("/add")
    public String addOrder(
            @RequestParam Long userId,
            @RequestParam int assemblyId,
            @RequestParam String orderDate,
            @RequestParam String status,
            @RequestParam double totalPrice,
            @RequestParam Long paymentMethodId,
            @RequestParam String warrantyCode,
            @RequestParam(required = false) List<Long> additionIds,
            @RequestParam String receiptCode,
            @RequestParam String deliveryAddress,
            @RequestParam String guaranteeStartDate,
            @RequestParam String guaranteeEndDate,
            @RequestParam int guaranteeDuration) {

        UserModel user = userService.findUserById(userId);
        PaymentMethodModel paymentMethod = paymentMethodService.findPaymentMethodById(paymentMethodId);

        if (user == null || paymentMethod == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User or Payment Method not found");
        }


        CheckModel check = new CheckModel();
        check.setReceiptCode(receiptCode);
        check.setTotalPrice(totalPrice);
        check.setDeliveryAddress(deliveryAddress);


        GuaranteeModel guarantee = new GuaranteeModel();
        guarantee.setStartDate(LocalDate.parse(guaranteeStartDate));
        guarantee.setEndDate(LocalDate.parse(guaranteeEndDate));
        guarantee.setDurationInDays(guaranteeDuration);


        OrderModel newOrder = new OrderModel();
        newOrder.setUser(user);
        newOrder.setAssemblyId(assemblyId);
        newOrder.setOrderDate(orderDate);
        newOrder.setStatus(status);
        newOrder.setTotalPrice(totalPrice);
        newOrder.setPaymentMethod(paymentMethod);
        newOrder.setWarrantyCode(warrantyCode);
        newOrder.setGuarantee(guarantee);
        newOrder.setCheck(check);

        if (additionIds != null && !additionIds.isEmpty()) {
            List<AdditionModel> additions = additionService.findAllById(additionIds);
            newOrder.setAdditions(additions);
        }


        orderService.addOrder(newOrder);
        return "redirect:/orderList?page=0";
    }

    @PostMapping("/update")
    public String updateOrder(
            @RequestParam Long id,
            @RequestParam Long userId,
            @RequestParam int assemblyId,
            @RequestParam String orderDate,
            @RequestParam String status,
            @RequestParam double totalPrice,
            @RequestParam Long paymentMethodId,
            @RequestParam String warrantyCode,
            @RequestParam(required = false) List<Long> additionIds,
            @RequestParam String guaranteeStartDate,
            @RequestParam String guaranteeEndDate,
            @RequestParam int guaranteeDuration,
            @RequestParam String receiptCode,
            @RequestParam String deliveryAddress) {

        OrderModel existingOrder = orderService.findOrderById(id);
        if (existingOrder == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found");
        }

        UserModel user = userService.findUserById(userId);
        PaymentMethodModel paymentMethod = paymentMethodService.findPaymentMethodById(paymentMethodId);

        if (user == null || paymentMethod == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User or Payment Method not found");
        }


        CheckModel check = existingOrder.getCheck();
        if (check == null) {
            check = new CheckModel();
        }
        check.setReceiptCode(receiptCode);
        check.setTotalPrice(totalPrice);
        check.setDeliveryAddress(deliveryAddress);


        GuaranteeModel guarantee = existingOrder.getGuarantee();
        if (guarantee == null) {
            guarantee = new GuaranteeModel();
        }
        guarantee.setStartDate(LocalDate.parse(guaranteeStartDate));
        guarantee.setEndDate(LocalDate.parse(guaranteeEndDate));
        guarantee.setDurationInDays(guaranteeDuration);

        // Обновляем заказ
        existingOrder.setUser(user);
        existingOrder.setAssemblyId(assemblyId);
        existingOrder.setOrderDate(orderDate);
        existingOrder.setStatus(status);
        existingOrder.setTotalPrice(totalPrice);
        existingOrder.setPaymentMethod(paymentMethod);
        existingOrder.setWarrantyCode(warrantyCode);
        existingOrder.setGuarantee(guarantee);
        existingOrder.setCheck(check);

        if (additionIds != null) {
            List<AdditionModel> additions = additionService.findAllById(additionIds);
            existingOrder.setAdditions(additions);
        }

        orderService.updateOrder(existingOrder);
        return "redirect:/orderList?page=0";
    }

    @PostMapping("/delete")
    public String deleteOrder(@RequestParam Long id) {
        orderService.deleteOrder(id);
        return "redirect:/orderList?page=0";
    }

    @GetMapping("/searchById")
    public String searchOrderById(@RequestParam Long id, Model model) {
        OrderModel order = orderService.findOrderById(id);
        List<UserModel> users = userService.findAllUsers();
        List<AdditionModel> additions = additionService.findAllAdditions();

        model.addAttribute("orders", order != null ? List.of(order) : List.of());
        model.addAttribute("users", users);
        model.addAttribute("additions", additions);
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "orderList";
    }

    @GetMapping("/searchByDate")
    public String searchOrderByDate(@RequestParam String orderDate, Model model) {
        List<OrderModel> orders = orderService.findOrderByDate(orderDate);
        List<UserModel> users = userService.findAllUsers();
        List<AdditionModel> additions = additionService.findAllAdditions();

        model.addAttribute("orders", orders != null ? orders : List.of());
        model.addAttribute("users", users);
        model.addAttribute("additions", additions);
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "orderList";
    }
}