package com.example.PrescriptionCRUD.configs;

import com.example.PrescriptionCRUD.entities.Patient;
import com.example.PrescriptionCRUD.entities.User;
import com.example.PrescriptionCRUD.repositories.PatientRepository;
import com.example.PrescriptionCRUD.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PatientConfig {

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository, UserRepository userRepository){
        return args -> {
            Patient delilah = new Patient("Delilah", "Caldwin", "00254568523");
            Patient tom = new Patient("Tom", "Nook", "95254568523");
            User jan = new User("jan", "password");

            patientRepository.saveAll(List.of(delilah, tom));
            userRepository.save(jan);
        };
    }
}
