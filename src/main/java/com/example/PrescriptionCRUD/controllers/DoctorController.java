package com.example.PrescriptionCRUD.controllers;

import com.example.PrescriptionCRUD.dtos.DoctorCreateDTO;
import com.example.PrescriptionCRUD.dtos.DoctorShowDTO;
import com.example.PrescriptionCRUD.services.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/doctors")
@AllArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("/all-doctors")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public List<DoctorShowDTO> showAllDoctors(){
        return doctorService.getDoctors();
    }

    @GetMapping("/{doctorId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public DoctorShowDTO showDoctor(@PathVariable Long doctorId){
        return doctorService.getDoctor(doctorId);
    }

//    @PostMapping
//    public void addNewDoctor(@RequestBody DoctorCreateDTO doctorCreateDTO){
//        doctorService.addNewDoctor(doctorCreateDTO);
//    }

    @DeleteMapping("{doctorId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void deleteDoctor(@PathVariable("doctorId") Long doctorId){
        doctorService.deleteDoctor(doctorId);
    }

    @PutMapping("{doctorId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void updateDoctor(@PathVariable Long doctorId, @RequestParam(required = false) String name,
                             @RequestParam(required = false) String lastName){
        doctorService.updateDoctor(doctorId, name, lastName);
    }
}
