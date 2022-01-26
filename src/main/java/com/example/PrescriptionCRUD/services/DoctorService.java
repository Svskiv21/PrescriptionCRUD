package com.example.PrescriptionCRUD.services;

import com.example.PrescriptionCRUD.dtos.DoctorCreateDTO;
import com.example.PrescriptionCRUD.dtos.DoctorShowDTO;
import com.example.PrescriptionCRUD.entities.Doctor;
import com.example.PrescriptionCRUD.mappers.DoctorMapper;
import com.example.PrescriptionCRUD.repositories.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public List<DoctorShowDTO> getDoctors() {
        List<Doctor> doctorList = doctorRepository.findAll();
        return doctorList.stream().map(DoctorMapper.INSTANCE::doctorToDoctorShowDTO).collect(Collectors.toList());
    }

    public void addNewDoctor(DoctorCreateDTO doctorCreateDTO) {
//        Optional<Doctor> doctorOptional = doctorRepository.findByPesel(doctorCreateDTO.getPesel());

//        if (doctorOptional.isEmpty()){
//            Doctor doctor = doctorOptional.get();
//            if(doctorCreateDTO.getPesel() != null && doctorCreateDTO.getPesel().length() > 0){
//                doctor.setPesel(doctorCreateDTO.getPesel());
//            } else {
//                throw new IllegalStateException("Invalid pesel!");
//            }
//            if (doctorCreateDTO.getName())
//        }
        Optional<Doctor> doctorOptional = doctorRepository.findByPesel(doctorCreateDTO.getPesel());
        if (doctorOptional.isEmpty()) {
            doctorRepository.save(DoctorMapper.INSTANCE.doctorDTOtoDoctor(doctorCreateDTO));
        } else {
            throw new IllegalStateException("This doctor already exists in database! ");
        }
    }

    public void deleteDoctor(Long doctorId) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);
        if (doctorOptional.isPresent()) {
            doctorRepository.deleteById(doctorId);
        } else {
            throw new IllegalStateException("This doctor does not exist in database! ");
        }
    }

    @Transactional
    public void updateDoctor(Long doctorId, String name, String lastName) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new IllegalStateException("Doctor with id: " + doctorId + " does not exist in database"));
        if (name != null && !name.isEmpty() && !Objects.equals(doctor.getName(), name)){
            doctor.setName(name);
        } else {
            throw new IllegalStateException("Invalid name provided!");
        }
        if (lastName != null && !lastName.isEmpty() && !Objects.equals(doctor.getLastName(), lastName)) {
            doctor.setLastName(lastName);
        } else {
            throw new IllegalStateException("Invalid last name provided!");
        }
    }

    public DoctorShowDTO getDoctor(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new IllegalStateException("Doctor does not exist in database!"));
        return DoctorMapper.INSTANCE.doctorToDoctorShowDTO(doctor);
    }
}
