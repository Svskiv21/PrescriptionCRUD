package com.example.PrescriptionCRUD.repositories;

import com.example.PrescriptionCRUD.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {


    Optional<Patient> findByPesel(String pesel);
}
