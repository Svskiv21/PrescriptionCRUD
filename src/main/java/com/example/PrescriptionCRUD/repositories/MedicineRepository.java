package com.example.PrescriptionCRUD.repositories;

import com.example.PrescriptionCRUD.entities.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

    Optional<Medicine> findByName(String name);

    List<Medicine> findAllByIdIn(List<Long> list);
}
