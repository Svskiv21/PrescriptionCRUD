package com.example.PrescriptionCRUD.mappers;

import com.example.PrescriptionCRUD.dtos.MedicineCreateDTO;
import com.example.PrescriptionCRUD.entities.Medicine;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MedicineMapper {

    public static final MedicineMapper INSTANCE = Mappers.getMapper(MedicineMapper.class);

    public Medicine medicineDTOtoMedicine(MedicineCreateDTO medicineDTO);

    public MedicineCreateDTO medicineToMedicineDTO(Medicine medicine);
}
