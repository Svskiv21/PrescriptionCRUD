package com.example.PrescriptionCRUD.controllers;


import com.example.PrescriptionCRUD.dtos.MedicineCreateDTO;
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
    public List<MedicineCreateDTO> showAllMedicines(){
        return medicineService.getMedicines();
    }

    @GetMapping("{medicineId}")
    public MedicineCreateDTO showMedicine(@PathVariable Long medicineId){
        return medicineService.getMedicine(medicineId);
    }

    @PostMapping
    public void addNewMedicine(@RequestBody MedicineCreateDTO medicineCreateDTO){
        medicineService.addNewMedicine(medicineCreateDTO);
    }

    @PutMapping("{medicineId}")
    public void updateMedicine(@PathVariable Long medicineId, @RequestParam(required = false) String name, @RequestParam(required = false) String description){
        medicineService.updateMedicine(medicineId, name, description);
    }

    @DeleteMapping("{medicineId}")
    public void deleteMedicine(@PathVariable Long medicineId){
        medicineService.deleteMedicine(medicineId);
    }
}
