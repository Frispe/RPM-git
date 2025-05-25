package com.example.praktos3.guarantee.controller;

import com.example.praktos3.guarantee.model.GuaranteeModel;
import com.example.praktos3.guarantee.service.GuaranteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/guaranteeList")
public class GuaranteeController {

    @Autowired
    private GuaranteeService guaranteeService;

    @GetMapping
    public String getAllGuarantees(@RequestParam(defaultValue = "0") int page, Model model) {
        int size = 10;
        List<GuaranteeModel> guarantees = guaranteeService.findGuaranteesWithPagination(page, size);
        model.addAttribute("guarantees", guarantees);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages",
                (int) Math.ceil((double) guaranteeService.findAllGuarantees().size() / size));
        return "guaranteeList";
    }

    @PostMapping("/add")
    public String addGuarantee(@RequestParam String startDate,
                               @RequestParam String endDate,
                               @RequestParam int durationInDays) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        GuaranteeModel newGuarantee = new GuaranteeModel(0, start, end, durationInDays);
        guaranteeService.addGuarantee(newGuarantee);
        return "redirect:/guaranteeList?page=0";
    }

    @PostMapping("/update")
    public String updateGuarantee(@RequestParam long id,
                                  @RequestParam String startDate,
                                  @RequestParam String endDate,
                                  @RequestParam int durationInDays) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        GuaranteeModel updatedGuarantee = new GuaranteeModel(id, start, end, durationInDays);
        guaranteeService.updateGuarantee(updatedGuarantee);
        return "redirect:/guaranteeList?page=0";
    }

    @PostMapping("/delete")
    public String deleteGuarantee(@RequestParam long id) {
        guaranteeService.deleteGuarantee(id);
        return "redirect:/guaranteeList?page=0";
    }

    @GetMapping("/searchById")
    public String searchGuaranteeById(@RequestParam long id, Model model) {
        GuaranteeModel guarantee = guaranteeService.findGuaranteeById(id);
        model.addAttribute("guarantees", guarantee != null ? List.of(guarantee) : List.of());
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "guaranteeList";
    }

    @GetMapping("/searchByStartDate")
    public String searchGuaranteeByStartDate(@RequestParam String startDate, Model model) {
        LocalDate start = LocalDate.parse(startDate);
        GuaranteeModel guarantee = guaranteeService.findGuaranteeByStartDate(start);
        model.addAttribute("guarantees", guarantee != null ? List.of(guarantee) : List.of());
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "guaranteeList";
    }
}