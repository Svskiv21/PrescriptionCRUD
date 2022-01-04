package com.example.PrescriptionCRUD.controllers;

import com.example.PrescriptionCRUD.entities.Prescription;
import com.example.PrescriptionCRUD.services.PrescriptionService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping(path = "/prescriptions/")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    @GetMapping
    public List<Prescription> getPrescriptions(){
        return prescriptionService.getPrescriptions();
    }

    @PostMapping
    public void addNewPrescription(Prescription prescription){
        prescriptionService.addNewPrescription(prescription);
    }

    @DeleteMapping(path = {"prescriptionId"})
    public void deletePrescription(@PathVariable("prescriptionId") Long prescriptionId){
        prescriptionService.deletePrescription(prescriptionId);
    }

}
