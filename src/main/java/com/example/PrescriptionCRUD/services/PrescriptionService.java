package com.example.PrescriptionCRUD.services;

import com.example.PrescriptionCRUD.entities.Doctor;
import com.example.PrescriptionCRUD.entities.Patient;
import com.example.PrescriptionCRUD.entities.Prescription;
import com.example.PrescriptionCRUD.repositories.DoctorRepository;
import com.example.PrescriptionCRUD.repositories.MedicineRepository;
import com.example.PrescriptionCRUD.repositories.PatientRepository;
import com.example.PrescriptionCRUD.repositories.PrescriptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final MedicineRepository medicineRepository;

    public List<Prescription> getPrescriptions (){
        return prescriptionRepository.findAll();
    }

    public void addNewPrescription(Prescription prescription) {
        Optional<Doctor> doctorOptional = doctorRepository.findByName(prescription.getDoctor().getName());
        Optional<Patient> patientOptional = patientRepository.findByPesel(prescription.getPatient().getPesel());
        if (doctorOptional.isPresent()){
            Doctor doctor = doctorOptional.get();
            if (Objects.equals(doctor.getLastName(), prescription.getDoctor().getLastName())){

            }
        }
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
