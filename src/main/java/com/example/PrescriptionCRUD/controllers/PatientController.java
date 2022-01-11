package com.example.PrescriptionCRUD.controllers;

import com.example.PrescriptionCRUD.dtos.PatientCreateDTO;
import com.example.PrescriptionCRUD.entities.Patient;
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
    public List<PatientCreateDTO> getPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping(path = "/all-patients/{id}", produces = "application/json")
    public Patient getSinglePatient(@PathVariable("id") Long id){
        return patientService.getOnePatient(id);
    }

    @PostMapping(path = "/new-patient")
    public void addPatient(Patient patient){
        patientService.addPatient(patient);
    }

    @DeleteMapping(path = "all-patients/{id}")
    public void deletePatient(@PathVariable("id") Long patientId){
        patientService.deletePatient(patientId);
    }

    @PutMapping(path = "/{id}")
    public void updatePatient(@PathVariable("id") Long patientId, @RequestParam(required = false) String name, @RequestParam(required = false) String lastName){
        patientService.updatePatient(patientId, name, lastName);
    }
}
