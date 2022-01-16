package com.example.PrescriptionCRUD.services;

import com.example.PrescriptionCRUD.dtos.MedicineCreateDTO;
import com.example.PrescriptionCRUD.entities.Medicine;
import com.example.PrescriptionCRUD.mappers.MedicineMapper;
import com.example.PrescriptionCRUD.repositories.MedicineRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class MedicineService {

    private final MedicineRepository medicineRepository;

    public List<MedicineCreateDTO> getMedicines(){
        List<Medicine> medicines = medicineRepository.findAll();
        return medicines.stream().map(MedicineMapper.INSTANCE::medicineToMedicineDTO).collect(Collectors.toList());
    }

    @Transactional
    public void addNewMedicine(MedicineCreateDTO medicineCreateDTO){
        Optional<Medicine> medicineOptional = medicineRepository.findByName(medicineCreateDTO.getName());
        if (medicineOptional.isPresent()){
            throw new IllegalStateException("This medicine already exists in database!");
        } else {
            medicineRepository.save(MedicineMapper.INSTANCE.medicineDTOtoMedicine(medicineCreateDTO));
        }
    }

    @Transactional
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
        Medicine medicine = medicineRepository.findById(medicineId)
                .orElseThrow(() -> new IllegalStateException("Medicine not found in database!"));
        if (name != null && !name.isEmpty() && !medicine.getName().equals(name)){
            medicine.setName(name);
        } else {
            throw  new IllegalStateException("Invalid name.");
        }
        if (description != null && !description.isEmpty() && !medicine.getDescription().equals(description))
        {
            medicine.setDescription(description);
        } else {
            throw new IllegalStateException("Invalid description.");
        }
    }

    public MedicineCreateDTO getMedicine(Long medicineId) {
        Medicine medicine = medicineRepository.findById(medicineId)
                .orElseThrow(() -> new IllegalStateException("Medicine not found in data base!"));
        return MedicineMapper.INSTANCE.medicineToMedicineDTO(medicine);
    }
}
