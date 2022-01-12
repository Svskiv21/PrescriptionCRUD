package com.example.PrescriptionCRUD.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PrescriptionShowDTO {

    private Long id;

    private DoctorShowDTO doctor;

    private PatientShowDTO patient;

    private List<MedicineCreateDTO> medicineList;

    private LocalDate dateOfIssue;

    private LocalDate expirationDate;
}
