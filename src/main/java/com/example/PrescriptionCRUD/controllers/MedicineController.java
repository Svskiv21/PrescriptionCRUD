package com.example.PrescriptionCRUD.controllers;


import com.example.PrescriptionCRUD.dtos.MedicineCreateDTO;
import com.example.PrescriptionCRUD.services.MedicineService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicines")
@AllArgsConstructor
public class MedicineController {

    private final MedicineService medicineService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public List<MedicineCreateDTO> showAllMedicines(){
        return medicineService.getMedicines();
    }

    @GetMapping("{medicineId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public MedicineCreateDTO showMedicine(@PathVariable Long medicineId){
        return medicineService.getMedicine(medicineId);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void addNewMedicine(@RequestBody MedicineCreateDTO medicineCreateDTO){
        medicineService.addNewMedicine(medicineCreateDTO);
    }

    @PutMapping("{medicineId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void updateMedicine(@PathVariable Long medicineId, @RequestParam(required = false) String name, @RequestParam(required = false) String description){
        medicineService.updateMedicine(medicineId, name, description);
    }

    @DeleteMapping("{medicineId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void deleteMedicine(@PathVariable Long medicineId){
        medicineService.deleteMedicine(medicineId);
    }
}
