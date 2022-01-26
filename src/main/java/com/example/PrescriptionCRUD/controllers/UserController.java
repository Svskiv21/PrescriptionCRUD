package com.example.PrescriptionCRUD.controllers;

import com.example.PrescriptionCRUD.dtos.UserDTO;
import com.example.PrescriptionCRUD.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/registration")
    public void register(@RequestBody UserDTO userDTO){
        userService.createUser(userDTO);
    }

    @PostMapping("/login")
    public void login(String pesel, String password){
        // body
    }
}
