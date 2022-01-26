package com.example.PrescriptionCRUD.services;

import com.example.PrescriptionCRUD.dtos.UserDTO;
import com.example.PrescriptionCRUD.entities.UserType;
import com.example.PrescriptionCRUD.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PatientService patientService;
    private final DoctorService doctorService;

    public void createUser(UserDTO userDTO){
        if (userDTO.getUserType() == UserType.DOCTOR){

        } else {

        }
    }
}
