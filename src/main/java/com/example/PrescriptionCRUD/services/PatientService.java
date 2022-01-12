package com.example.PrescriptionCRUD.services;

import com.example.PrescriptionCRUD.dtos.PatientCreateDTO;
import com.example.PrescriptionCRUD.dtos.PatientShowDTO;
import com.example.PrescriptionCRUD.entities.Patient;
import com.example.PrescriptionCRUD.mappers.PatientMapper;
import com.example.PrescriptionCRUD.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientShowDTO getPatient(Long patientId){

        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new IllegalStateException("There is no patient with id: " + patientId + " in database."));
        return PatientMapper.INSTANCE.patientToPatientShowDTO(patient);
    }

    public List<PatientShowDTO> getAllPatients (){

        List<Patient> patientList = patientRepository.findAll();
        return patientList.stream().map(PatientMapper.INSTANCE::patientToPatientShowDTO).collect(Collectors.toList());
    }

    @Transactional
    public void addPatient(PatientCreateDTO dto){
        Optional<Patient> patientOptional = patientRepository.findByPesel(dto.getPesel());
        if (patientOptional.isEmpty()){
            patientRepository.save(PatientMapper.INSTANCE.patientDTOtoPatient(dto));
        } else {
            throw new IllegalStateException("Patient already exists in database.");
        }
    }

    @Transactional
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

