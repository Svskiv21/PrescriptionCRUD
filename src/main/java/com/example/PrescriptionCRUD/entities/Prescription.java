package com.example.PrescriptionCRUD.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Data
@NoArgsConstructor
public class Prescription {

    @Id
    @SequenceGenerator(name = "prescription_sequence", sequenceName = "prescription_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prescription_sequence")
    private Long id;

    @NonNull
    private List<Medicine> medicines;

    @NonNull
    private Patient patient;

    @NonNull
    private Doctor doctor;

    @NonNull
    private Date dateOfIssue;

    @NonNull
    private Date expirationDate;
}
