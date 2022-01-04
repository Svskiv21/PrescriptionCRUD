package com.example.PrescriptionCRUD.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table
@Data
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
}
