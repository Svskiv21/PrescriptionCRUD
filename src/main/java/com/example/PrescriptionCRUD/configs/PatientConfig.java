package com.example.PrescriptionCRUD.configs;

import com.example.PrescriptionCRUD.entities.Patient;
import com.example.PrescriptionCRUD.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PatientConfig {

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            Patient delilah = new Patient("Delilah", "Caldwin", "00254568523");
            Patient tom = new Patient("Tom", "Nook", "95254568523");

            patientRepository.saveAll(List.of(delilah, tom));
        };
    }
}
