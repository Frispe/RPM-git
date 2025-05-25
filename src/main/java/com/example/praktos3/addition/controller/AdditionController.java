package com.example.praktos3.addition.controller;

import com.example.praktos3.addition.model.AdditionModel;
import com.example.praktos3.addition.service.AdditionService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdditionController {

    @Autowired
    private AdditionService additionService;

    @GetMapping("/additionList")
    public String getAllAdditions(@RequestParam(defaultValue = "0") int page, Model model) {
        int size = 10;
        List<AdditionModel> additions = additionService.findAdditionsWithPagination(page, size);
        model.addAttribute("additions", additions);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", (int) Math.ceil((double) additionService.findAllAdditions().size() / size));
        return "additionList";
    }

    @PostMapping("/additionList/add")
    public String addAddition(@RequestParam @NotBlank String name) {
        AdditionModel newAddition = new AdditionModel(0, name);
        additionService.addAddition(newAddition);
        return "redirect:/additionList?page=0";
    }

    @PostMapping("/additionList/update")
    public String updateAddition(@RequestParam int id,
                                 @RequestParam String name) {
        AdditionModel updatedAddition = new AdditionModel(id, name);
        additionService.updateAddition(updatedAddition);
        return "redirect:/additionList?page=0";
    }

    @PostMapping("/additionList/delete")
    public String deleteAddition(@RequestParam int id) {
        additionService.deleteAddition(id);
        return "redirect:/additionList?page=0";
    }

    @GetMapping("/additionList/searchById")
    public String searchAdditionById(@RequestParam int id, Model model) {
        AdditionModel addition = additionService.findAdditionById(id);
        if (addition != null) {
            model.addAttribute("additions", List.of(addition));
        } else {
            model.addAttribute("additions", List.of());
        }
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "additionList";
    }

    @GetMapping("/additionList/searchByName")
    public String searchAdditionByName(@RequestParam String name, Model model) {
        AdditionModel addition = additionService.findAdditionByName(name);
        if (addition != null) {
            model.addAttribute("additions", List.of(addition));
        } else {
            model.addAttribute("additions", List.of());
        }
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "additionList";
    }
}