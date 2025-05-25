package com.example.praktos3.assembly.model;

import com.example.praktos3.processor.model.ProcessorModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Assembly")
public class AssemblyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "CPU ID is required")
    private Long cpuId;

    @NotNull(message = "Motherboard ID is required")
    private Long motherboardId;

    @NotNull(message = "RAM ID is required")
    private Long ramId;

    @NotNull(message = "GPU ID is required")
    private Long gpuId;

    @NotNull(message = "Power supply ID is required")
    private Long powerSupplyId;

    @NotNull(message = "Case ID is required")
    private Long caseId;

    @NotNull(message = "Cooling system ID is required")
    private Long coolingSystemId;

    @NotNull(message = "PC builder ID is required")
    private Long pcBuilderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "processor_id")
    private ProcessorModel processor;

    public AssemblyModel() {
    }

    public AssemblyModel(long id, Long cpuId, Long motherboardId, Long ramId, Long gpuId,
                         Long powerSupplyId, Long caseId, Long coolingSystemId, Long pcBuilderId) {
        this.id = id;
        this.cpuId = cpuId;
        this.motherboardId = motherboardId;
        this.ramId = ramId;
        this.gpuId = gpuId;
        this.powerSupplyId = powerSupplyId;
        this.caseId = caseId;
        this.coolingSystemId = coolingSystemId;
        this.pcBuilderId = pcBuilderId;
    }

    // Геттеры и сеттеры
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public Long getCpuId() { return cpuId; }
    public void setCpuId(Long cpuId) { this.cpuId = cpuId; }
    public Long getMotherboardId() { return motherboardId; }
    public void setMotherboardId(Long motherboardId) { this.motherboardId = motherboardId; }
    public Long getRamId() { return ramId; }
    public void setRamId(Long ramId) { this.ramId = ramId; }
    public Long getGpuId() { return gpuId; }
    public void setGpuId(Long gpuId) { this.gpuId = gpuId; }
    public Long getPowerSupplyId() { return powerSupplyId; }
    public void setPowerSupplyId(Long powerSupplyId) { this.powerSupplyId = powerSupplyId; }
    public Long getCaseId() { return caseId; }
    public void setCaseId(Long caseId) { this.caseId = caseId; }
    public Long getCoolingSystemId() { return coolingSystemId; }
    public void setCoolingSystemId(Long coolingSystemId) { this.coolingSystemId = coolingSystemId; }
    public Long getPcBuilderId() { return pcBuilderId; }
    public void setPcBuilderId(Long pcBuilderId) { this.pcBuilderId = pcBuilderId; }
    public ProcessorModel getProcessor() {
        return processor;
    }

    public void setProcessor(ProcessorModel processor) {
        this.processor = processor;
    }
}