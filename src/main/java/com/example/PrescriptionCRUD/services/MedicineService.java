package com.example.PrescriptionCRUD.services;

import com.example.PrescriptionCRUD.entities.Medicine;
import com.example.PrescriptionCRUD.repositories.MedicineRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Data
@Service
public class MedicineService {

    private final MedicineRepository medicineRepository;

    public List<Medicine> getAllMeds (){
        return medicineRepository.findAll();
    }

    public void addNewMedicine(Medicine medicine){
        Optional<Medicine> medicineOptional = medicineRepository.findByName(medicine.getName());
        if (medicineOptional.isPresent()){
            throw new IllegalStateException("This medicine already exists in database!");
        } else {
            medicineRepository.save(medicine);
        }
    }

    public void deleteMedicine(Long medicineId){
        Optional<Medicine> medicineOptional = medicineRepository.findById(medicineId);
        if (medicineOptional.isPresent()){
            medicineRepository.deleteById(medicineId);
        } else {
            throw new IllegalStateException("This medicine is not present in database.");
        }
    }

    @Transactional
    public void updateMedicine(Long medicineId, String name, String description){
        if (medicineRepository.findById(medicineId).isPresent()){
            Medicine medicine = medicineRepository.getById(medicineId);
            if (name != null && !name.isEmpty() && Objects.equals(medicine.getName(), name)){
                medicine.setName(name);
            } else {
                throw  new IllegalStateException("Invalid name.");
            }
            if (description != null && !description.isEmpty() && Objects.equals(medicine.getDescription(), description))
            {
                medicine.setDescription(description);
            } else {
                throw new IllegalStateException("Invalid description.");
            }
        }
    }
}
