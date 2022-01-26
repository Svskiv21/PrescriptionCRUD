package com.example.PrescriptionCRUD.mappers;

import com.example.PrescriptionCRUD.dtos.PrescriptionCreateDTO;
import com.example.PrescriptionCRUD.dtos.PrescriptionShowDTO;
import com.example.PrescriptionCRUD.entities.Medicine;
import com.example.PrescriptionCRUD.entities.Prescription;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {PatientMapper.class, DoctorMapper.class, MedicineMapper.class})
public interface PrescriptionMapper {

    public static final PrescriptionMapper INSTANCE = Mappers.getMapper(PrescriptionMapper.class);

    Prescription prescriptionDTOtoPrescription (PrescriptionCreateDTO prescriptionDTO);

//    @Mapping(source = "prescription.doctor.id", target = "doctorId")
//    @Mapping(source = "prescription.patient.id", target = "patientId")
    @Mapping(source = "prescription.medicines", target = "medicineList")
    PrescriptionShowDTO prescriptionToPrescriptionDTO (Prescription prescription);

    @Named("test123")
    static List<Long> test123(Prescription prescription) {
        return prescription.getMedicines().stream().map(Medicine::getId).collect(Collectors.toList());
    }
}
