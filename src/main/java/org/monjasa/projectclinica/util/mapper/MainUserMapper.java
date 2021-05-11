package org.monjasa.projectclinica.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.monjasa.projectclinica.dto.mainuser.MainUserDetailedInfoDto;
import org.monjasa.projectclinica.model.mainuser.MainUser;

@Mapper(componentModel = "spring")
public interface MainUserMapper {

    @Mapping(source = "genderIso.designation", target = "gender")
    MainUserDetailedInfoDto toShortInfoDto(MainUser mainUser);
}
