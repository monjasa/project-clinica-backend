package org.monjasa.projectclinica.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.monjasa.projectclinica.dto.PatientMedicalRecord;
import org.monjasa.projectclinica.model.Patient;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    @Mapping(source = "mainUser.firstName", target = "firstName")
    @Mapping(source = "mainUser.lastName", target = "lastName")
    @Mapping(source = "medicalRecord.height", target = "height")
    @Mapping(source = "medicalRecord.weight", target = "weight")
    @Mapping(source = "medicalRecord.bloodType.name", target = "bloodType")
    PatientMedicalRecord toMedicalRecordTableRowDto(Patient patient);
}
