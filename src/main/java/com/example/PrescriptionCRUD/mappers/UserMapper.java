package com.example.PrescriptionCRUD.mappers;

import com.example.PrescriptionCRUD.dtos.DoctorCreateDTO;
import com.example.PrescriptionCRUD.dtos.PatientCreateDTO;
import com.example.PrescriptionCRUD.dtos.UserDTO;
import com.example.PrescriptionCRUD.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {PatientMapper.class, DoctorMapper.class})
public interface UserMapper {

    static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userDTOtoUser(UserDTO userDTO);

    DoctorCreateDTO userDTOtoDoctorDTO(UserDTO userDTO);

    PatientCreateDTO userDTOtoPatientDTO(UserDTO userDTO);
}
