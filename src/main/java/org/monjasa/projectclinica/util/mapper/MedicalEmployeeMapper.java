package org.monjasa.projectclinica.util.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.monjasa.projectclinica.dto.NamedIdentificationDto;
import org.monjasa.projectclinica.model.employee.MedicalEmployee;
import org.monjasa.projectclinica.model.mainuser.MainUser;

@Mapper(componentModel = "spring")
public interface MedicalEmployeeMapper {

    NamedIdentificationDto toNamedIdentificationDto(MedicalEmployee medicalEmployee);

    @AfterMapping
    default void afterToNamedIdentificationDto(
            MedicalEmployee medicalEmployee,
            @MappingTarget NamedIdentificationDto namedIdentificationDto
    ) {
        MainUser mainUser = medicalEmployee.getMainUser();
        namedIdentificationDto.setName(mainUser.getFirstName() + " " + mainUser.getLastName());
    }
}
