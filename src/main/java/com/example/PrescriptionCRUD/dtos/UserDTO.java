package com.example.PrescriptionCRUD.dtos;

import com.example.PrescriptionCRUD.entities.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private UserType userType;

    private String pesel;

    private String password;

    private String name;

    private String lastName;
}
