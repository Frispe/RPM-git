package com.example.praktos3.assembly.controller;

import com.example.praktos3.assembly.model.AssemblyModel;
import com.example.praktos3.assembly.service.AssemblyService;
import com.example.praktos3.processor.model.ProcessorModel;
import com.example.praktos3.processor.service.ProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Controller
@RequestMapping("/assemblyList")
public class AssemblyController {

    @Autowired
    private AssemblyService assemblyService;

    @Autowired
    private ProcessorService processorService;

    @GetMapping
    public String getAllAssemblies(@RequestParam(defaultValue = "0") int page, Model model) {
        int size = 10;
        List<AssemblyModel> assemblies = assemblyService.findAssembliesWithPagination(page, size);
        List<ProcessorModel> processors = processorService.findAllProcessors();

        model.addAttribute("assemblies", assemblies);
        model.addAttribute("processors", processors);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages",
                (int) Math.ceil((double) assemblyService.findAllAssemblies().size() / size));
        return "assemblyList";
    }

    @PostMapping("/add")
    public String addAssembly(@RequestParam Long processorId,
                              @RequestParam Long motherboardId,
                              @RequestParam Long ramId,
                              @RequestParam Long gpuId,
                              @RequestParam Long powerSupplyId,
                              @RequestParam Long caseId,
                              @RequestParam Long coolingSystemId,
                              @RequestParam Long pcBuilderId) {

        ProcessorModel processor = processorService.findProcessorById(processorId);
        if (processor == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Processor not found");
        }

        AssemblyModel newAssembly = new AssemblyModel();
        newAssembly.setProcessor(processor);
        newAssembly.setMotherboardId(motherboardId);
        newAssembly.setRamId(ramId);
        newAssembly.setGpuId(gpuId);
        newAssembly.setPowerSupplyId(powerSupplyId);
        newAssembly.setCaseId(caseId);
        newAssembly.setCoolingSystemId(coolingSystemId);
        newAssembly.setPcBuilderId(pcBuilderId);

        assemblyService.addAssembly(newAssembly);
        return "redirect:/assemblyList?page=0";
    }

    @PostMapping("/update")
    public String updateAssembly(@RequestParam long id,
                                 @RequestParam Long processorId,
                                 @RequestParam Long motherboardId,
                                 @RequestParam Long ramId,
                                 @RequestParam Long gpuId,
                                 @RequestParam Long powerSupplyId,
                                 @RequestParam Long caseId,
                                 @RequestParam Long coolingSystemId,
                                 @RequestParam Long pcBuilderId) {

        ProcessorModel processor = processorService.findProcessorById(processorId);
        if (processor == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Processor not found");
        }

        AssemblyModel assembly = assemblyService.findAssemblyById(id);
        assembly.setProcessor(processor);
        assembly.setMotherboardId(motherboardId);
        assembly.setRamId(ramId);
        assembly.setGpuId(gpuId);
        assembly.setPowerSupplyId(powerSupplyId);
        assembly.setCaseId(caseId);
        assembly.setCoolingSystemId(coolingSystemId);
        assembly.setPcBuilderId(pcBuilderId);

        assemblyService.updateAssembly(assembly);
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
        List<ProcessorModel> processors = processorService.findAllProcessors();

        model.addAttribute("assemblies", assembly != null ? List.of(assembly) : List.of());
        model.addAttribute("processors", processors);
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "assemblyList";
    }

    @GetMapping("/searchByPcBuilderId")
    public String searchAssemblyByPcBuilderId(@RequestParam Long pcBuilderId, Model model) {
        AssemblyModel assembly = assemblyService.findAssemblyByPcBuilderId(pcBuilderId);
        List<ProcessorModel> processors = processorService.findAllProcessors();

        model.addAttribute("assemblies", assembly != null ? List.of(assembly) : List.of());
        model.addAttribute("processors", processors);
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "assemblyList";
    }
}