package com.example.PrescriptionCRUD.services;

import com.example.PrescriptionCRUD.dtos.PrescriptionCreateDTO;
import com.example.PrescriptionCRUD.dtos.PrescriptionShowDTO;
import com.example.PrescriptionCRUD.entities.Doctor;
import com.example.PrescriptionCRUD.entities.Medicine;
import com.example.PrescriptionCRUD.entities.Patient;
import com.example.PrescriptionCRUD.entities.Prescription;
import com.example.PrescriptionCRUD.mappers.PrescriptionMapper;
import com.example.PrescriptionCRUD.repositories.DoctorRepository;
import com.example.PrescriptionCRUD.repositories.MedicineRepository;
import com.example.PrescriptionCRUD.repositories.PatientRepository;
import com.example.PrescriptionCRUD.repositories.PrescriptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final MedicineRepository medicineRepository;

    public List<PrescriptionShowDTO> getPrescriptions (){
        List<Prescription> allPrescriptions = prescriptionRepository.findAll();
        return allPrescriptions.stream().map(PrescriptionMapper.INSTANCE::prescriptionToPrescriptionDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public void addNewPrescription(PrescriptionCreateDTO dto) {
        //metode walidująca
        Prescription prescription = validationMethod(dto);
        fillDates(prescription);
        prescriptionRepository.save(prescription);
    }

    private void fillDates(Prescription prescription) {
        prescription.setDateOfIssue(LocalDate.now());
        prescription.setExpirationDate(LocalDate.now().plusMonths(3));
    }

    public Prescription validationMethod(PrescriptionCreateDTO dto) {
        Prescription prescription = new Prescription();

        Doctor doctor = doctorRepository.findById(dto.getDoctorId())
                .orElseThrow(() -> new IllegalStateException("Provided doctor does not exist in database!"));
        prescription.setDoctor(doctor);

        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new IllegalStateException("Provided patient does not exist in database!"));
        prescription.setPatient(patient);

        List<Medicine> medicineList = medicineRepository.findAllByIdIn(dto.getMedicineIds());
        if (medicineList.isEmpty()) {
            throw new IllegalStateException("Invalid medicines provided!");
        }

        medicineList.stream().map(Medicine::getId).forEach(medicine -> {
            boolean conditionFailed = dto.getMedicineIds().stream().noneMatch(id -> id.equals(medicine));
            if (conditionFailed) {
                throw new IllegalStateException();
            }
        });

        prescription.setMedicines(medicineList);

        return prescription;
    }

    @Transactional
    public void deletePrescription(Long prescriptionId){
        prescriptionRepository.deleteById(prescriptionId);
    }

}
