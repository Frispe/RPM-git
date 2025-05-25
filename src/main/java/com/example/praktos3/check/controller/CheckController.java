package com.example.praktos3.check.controller;

import com.example.praktos3.check.model.CheckModel;
import com.example.praktos3.check.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/checkList")
public class CheckController {

    private final CheckService checkService;

    @Autowired
    public CheckController(CheckService checkService) {
        this.checkService = checkService;
    }

    @GetMapping
    public String getAllChecks(@RequestParam(defaultValue = "0") int page, Model model) {
        int size = 10;
        List<CheckModel> checks = checkService.findChecksWithPagination(page, size);
        model.addAttribute("checks", checks);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages",
                (int) Math.ceil((double) checkService.findAllChecks().size() / size));
        return "checkList";
    }

    @PostMapping("/add")
    public String addCheck(
            @RequestParam("receiptCode") String receiptCode,
            @RequestParam("totalPrice") Double totalPrice,
            @RequestParam("deliveryAddress") String deliveryAddress
    ) {
        CheckModel newCheck = new CheckModel(null, receiptCode, totalPrice, deliveryAddress);
        checkService.addCheck(newCheck);
        return "redirect:/checkList?page=0";
    }

    @PostMapping("/update")
    public String updateCheck(
            @RequestParam Long id,
            @RequestParam String receiptCode,
            @RequestParam double totalPrice,
            @RequestParam String deliveryAddress
    ) {
        CheckModel updatedCheck = new CheckModel(id, receiptCode, totalPrice, deliveryAddress);
        checkService.updateCheck(updatedCheck);
        return "redirect:/checkList?page=0";
    }

    @PostMapping("/delete")
    public String deleteCheck(@RequestParam Long id) {
        checkService.deleteCheck(id);
        return "redirect:/checkList?page=0";
    }

    @GetMapping("/searchById")
    public String searchCheckById(@RequestParam Long id, Model model) {
        CheckModel check = checkService.findCheckById(id);
        model.addAttribute("checks", check != null ? List.of(check) : List.of());
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "checkList";
    }

    @GetMapping("/searchByReceiptCode")
    public String searchCheckByReceiptCode(@RequestParam String receiptCode, Model model) {
        CheckModel check = checkService.findCheckByReceiptCode(receiptCode);
        model.addAttribute("checks", check != null ? List.of(check) : List.of());
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "checkList";
    }
}