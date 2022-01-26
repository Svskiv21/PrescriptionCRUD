package com.example.PrescriptionCRUD.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserPermission {

    PRESCRIPTION_READ("prescription:read"),
    PRESCRIPTION_WRITE("prescription:write"),
    GODMODE("prescription:all-enabled");

    private final String permission;
}

