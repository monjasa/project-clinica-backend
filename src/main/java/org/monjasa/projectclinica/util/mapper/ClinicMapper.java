package org.monjasa.projectclinica.util.mapper;

import org.mapstruct.Mapper;
import org.monjasa.projectclinica.dto.NamedIdentificationDto;
import org.monjasa.projectclinica.model.clinic.Clinic;

@Mapper(componentModel = "spring")
public interface ClinicMapper {

    NamedIdentificationDto toNamedIdentificationDto(Clinic clinic);
}
