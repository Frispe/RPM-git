package com.example.praktos3.payment.controller;

import com.example.praktos3.payment.model.PaymentMethodModel;
import com.example.praktos3.payment.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/paymentMethodList")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @GetMapping
    public String getAllPaymentMethods(@RequestParam(defaultValue = "0") int page, Model model) {
        int size = 10;
        List<PaymentMethodModel> paymentMethods = paymentMethodService.findPaymentMethodsWithPagination(page, size);
        model.addAttribute("paymentMethods", paymentMethods);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages",
                (int) Math.ceil((double) paymentMethodService.findAllPaymentMethods().size() / size));
        return "paymentMethodList";
    }

    @PostMapping("/add")
    public String addPaymentMethod(@RequestParam String name) {
        PaymentMethodModel newPaymentMethod = new PaymentMethodModel(0, name);
        paymentMethodService.addPaymentMethod(newPaymentMethod);
        return "redirect:/paymentMethodList?page=0";
    }

    @PostMapping("/update")
    public String updatePaymentMethod(@RequestParam long id,
                                      @RequestParam String name) {
        PaymentMethodModel updatedPaymentMethod = new PaymentMethodModel(id, name);
        paymentMethodService.updatePaymentMethod(updatedPaymentMethod);
        return "redirect:/paymentMethodList?page=0";
    }

    @PostMapping("/delete")
    public String deletePaymentMethod(@RequestParam long id) {
        paymentMethodService.deletePaymentMethod(id);
        return "redirect:/paymentMethodList?page=0";
    }

    @GetMapping("/searchById")
    public String searchPaymentMethodById(@RequestParam long id, Model model) {
        PaymentMethodModel paymentMethod = paymentMethodService.findPaymentMethodById(id);
        model.addAttribute("paymentMethods", paymentMethod != null ? List.of(paymentMethod) : List.of());
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "paymentMethodList";
    }

    @GetMapping("/searchByName")
    public String searchPaymentMethodByName(@RequestParam String paymentMethod, Model model) {
        PaymentMethodModel paymentMethodModel = paymentMethodService.findPaymentMethodByName(paymentMethod);
        model.addAttribute("paymentMethods", paymentMethodModel != null ? List.of(paymentMethodModel) : List.of());
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "paymentMethodList";
    }
}