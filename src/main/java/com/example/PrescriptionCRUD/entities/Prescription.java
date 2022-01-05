package com.example.PrescriptionCRUD.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Prescription {

    @Id
    @SequenceGenerator(name = "prescription_sequence", sequenceName = "prescription_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prescription_sequence")
    private Long id;

    @NonNull
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "prescription")
    @Column
    private List<Medicine> medicines;

    @NonNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    @NonNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;

    @NonNull
    @Column
    private Date dateOfIssue;

    @NonNull
    @Column
    private Date expirationDate;
}
