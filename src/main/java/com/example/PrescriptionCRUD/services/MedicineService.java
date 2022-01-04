package com.example.PrescriptionCRUD.services;

import com.example.PrescriptionCRUD.entities.Medicine;
import com.example.PrescriptionCRUD.repositories.MedicineRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Data
@Service
public class MedicineService {

    private final MedicineRepository medicineRepository;

    public List<Medicine> getAllMeds (){
        return medicineRepository.findAll();
    }

    public void addNewMedicine(Medicine medicine){
        medicineRepository.save(medicine);
    }

    public void deleteMedicine(Long medicineId){
        medicineRepository.deleteById(medicineId);
    }

    @Transactional
    public void updateMedicine(Long medicineId, String name, String description){
        Medicine medicine = medicineRepository.getById(medicineId);
        medicine.setName(name);
        medicine.setDescription(description);
    }
}
