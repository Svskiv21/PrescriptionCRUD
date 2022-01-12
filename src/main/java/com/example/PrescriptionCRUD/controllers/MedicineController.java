package com.example.PrescriptionCRUD.controllers;


import com.example.PrescriptionCRUD.entities.Medicine;
import com.example.PrescriptionCRUD.services.MedicineService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicines")
@AllArgsConstructor
public class MedicineController {

    private final MedicineService medicineService;

    @GetMapping
    public List<Medicine> showAllMedicines(Medicine medicine){
        return medicineService.getAllMeds();
    }

    @PostMapping
    public void addNewMedicine(@RequestBody Medicine medicine){
        medicineService.addNewMedicine(medicine);
    }

    @DeleteMapping("{medicineId}")
    public void deleteMedicine(@PathVariable Long medicineId){
        medicineService.deleteMedicine(medicineId);
    }
}
