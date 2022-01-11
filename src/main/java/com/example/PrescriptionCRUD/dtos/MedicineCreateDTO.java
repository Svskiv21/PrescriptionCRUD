package com.example.PrescriptionCRUD.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicineCreateDTO {

    private Long id;

    private String name;

    private String description;
}
