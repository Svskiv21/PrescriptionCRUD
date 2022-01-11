package com.example.PrescriptionCRUD.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PrescriptionShowDTO {

    private Long id;

    private Long doctorId;

    private Long patientId;

    private List<Long> medicineIds;

    private LocalDate dateOfIssue;

    private LocalDate expirationDate;
}
