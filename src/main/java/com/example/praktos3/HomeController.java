package com.example.praktos3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String home() {
        return "index";
    }

    @GetMapping("/additions")
    public String additions() {
        return "redirect:/additionList";
    }

    @GetMapping("/brands")
    public String brands() {
        return "redirect:/brandList";
    }

    @GetMapping("/checks")
    public String checks() {
        return "redirect:/checkList";
    }

    @GetMapping("/computerCases")
    public String computerCases() {
        return "redirect:/computerCaseList";
    }

    @GetMapping("/coolingSystems")
    public String coolingSystems() {
        return "redirect:/coolingSystemList";
    }

    @GetMapping("/coolingTypes")
    public String coolingTypes() {
        return "redirect:/coolingTypeList";
    }

    @GetMapping("/graphicsCards")
    public String graphicsCards() {
        return "redirect:/graphicsCardList";
    }

    @GetMapping("/guarantees")
    public String guarantees() {
        return "redirect:/guaranteeList";
    }

    @GetMapping("/motherboards")
    public String motherboards() {
        return "redirect:/motherboardList";
    }

    @GetMapping("/orders")
    public String orders() {
        return "redirect:/orderList";
    }

    @GetMapping("/paymentMethods")
    public String paymentMethods() {
        return "redirect:/paymentMethodList";
    }

    @GetMapping("/pcBuilders")
    public String pcBuilders() {
        return "redirect:/pcBuilderList";
    }

    @GetMapping("/powerSupplies")
    public String powerSupplies() {
        return "redirect:/powerSupplyList";
    }

    @GetMapping("/processors")
    public String processors() {
        return "redirect:/processorList";
    }

    @GetMapping("/rams")
    public String rams() {
        return "redirect:/ramList";
    }

    @GetMapping("/roles")
    public String roles() {
        return "redirect:/roleList";
    }

    @GetMapping("/storages")
    public String storages() {
        return "redirect:/storageList";
    }

    @GetMapping("/storageTypes")
    public String storageTypes() {
        return "redirect:/storageTypeList";
    }

    @GetMapping("/users")
    public String users() {
        return "redirect:/userList";
    }
}