package org.monjasa.projectclinica.service;

import org.monjasa.projectclinica.dto.MainUserShortInfoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MainUserService {

    Page<MainUserShortInfoDto> getMainUsers(Pageable pageable);
}
