package com.example.PrescriptionCRUD.repositories;

import com.example.PrescriptionCRUD.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
