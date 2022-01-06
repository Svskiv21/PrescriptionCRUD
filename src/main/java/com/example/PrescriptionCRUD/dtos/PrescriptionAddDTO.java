package com.example.PrescriptionCRUD.dtos;

import com.example.PrescriptionCRUD.entities.Medicine;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PrescriptionAddDTO {

    private Long doctorId;
    private Long patientId;
//    private List<MedicineDTO> medicines;

}
