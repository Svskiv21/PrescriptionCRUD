package com.example.PrescriptionCRUD.mappers;

import com.example.PrescriptionCRUD.dtos.PatientCreateDTO;
import com.example.PrescriptionCRUD.entities.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
// jesli nie mam jakiegos zmapowanego sourca/targeta to ignoruje zamiast rzucac błędem
public interface PatientMapper {

    public static final PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    PatientCreateDTO patientToPatientDTO(Patient patient);

    Patient patientDTOtoPatient(PatientCreateDTO patientCreateDTO);
}
