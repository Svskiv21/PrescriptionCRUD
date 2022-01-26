package com.example.PrescriptionCRUD.controllers;

import com.example.PrescriptionCRUD.dtos.PrescriptionCreateDTO;
import com.example.PrescriptionCRUD.dtos.PrescriptionShowDTO;
import com.example.PrescriptionCRUD.services.PrescriptionService;
import lombok.Data;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping(path = "/prescriptions/")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_DOCTOR', 'ROLE_PATIENT', 'ROLE_ADMIN')")
    public List<PrescriptionShowDTO> getPrescriptions(){
        return prescriptionService.getPrescriptions();
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_DOCTOR', 'ROLE_ADMIN')")
    public void addNewPrescription(@RequestBody PrescriptionCreateDTO prescription){
        prescriptionService.addNewPrescription(prescription);
    }

    @DeleteMapping(path = {"prescriptionId"})
    @PreAuthorize("hasAnyRole('ROLE_DOCTOR', 'ROLE_ADMIN')")
    public void deletePrescription(@PathVariable("prescriptionId") Long prescriptionId){
        prescriptionService.deletePrescription(prescriptionId);
    }

}
