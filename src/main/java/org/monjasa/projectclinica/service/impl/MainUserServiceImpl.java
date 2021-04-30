package org.monjasa.projectclinica.service.impl;

import liquibase.sdk.Main;
import lombok.RequiredArgsConstructor;
import org.monjasa.projectclinica.dto.MainUserShortInfoDto;
import org.monjasa.projectclinica.model.MainUser;
import org.monjasa.projectclinica.model.Patient;
import org.monjasa.projectclinica.repository.MainUserRepository;
import org.monjasa.projectclinica.repository.PatientRepository;
import org.monjasa.projectclinica.service.MainUserService;
import org.monjasa.projectclinica.util.mapper.MainUserMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainUserServiceImpl implements MainUserService {

    private final MainUserRepository mainUserRepository;

    private final MainUserMapper mainUserMapper;

    @Override
    public Page<MainUserShortInfoDto> getMainUsers(Pageable pageable) {
        return mainUserRepository.findAll(pageable)
                .map(mainUserMapper::toDto);
    }
}
