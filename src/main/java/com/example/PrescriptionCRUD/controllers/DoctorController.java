package com.example.PrescriptionCRUD.controllers;

import com.example.PrescriptionCRUD.entities.Doctor;
import com.example.PrescriptionCRUD.services.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
@AllArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping
    public List<Doctor> showAllDoctors(Doctor doctor){
        return doctorService.getDoctors();
    }

    @PostMapping
    public void addNewDoctor(@RequestBody Doctor doctor){
        doctorService.addNewDoctor(doctor);
    }

    @DeleteMapping(path = {"doctorId"})
    public void deleteDoctor(@PathVariable("doctorId") Long doctorId){
        doctorService.deleteDoctor(doctorId);
    }
}
