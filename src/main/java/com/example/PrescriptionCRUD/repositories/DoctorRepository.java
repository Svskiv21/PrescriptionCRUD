package com.example.PrescriptionCRUD.repositories;

import com.example.PrescriptionCRUD.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findByPesel(String pesel);
}
