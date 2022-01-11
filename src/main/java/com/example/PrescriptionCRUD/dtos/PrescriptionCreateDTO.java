package com.example.PrescriptionCRUD.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PrescriptionCreateDTO {

    private Long id;

    private Long doctorId;

    private Long patientId;

    private List<Long> medicineIds;
}
