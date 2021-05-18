package org.monjasa.projectclinica.util.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.monjasa.projectclinica.dto.NamedIdentificationDto;
import org.monjasa.projectclinica.dto.patient.PatientDetailedInfoDto;
import org.monjasa.projectclinica.dto.patient.PatientMedicalRecordShortInfoDto;
import org.monjasa.projectclinica.model.mainuser.MainUser;
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

    NamedIdentificationDto toNamedIdentificationDto(Patient patient);

    @AfterMapping
    default void afterToNamedIdentificationDto(
            Patient patient,
            @MappingTarget NamedIdentificationDto namedIdentificationDto
    ) {
        MainUser mainUser = patient.getMainUser();
        namedIdentificationDto.setName(mainUser.getFirstName() + " " + mainUser.getLastName());
    }
}
