package org.monjasa.projectclinica.util.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.monjasa.projectclinica.model.MainUser;
import org.monjasa.projectclinica.dto.MainUserDto;

@Mapper(componentModel = "spring")
public interface MainUserMapper {

    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    MainUser toEntity(MainUserDto mainUserDto);

    @InheritInverseConfiguration
    MainUserDto toDto(MainUser mainUser);
}
