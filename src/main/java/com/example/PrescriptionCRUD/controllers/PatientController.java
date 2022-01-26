package com.example.PrescriptionCRUD.controllers;

import com.example.PrescriptionCRUD.dtos.PatientCreateDTO;
import com.example.PrescriptionCRUD.dtos.PatientShowDTO;
import com.example.PrescriptionCRUD.services.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@AllArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping(path = "/all-patients")
    public List<PatientShowDTO> getPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("/all-patients/{id}")
    public PatientShowDTO getSinglePatient(@PathVariable Long id){
        return patientService.getPatient(id);
    }

    @PostMapping(path = "/new-patient")
    public void addPatient(@RequestBody PatientCreateDTO patientCreateDTO){
        patientService.addPatient(patientCreateDTO);
    }

    @DeleteMapping(path = "all-patients/{id}")
    public void deletePatient(@PathVariable("id") Long patientId){
        patientService.deletePatient(patientId);
    }

    @PutMapping(path = "/{patientId}")
    public void updatePatient(@PathVariable Long patientId, @RequestParam String name, @RequestParam String lastName){
        patientService.updatePatient(patientId, name, lastName);
    }
}
