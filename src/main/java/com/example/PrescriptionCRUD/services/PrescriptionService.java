package com.example.PrescriptionCRUD.services;

import com.example.PrescriptionCRUD.entities.Prescription;
import com.example.PrescriptionCRUD.repositories.MedicineRepository;
import com.example.PrescriptionCRUD.repositories.PrescriptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final MedicineRepository medicineRepository;

    public List<Prescription> getPrescriptions (){
        return prescriptionRepository.findAll();
    }

    public void addNewPrescription(Prescription prescription) {
        // zabezpieczenia
        prescriptionRepository.save(prescription);
    }

    public void deletePrescription(Long prescriptionId){
        prescriptionRepository.deleteById(prescriptionId);
    }

//    @Transactional
//    public void updatePrescription(Long prescriptionId, Set<Medicine> medicines, Patient patient, Doctor doctor, Date expirationDate){
//        // dodać zabezpieczenia!!!
//        // jak edytować Set<Medicine> ??? do tego jakąś całą oddzielną logikę trzeba zrobić zapewne
//        Prescription prescription = prescriptionRepository.findById(prescriptionId);
//    }
}
