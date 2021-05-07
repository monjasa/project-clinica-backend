package org.monjasa.projectclinica.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.monjasa.projectclinica.dto.MainUserShortInfoDto;
import org.monjasa.projectclinica.model.MainUser;

@Mapper(componentModel = "spring")
public interface MainUserMapper {

    @Mapping(source = "genderIso.designation", target = "gender")
    MainUserShortInfoDto toShortInfoDto(MainUser mainUser);
}
