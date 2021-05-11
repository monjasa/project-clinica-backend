package org.monjasa.projectclinica.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.monjasa.projectclinica.dto.patient.PatientDetailedInfoDto;
import org.monjasa.projectclinica.dto.patient.PatientMedicalRecordShortInfoDto;
import org.monjasa.projectclinica.model.patient.Patient;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    @Mapping(source = "mainUser.firstName", target = "firstName")
    @Mapping(source = "mainUser.lastName", target = "lastName")
    @Mapping(source = "medicalRecord.height", target = "height")
    @Mapping(source = "medicalRecord.weight", target = "weight")
    @Mapping(source = "medicalRecord.bloodType.name", target = "bloodType")
    PatientMedicalRecordShortInfoDto toMedicalRecordTableRowDto(Patient patient);

    @Mapping(source = "mainUser", target = "user")
    @Mapping(source = "mainUser.genderIso.designation", target = "user.gender")
    @Mapping(source = "medicalRecord.bloodType.name", target = "medicalRecord.bloodType")
    PatientDetailedInfoDto toDetailedInfoDto(Patient patient);
}
