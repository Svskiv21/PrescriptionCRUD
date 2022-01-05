package com.example.PrescriptionCRUD.entities;


import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Medicine {

    @Id
    @SequenceGenerator(name = "medicine_sequence", sequenceName = "medicine_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medicine_sequence")
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String description;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prescription_id", referencedColumnName = "id")
    private Prescription prescription;
}
