package com.example.PrescriptionCRUD.services;

import com.example.PrescriptionCRUD.entities.Patient;
import com.example.PrescriptionCRUD.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public List<Patient> getAllPatients (){
        return patientRepository.findAll();
    }

    public void addPatient(Patient patient){
        patientRepository.save(patient);
    }

    public void deletePatient(Long patientId){
        patientRepository.deleteById(patientId);
    }


}

