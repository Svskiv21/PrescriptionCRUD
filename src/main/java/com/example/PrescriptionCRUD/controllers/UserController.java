package com.example.PrescriptionCRUD.controllers;

import com.example.PrescriptionCRUD.dtos.UserDTO;
import com.example.PrescriptionCRUD.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/registration")
    @PreAuthorize("hasAnyRole('ROLE_DOCTOR', 'ROLE_PATIENT', 'ROLE_ADMIN')")
    public void register(@RequestBody UserDTO userDTO){
        userService.createUser(userDTO);
    }

    @PostMapping("/login")
    @PreAuthorize("hasAnyRole('ROLE_DOCTOR', 'ROLE_PATIENT', 'ROLE_ADMIN')")
    public void login(String pesel, String password){
        // body
    }

    @GetMapping("/{pesel}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Long getUserId(@PathVariable String pesel){
        return userService.getUserId(pesel);
    }
}
