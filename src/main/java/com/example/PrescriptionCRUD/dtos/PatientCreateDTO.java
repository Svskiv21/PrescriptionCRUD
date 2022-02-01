package com.example.PrescriptionCRUD.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientCreateDTO {

//    private Long id;

    private String name;

    private String lastName;

    private String pesel;
}
