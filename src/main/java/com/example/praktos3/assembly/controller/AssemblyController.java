package com.example.praktos3.assembly.controller;

import com.example.praktos3.assembler.model.AssemblerModel;
import com.example.praktos3.assembler.service.AssemblerService;
import com.example.praktos3.casepc.model.CaseModel;
import com.example.praktos3.casepc.service.CaseService;
import com.example.praktos3.coolingsystem.model.CoolingSystemModel;
import com.example.praktos3.coolingsystem.service.CoolingSystemService;
import com.example.praktos3.gpu.model.GpuModel;
import com.example.praktos3.gpu.service.GpuService;
import com.example.praktos3.motherboard.model.MotherboardModel;
import com.example.praktos3.motherboard.service.MotherboardService;
import com.example.praktos3.powersupply.model.PowerSupplyModel;
import com.example.praktos3.powersupply.service.PowerSupplyService;
import com.example.praktos3.processor.model.ProcessorModel;
import com.example.praktos3.processor.service.ProcessorService;
import com.example.praktos3.ram.model.RamModel;
import com.example.praktos3.ram.service.RamService;
import com.example.praktos3.assembly.model.AssemblyModel;
import com.example.praktos3.assembly.service.AssemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/assemblyList")
public class AssemblyController {

    @Autowired
    private AssemblyService assemblyService;

    @Autowired
    private ProcessorService processorService;

    @Autowired
    private MotherboardService motherboardService;

    @Autowired
    private RamService ramService;

    @Autowired
    private GpuService gpuService;

    @Autowired
    private PowerSupplyService powerSupplyService;

    @Autowired
    private CaseService caseService;

    @Autowired
    private CoolingSystemService coolingSystemService;

    @Autowired
    private AssemblerService assemblerService;

    @GetMapping
    public String getAllAssemblies(@RequestParam(defaultValue = "0") int page, Model model) {
        int size = 10;
        List<AssemblyModel> assemblies = assemblyService.findAssembliesWithPagination(page, size);

        model.addAttribute("assemblies", assemblies);
        model.addAttribute("processors", processorService.findAllProcessors());
        model.addAttribute("motherboards", motherboardService.findAllMotherboards());
        model.addAttribute("rams", ramService.findAllRams());
        model.addAttribute("gpus", gpuService.findAllGpus());
        model.addAttribute("powerSupplies", powerSupplyService.findAllPowerSupplies());
        model.addAttribute("cases", caseService.findAllCases());
        model.addAttribute("coolingSystems", coolingSystemService.findAllCoolingSystems());
        model.addAttribute("assemblers", assemblerService.findAllAssemblers());

        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", (int) Math.ceil((double) assemblyService.findAllAssemblies().size() / size));
        return "assemblyList";
    }

    @PostMapping("/add")
    public String addAssembly(
            @RequestParam Long processorId,
            @RequestParam Long motherboardId,
            @RequestParam Long ramId,
            @RequestParam Long gpuId,
            @RequestParam Long powerSupplyId,
            @RequestParam Long caseId,
            @RequestParam Long coolingSystemId,
            @RequestParam Long assemblerId) {

        AssemblyModel newAssembly = new AssemblyModel();
        newAssembly.setProcessor(processorService.findProcessorById(processorId));
        newAssembly.setMotherboard(motherboardService.findMotherboardById(motherboardId));
        newAssembly.setRam(ramService.findRamById(ramId));
        newAssembly.setGpu(gpuService.findGpuById(gpuId));
        newAssembly.setPowerSupply(powerSupplyService.findPowerSupplyById(powerSupplyId));
        newAssembly.setCasePc(caseService.findCaseById(caseId));
        newAssembly.setCoolingSystem(coolingSystemService.findCoolingSystemById(coolingSystemId));
        newAssembly.setAssembler(assemblerService.findAssemblerById(assemblerId));

        assemblyService.addAssembly(newAssembly);
        return "redirect:/assemblyList?page=0";
    }

    @PostMapping("/update")
    public String updateAssembly(
            @RequestParam long id,
            @RequestParam Long processorId,
            @RequestParam Long motherboardId,
            @RequestParam Long ramId,
            @RequestParam Long gpuId,
            @RequestParam Long powerSupplyId,
            @RequestParam Long caseId,
            @RequestParam Long coolingSystemId,
            @RequestParam Long assemblerId) {

        AssemblyModel updatedAssembly = new AssemblyModel();
        updatedAssembly.setId(id);
        updatedAssembly.setProcessor(processorService.findProcessorById(processorId));
        updatedAssembly.setMotherboard(motherboardService.findMotherboardById(motherboardId));
        updatedAssembly.setRam(ramService.findRamById(ramId));
        updatedAssembly.setGpu(gpuService.findGpuById(gpuId));
        updatedAssembly.setPowerSupply(powerSupplyService.findPowerSupplyById(powerSupplyId));
        updatedAssembly.setCasePc(caseService.findCaseById(caseId));
        updatedAssembly.setCoolingSystem(coolingSystemService.findCoolingSystemById(coolingSystemId));
        updatedAssembly.setAssembler(assemblerService.findAssemblerById(assemblerId));

        assemblyService.updateAssembly(updatedAssembly);
        return "redirect:/assemblyList?page=0";
    }

    @PostMapping("/delete")
    public String deleteAssembly(@RequestParam long id) {
        assemblyService.deleteAssembly(id);
        return "redirect:/assemblyList?page=0";
    }

    @GetMapping("/searchById")
    public String searchAssemblyById(@RequestParam long id, Model model) {
        AssemblyModel assembly = assemblyService.findAssemblyById(id);
        model.addAttribute("assemblies", assembly != null ? List.of(assembly) : List.of());
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "assemblyList";
    }
}