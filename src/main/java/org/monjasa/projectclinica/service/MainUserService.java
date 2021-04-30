package org.monjasa.projectclinica.service;

import org.monjasa.projectclinica.dto.MainUserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MainUserService {

    Page<MainUserDto> getMainUsers(Pageable pageable);
}
