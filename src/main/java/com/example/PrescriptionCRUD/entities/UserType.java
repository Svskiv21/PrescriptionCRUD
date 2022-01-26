package com.example.PrescriptionCRUD.entities;

import com.example.PrescriptionCRUD.security.UserPermission;
import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.PrescriptionCRUD.security.UserPermission.*;

@Getter
@AllArgsConstructor
public enum UserType {
    DOCTOR(Sets.newHashSet(PRESCRIPTION_READ, PRESCRIPTION_WRITE)),
    PATIENT(Sets.newHashSet(PRESCRIPTION_READ)),
    ADMIN(Sets.newHashSet(GODMODE));

    private final Set<UserPermission> permissions;

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission->new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toSet());

        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
