package org.monjasa.projectclinica.util.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.monjasa.projectclinica.model.MainUser;
import org.monjasa.projectclinica.dto.MainUserShortInfoDto;

@Mapper(componentModel = "spring")
public interface MainUserMapper {

    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    MainUser toEntity(MainUserShortInfoDto mainUserShortInfoDto);

    @Mapping(source = "genderIso.designator", target = "gender")
    MainUserShortInfoDto toDto(MainUser mainUser);

    @AfterMapping
    default void afterToDto(MainUser mainUser, @MappingTarget MainUserShortInfoDto mainUserShortInfoDto) {
        mainUserShortInfoDto.setFullName(mainUser.getFirstName() + " " + mainUser.getLastName());
    }
}
