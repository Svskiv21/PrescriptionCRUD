package com.example.PrescriptionCRUD.services;

import com.example.PrescriptionCRUD.entities.Patient;
import com.example.PrescriptionCRUD.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public Patient getOnePatient(Long patientId){
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        if (optionalPatient.isPresent()){
            return optionalPatient.get();
        } else {
            throw new IllegalStateException("There is no patient with id: " + patientId + " in database.");
        }
    }

    public List<Patient> getAllPatients (){
        return patientRepository.findAll();
    }

    public void addPatient(Patient patient){
        Optional<Patient> patientOptional = patientRepository.findByPesel(patient.getPesel());
        if (patientOptional.isPresent()){
            patientRepository.save(patient);
        } else {
            throw new IllegalStateException("Patient already exists in database.");
        }
    }

    public void deletePatient(Long patientId){
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if (patientOptional.isPresent()){
            patientRepository.deleteById(patientId);
        } else {
            throw new IllegalStateException("This patient is not present in database.");
        }
    }

    @Transactional
    public void updatePatient(Long patientId, String name, String lastName){
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if (patientOptional.isPresent()){
            Patient patient = patientOptional.get();
            if (name != null && !name.isEmpty() && !Objects.equals(patient.getName(), name)){
                patient.setName(name);
            } else {
                throw new IllegalStateException("Invalid name provided!");
            }

            if (lastName != null && !lastName.isEmpty() && !Objects.equals(patient.getLastName(), lastName)) {
                patient.setLastName(lastName);
            } else {
                throw new IllegalStateException("Invalid last name provided!");
            }
        } else {
            throw new IllegalStateException("This patient does not exist in database! ");
        }
        }

}

