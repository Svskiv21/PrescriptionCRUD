package com.example.PrescriptionCRUD.repositories;

import com.example.PrescriptionCRUD.entities.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

}
