package com.example.PrescriptionCRUD.services;

import com.example.PrescriptionCRUD.entities.Doctor;
import com.example.PrescriptionCRUD.repositories.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public List<Doctor> getDoctors() {
        return doctorRepository.findAll();
    }

    public void addNewDoctor(Doctor doctor) {
        Optional<Doctor> doctorOptional = doctorRepository.findByPesel(doctor.getPesel());
        if (doctorOptional.isEmpty()) {
            doctorRepository.save(doctor);
        } else {
            throw new IllegalStateException("This doctor already exists in database! ");
        }
    }

    public void deleteDoctor(Long doctorId) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);
        if (doctorOptional.isPresent()) {
            doctorRepository.deleteById(doctorId);
        } else {
            throw new IllegalStateException("This doctor does not exist in database! ");
        }
    }

    @Transactional
    public void updateDoctor(Long doctorId, String name, String lastName) {
        Doctor doctor = doctorRepository.getById(doctorId);
        if (doctorRepository.findById(doctorId).isPresent()) {
            if (name != null && !name.isEmpty() && !Objects.equals(doctor.getName(), name)){
                doctor.setName(name);
            } else {
                throw new IllegalStateException("Invalid name provided!");
            }

            if (lastName != null && !lastName.isEmpty() && !Objects.equals(doctor.getLastName(), lastName)) {
                doctor.setLastName(lastName);
            } else {
                throw new IllegalStateException("Invalid last name provided!");
            }
        } else {
            throw new IllegalStateException("This doctor does not exist in database! ");
        }
    }
}
