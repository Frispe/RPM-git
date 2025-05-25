package com.example.praktos3.PCBuilder.controller;

import com.example.praktos3.PCBuilder.model.PCBuilderModel;
import com.example.praktos3.PCBuilder.service.PCBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/pcBuilderList")
public class PCBuilderController {

    @Autowired
    private PCBuilderService pcBuilderService;

    @GetMapping
    public String getAllPCBuilders(@RequestParam(defaultValue = "0") int page, Model model) {
        int size = 10;
        List<PCBuilderModel> pcBuilders = pcBuilderService.findPCBuildersWithPagination(page, size);
        model.addAttribute("pcBuilders", pcBuilders);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages",
                (int) Math.ceil((double) pcBuilderService.findAllPCBuilders().size() / size));
        return "pcBuilderList";
    }

    @PostMapping("/add")
    public String addPCBuilder(@RequestParam String lastName,
                               @RequestParam String firstName,
                               @RequestParam String middleName,
                               @RequestParam int experience,
                               @RequestParam double salary) {
        PCBuilderModel newPCBuilder = new PCBuilderModel(0, lastName, firstName, middleName, experience, salary);
        pcBuilderService.addPCBuilder(newPCBuilder);
        return "redirect:/pcBuilderList?page=0";
    }

    @PostMapping("/update")
    public String updatePCBuilder(@RequestParam long id,
                                  @RequestParam String lastName,
                                  @RequestParam String firstName,
                                  @RequestParam String middleName,
                                  @RequestParam int experience,
                                  @RequestParam double salary) {
        PCBuilderModel updatedPCBuilder = new PCBuilderModel(id, lastName, firstName, middleName, experience, salary);
        pcBuilderService.updatePCBuilder(updatedPCBuilder);
        return "redirect:/pcBuilderList?page=0";
    }

    @PostMapping("/delete")
    public String deletePCBuilder(@RequestParam long id) {
        pcBuilderService.deletePCBuilder(id);
        return "redirect:/pcBuilderList?page=0";
    }

    @GetMapping("/searchById")
    public String searchPCBuilderById(@RequestParam long id, Model model) {
        PCBuilderModel pcBuilder = pcBuilderService.findPCBuilderById(id);
        model.addAttribute("pcBuilders", pcBuilder != null ? List.of(pcBuilder) : List.of());
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "pcBuilderList";
    }

    @GetMapping("/searchByName")
    public String searchPCBuilderByName(@RequestParam String firstName, Model model) {
        PCBuilderModel pcBuilder = pcBuilderService.findPCBuilderByFirstName(firstName);
        model.addAttribute("pcBuilders", pcBuilder != null ? List.of(pcBuilder) : List.of());
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "pcBuilderList";
    }
}