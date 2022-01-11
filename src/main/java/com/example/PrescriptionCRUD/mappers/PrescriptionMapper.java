package com.example.PrescriptionCRUD.mappers;

import com.example.PrescriptionCRUD.dtos.PrescriptionCreateDTO;
import com.example.PrescriptionCRUD.entities.Prescription;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PrescriptionMapper {

    public static final PrescriptionMapper INSTANCE = Mappers.getMapper(PrescriptionMapper.class);

    public Prescription prescriptionDTOtoPrescription (PrescriptionCreateDTO prescriptionDTO);

    public PrescriptionCreateDTO prescriptionToPrescriptionDTO (Prescription prescription);
}
