package com.example.PrescriptionCRUD.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PrescriptionShowDTO {

    private DoctorShowDTO doctor;
    private PatientShowDTO patient;
    // medicines
    private LocalDate dateOfIssue;
    private LocalDate dateOfExpiration;

}
