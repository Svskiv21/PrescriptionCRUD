package com.example.PrescriptionCRUD.mappers;

import com.example.PrescriptionCRUD.dtos.DoctorCreateDTO;
import com.example.PrescriptionCRUD.entities.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DoctorMapper {

    public static final DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    public Doctor doctorDTOtoDoctor(DoctorCreateDTO doctorDTO);

    public DoctorCreateDTO doctorToDoctorDTO(Doctor doctor);
}
